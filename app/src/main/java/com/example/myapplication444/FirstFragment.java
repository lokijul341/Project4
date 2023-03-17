package com.example.myapplication444;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication444.databinding.FragmentFirstBinding;
public class FirstFragment extends Fragment implements View.OnClickListener {

    public FirstFragment() {
        super(R.layout.fragment_first);
    }

    private Button button1, button2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        button1 = view.findViewById(R.id.button);
        button2 = view.findViewById(R.id.button4);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        Fragment fragment = null;
        switch (v.getId()) {
            case R.id.button:
                fragment = new SecondFragment();
                break;
            case R.id.button4:
                fragment = new ThirdFragment();
                break;
        }
        if (fragment != null) {
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.replace(R.id.fragment_view, fragment);
            ft.addToBackStack(null);
            ft.commit();
        }
    }
}