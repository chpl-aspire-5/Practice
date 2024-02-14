package com.mycompany.practice;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class BottomSheetDialogFragment extends com.google.android.material.bottomsheet.BottomSheetDialogFragment {

    Button btnBig, btnSmall;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bottom_sheet_dialog, container, false);

        btnBig = view.findViewById(R.id.btnBig);
        btnSmall = view.findViewById(R.id.btnSmall);

        btnBig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(requireActivity(), "BIG BUTTON", Toast.LENGTH_SHORT).show();
                dismiss();
            }
        });
        btnSmall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(requireActivity(), "SMALL BUTTON", Toast.LENGTH_SHORT).show();
                dismiss();
            }
        });

        return view;
    }
}