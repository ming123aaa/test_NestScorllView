package com.example.test_nestscorllview;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class BlankFragment extends Fragment {

    private RecyclerView rv_main;
    private rvAdapter adapter;
    private List<String> list;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_blank, container, false);
        rv_main=view.findViewById(R.id.rv_fg);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        list = new ArrayList<>();

        adapter = new rvAdapter(getContext(), list);

        rv_main.setLayoutManager(layoutManager);
        rv_main.setAdapter(adapter);
        for (int i = 0; i < 40; i++) {
            list.add("你好啊" + i);
        }
        return view;
    }
}