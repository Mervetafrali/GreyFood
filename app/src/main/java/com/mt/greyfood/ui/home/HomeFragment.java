package com.mt.greyfood.ui.home;

import android.os.Bundle;
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
import com.google.firebase.firestore.FirebaseFirestore;
import com.mt.greyfood.R;
import com.mt.greyfood.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private FirebaseFirestore db;
    RecyclerView rv;
    ArrayList<String> dataSource = new ArrayList<String>();
    LinearLayoutManager linearLayoutManager;
    MyRvAdapter myRvAdapter;
    private final ArrayList<String> kategoriler = new ArrayList<String>();
    private final ArrayList<String> markalar = new ArrayList<String>();
    private final ArrayList<String> coksatanlar = new ArrayList<String>();
    private final ArrayList<String> kampanyalar = new ArrayList<String>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        dataSource.add("https://www.linkpicture.com/q/dondurma.png");
        dataSource.add("https://www.linkpicture.com/q/kahve.jpeg");
        dataSource.add("https://www.linkpicture.com/q/icecek.jpeg");

        // initializing our variable for firebase
        // firestore and getting its instance.
        db = FirebaseFirestore.getInstance();
        rv = view.findViewById(R.id.rv);

        loadrecyclerViewData();
        linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        myRvAdapter = new MyRvAdapter(dataSource);
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(myRvAdapter);

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return view;
    }

    private void loadrecyclerViewData() {

        DocumentReference reference = db.collection("greyfood").document("ZS31llcNdXiWipkKHh6v");
        reference.get().addOnSuccessListener(snapshot -> {


            Log.i("firebase", "deneme" + snapshot.get("kategoriler"));
           /* dataModalArrayList.add(modelCourses1);
            dataRVAdapter = new AdapterCard(dataModalArrayList, getContext());
            courseRV.setAdapter(dataRVAdapter);*/
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}