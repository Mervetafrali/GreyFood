package com.mt.greyfood.ui.home;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.mt.greyfood.R;
import com.mt.greyfood.ui.adapter.BlogAdapter;
import com.mt.greyfood.ui.adapter.BrandAdapter;
import com.mt.greyfood.ui.adapter.CatalogAdapter;
import com.mt.greyfood.ui.adapter.Categori;
import com.mt.greyfood.ui.adapter.CategoriesAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    RecyclerView catalogrv;
    RecyclerView brandrv;
    RecyclerView categoryrv;
    RecyclerView blogrv;
    RecyclerView snackrv;
    LinearLayoutManager linearLayoutManager;
    LinearLayout layout;
    CatalogAdapter catalogAdapter;
    BrandAdapter brandAdapter;
    CategoriesAdapter categoryAdapter;
    BlogAdapter blogAdapter;
    View view;
    private FirebaseFirestore db;
    public List<SnackModel> snackItemList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);//Make sure you have this line of code.
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        db = FirebaseFirestore.getInstance();
        loadrecyclerViewData();
        linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        view = inflater.inflate(R.layout.fragment_home, container, false);
        layout = view.findViewById(R.id.catalogLinear);
        catalogrv = view.findViewById(R.id.catalogrv);
        brandrv = view.findViewById(R.id.brandrv);
        categoryrv = view.findViewById(R.id.categoryrv);
        blogrv = view.findViewById(R.id.blogrv);
        snackrv = view.findViewById(R.id.recycler);
        snackrv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        snackrv.setAdapter(new com.mt.greyfood.adapters.SnackAdapter(initSnackData(), getContext()));

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
                    catalogrv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
                    catalogrv.setAdapter(catalogAdapter);
                    //autoScroll();
                    brandAdapter = new BrandAdapter(imagesList.getMarkalar());
                    brandrv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
                    brandrv.setAdapter(brandAdapter);
                    /*List<Map<String, Categori>> address = (List<Map<String, Categori>>) document.getData().get("deneme");
                    Log.i("TAG",address.toString());*/
                    ArrayList itemList = new ArrayList<>();
                    itemList.add(new Categori("https://www.linkpicture.com/q/hanutaAtistirmalik.jpeg", "Atıştırmalık"));
                    itemList.add(new Categori("https://www.linkpicture.com/q/icecek.jpeg", "İçecekler"));
                    itemList.add(new Categori("https://www.linkpicture.com/q/gofret.jpeg", "Gofret"));
                    itemList.add(new Categori("https://www.linkpicture.com/q/hanutaAtistirmalik.jpeg", "Dondurma"));
                    itemList.add(new Categori("https://www.linkpicture.com/q/hanutaAtistirmalik.jpeg", "Çikolata"));
                    itemList.add(new Categori("https://www.linkpicture.com/q/kahve.jpeg", "Kahve"));
                    categoryAdapter = new CategoriesAdapter(itemList);
                    categoryrv.setLayoutManager(new GridLayoutManager(getContext(), 3));
                    categoryrv.setAdapter(categoryAdapter);

                    blogAdapter = new BlogAdapter(imagesList.getBlog());
                    blogrv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
                    blogrv.setAdapter(blogAdapter);

                } else {
                    Log.d("TAG", "No such document");
                }
            } else {
                Log.d("TAG", "get failed with ", task.getException());
            }
        });
    }


    public void autoScroll() {
        final int duration = 150;
        final int pixelsToMove = 150;
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
                            mHandler.postDelayed(SCROLLING_RUNNABLE, 1000);
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
        view = null;
    }

    private List<SnackModel> initSnackData() {

        snackItemList = new ArrayList<>();
        snackItemList.add(new SnackModel("https://www.linkpicture.com/q/hanutaAtistirmalik.jpeg", "Atıştırmalık"));
        snackItemList.add(new SnackModel("https://www.linkpicture.com/q/kahve.jpeg", "İçecekler"));
        snackItemList.add(new SnackModel("https://www.linkpicture.com/q/hanutaAtistirmalik.jpeg", "Atıştırmalık"));

        return snackItemList;
    }
}