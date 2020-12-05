package com.example.instragramclone;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.instragramclone.fragments.ComposeFragment;
import com.example.instragramclone.fragments.PostFragment;
import com.example.instragramclone.fragments.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.parse.ParseUser;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    final FragmentManager fragmentManager = getSupportFragmentManager();
    private BottomNavigationView bottomNavigationView;
    private ActionBar action_bar;
   private ImageButton btnSignOut;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       /* requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); */

        setContentView(R.layout.activity_main);

        final ActionBar actionBar = getSupportActionBar(); // or getActionBar();

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar);
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFFFF")));


        btnSignOut = findViewById(R.id.imgShare);
        btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser.logOut();
                ParseUser currentUser = ParseUser.getCurrentUser();// this will now be null
                goLoginActivity();
                Toast.makeText(MainActivity.this, "Sign Out", Toast.LENGTH_SHORT).show();
            }
        });

        bottomNavigationView = findViewById(R.id.bottom);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment;
                switch (menuItem.getItemId()) {
                    case R.id.iInbox:
                        //Toast.makeText(MainActivity.this, "home!" + Post.KEY_USER, Toast.LENGTH_SHORT).show();
                        fragment = new PostFragment();
                        break;

                    case R.id.iCompose:
                       // Toast.makeText(com.example.instragramclone.MainActivity.this, "compose!", Toast.LENGTH_SHORT).show();
                        fragment = new ComposeFragment();
                        break;

                    case R.id.iSearch:
                        // Toast.makeText(com.example.instragramclone.MainActivity.this, "compose!", Toast.LENGTH_SHORT).show();
                        fragment = new Fragment();
                        break;

                    case R.id.iProfile:
                    default:
                        //Toast.makeText(com.example.instragramclone.MainActivity.this, "profile!", Toast.LENGTH_SHORT).show();
                        fragment = new ProfileFragment();
                        break;
                }
                fragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit();
                return false;
            }
        });

        bottomNavigationView.setSelectedItemId(R.id.iInbox);
    }

    private void goLoginActivity() {
        Intent i = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(i);
    }
}
