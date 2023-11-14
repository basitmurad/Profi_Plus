package com.basit.profitplus.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.basit.profitplus.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;


public class LuckDrawsFragment extends BottomSheetDialogFragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_luck_draws, container, false);



    return  view;}
}