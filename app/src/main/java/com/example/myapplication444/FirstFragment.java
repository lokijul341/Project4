package com.example.myapplication444;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication444.databinding.FragmentFirstBinding;
public class FirstFragment extends Fragment {
   FragmentFirstBinding binding;

    public FirstFragment() {
        super(R.layout.fragment_first);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//для перехода на второй экран
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction().
                        setReorderingAllowed(true);
                ft.replace(R.id.fragment_view, new SecondFragment());
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        binding.button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//для перехода на третий экран
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction().
                        setReorderingAllowed(true);
                ft.replace(R.id.fragment_view, new ThirdFragment());
                ft.addToBackStack(null);
                ft.commit();
            }
        });
        return binding.getRoot();

    }
}