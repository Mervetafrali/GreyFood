package com.mt.greyfood.ui.home;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.mt.greyfood.R;
import com.mt.greyfood.databinding.FragmentHomeBinding;
import com.mt.greyfood.ui.adapter.BrandAdapter;
import com.mt.greyfood.ui.adapter.CatalogAdapter;

public class HomeFragment extends Fragment {

    RecyclerView catalogrv;
    RecyclerView brandrv;
    LinearLayoutManager linearLayoutManager;
    CatalogAdapter catalogAdapter;
    BrandAdapter brandAdapter;
    private FragmentHomeBinding binding;
    private FirebaseFirestore db;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        db = FirebaseFirestore.getInstance();
        loadrecyclerViewData();
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        catalogrv = view.findViewById(R.id.catalogrv);
        brandrv = view.findViewById(R.id.brandrv);
        linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);


        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        return view;
    }

    private void loadrecyclerViewData() {

        DocumentReference reference = db.collection("greyfood").document("ZS31llcNdXiWipkKHh6v");
        reference.get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                DocumentSnapshot document = task.getResult();
                if (document.exists()) {
                    ImagesList imagesList = document.toObject(ImagesList.class);
                    catalogAdapter = new CatalogAdapter(imagesList.getKampanyalar());
                    catalogrv.setLayoutManager(linearLayoutManager);
                    catalogrv.setAdapter(catalogAdapter);
                    autoScroll();
                    //TODO: hatalı
                    brandAdapter = new BrandAdapter(imagesList.getMarkalar());
                    brandrv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
                    brandrv.setAdapter(brandAdapter);
                } else {
                    Log.d("TAG", "No such document");
                }
            } else {
                Log.d("TAG", "get failed with ", task.getException());
            }
        });
    }

    public void autoScroll() {
        final int duration = 10;
        final int pixelsToMove = 30;
        final Handler mHandler = new Handler(Looper.getMainLooper());
        final Runnable SCROLLING_RUNNABLE = new Runnable() {

            @Override
            public void run() {
                catalogrv.smoothScrollBy(pixelsToMove, 0);
                mHandler.postDelayed(this, duration);
            }
        };
        catalogrv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int lastItem = linearLayoutManager.findLastCompletelyVisibleItemPosition();
                if (lastItem == linearLayoutManager.getItemCount() - 1) {
                    mHandler.removeCallbacks(SCROLLING_RUNNABLE);
                    Handler postHandler = new Handler();
                    postHandler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            recyclerView.setAdapter(null);
                            recyclerView.setAdapter(catalogAdapter);
                            mHandler.postDelayed(SCROLLING_RUNNABLE, 2000);
                        }
                    }, 1000);
                }
            }
        });
        mHandler.postDelayed(SCROLLING_RUNNABLE, 1000);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}