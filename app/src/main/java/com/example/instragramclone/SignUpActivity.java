package com.example.instragramclone;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    private TextView tvLogIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        final ActionBar actionBar = getSupportActionBar(); // or getActionBar();
        actionBar.hide();

        tvLogIn = findViewById(R.id.tvLogIn);
        tvLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goLoginActivity();
                //Toast.makeText(SignUpActivity.this, "Success", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void goLoginActivity() {
        Intent i = new Intent(SignUpActivity.this, LoginActivity.class);
        startActivity(i);
    }
}