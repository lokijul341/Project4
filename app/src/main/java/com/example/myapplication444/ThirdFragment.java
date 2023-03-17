package com.example.myapplication444;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class ThirdFragment extends Fragment {

    private RecyclerView recyclerView;
    private ListAdapter2 adapter;
    private List<Item> listItems;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_third, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            // Определяем слушателя касания элемента в RecyclerView
            @Override
            public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                View child = rv.findChildViewUnder(e.getX(), e.getY());
                if (child != null && e.getAction() == MotionEvent.ACTION_UP) {
                    int position = rv.getChildAdapterPosition(child);
                    Item item = listItems.get(position);
                    Toast.makeText(getContext(), "Нажатие на: " + item.getText(), Toast.LENGTH_SHORT).show();
                    Log.d("ThirdFragment", "Нажатие на: " + item.getText());
                    return true;
                }
                return false;
            }
            @Override
            public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
            }
        });

// Инициализация списка
        listItems = new ArrayList<>();
        for (int i = 1; i <= 200; i++) {
            listItems.add(new Item(R.drawable.coffee2, "Кофе " + i));
        }

// Инициализация и назначение адаптера для списка
        adapter = new ListAdapter2(getActivity(), listItems);
        recyclerView.setAdapter(adapter);

        return view;
    }
}