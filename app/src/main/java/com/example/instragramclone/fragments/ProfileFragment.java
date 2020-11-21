package com.example.instragramclone.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.instragramclone.LoginActivity;
import com.example.instragramclone.R;
import com.parse.ParseUser;


public class ProfileFragment extends Fragment {

    private Button btnLogOut;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnLogOut = view.findViewById(R.id.btnLogOut);
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser.logOut();
                ParseUser currentUser = ParseUser.getCurrentUser();// this will now be null
                goLoginActivity();
                Toast.makeText(getContext(), "Sign out successful!", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void goLoginActivity() {
            Intent i = new Intent(getContext(), LoginActivity.class);
            startActivity(i);
        }
}