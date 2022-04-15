package com.example.assignment.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.assignment.R;
import com.example.assignment.fragment.FetchingDataFragment;


public class HomeFragment extends Fragment {

    Button button;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        button = view.findViewById(R.id.data);

        // For moving one fragment to another fragment to get the data
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button.setVisibility(View.GONE);
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.home,new FetchingDataFragment());
                fr.commit();
            }
        });


        return view;
    }
}