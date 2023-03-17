package com.example.myapplication444;

import android.app.LauncherActivity;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class SecondFragment extends Fragment {


    public SecondFragment() {
        super(R.layout.fragment_second);
    }

    private ListView listView;
    private ListAdapter1 adapter;
    private List<Item> listItems;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        listView = view.findViewById(R.id.listView);

// Инициализация списка
        listItems = new ArrayList<>();
        for (int i = 1; i <= 200; i++) {
            listItems.add(new Item(R.drawable._27157, "Чай " + i));
        }

// Инициализация и назначение адаптера для списка
        adapter = new ListAdapter1(getActivity(), listItems);
        listView.setAdapter(adapter);

        return view;
    }
}
