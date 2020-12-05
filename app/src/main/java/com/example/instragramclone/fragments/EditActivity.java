package com.example.instragramclone.fragments;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.instragramclone.R;
import com.parse.ParseUser;

import java.util.Objects;
import java.util.jar.Attributes;

public class EditActivity extends AppCompatActivity {


    private TextView tvDone;
    private TextView tvCancel;

    private EditText etName;
    private EditText etUsername;
    private EditText etWebsite;
    private EditText etBio;
    //private UserSettings mUserSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        final ActionBar actionBar = getSupportActionBar(); // or getActionBar();

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.edit_done_cancel);
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#F1F1F1")));

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        etName = findViewById(R.id.etName);
        etUsername = findViewById(R.id.etUsername);
        etWebsite = findViewById(R.id.etWebsite);
        etBio = findViewById(R.id.etBio);
        tvDone = findViewById(R.id.tvDone);
        //tvCancel = findViewById(R.id.tvCancel);

        tvDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser user = new ParseUser();
                user.setUsername(etUsername.getText().toString());
                saveProfileSettings();

                Toast.makeText(EditActivity.this, "Done", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void saveProfileSettings() {
       final String name = etName.getText().toString();
       final String username = etUsername.getText().toString();
       final String website = etWebsite.getText().toString();
       final String bio = etBio.getText().toString();

    }

    @Override
    public boolean onOptionsItemSelected (android.view.MenuItem item) {
        if(item.getItemId()== android.R.id.home) {

            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}