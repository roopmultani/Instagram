package com.example.instragramclone;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import com.example.instragramclone.fragments.ComposeFragment;
import com.example.instragramclone.fragments.PostFragment;
import com.example.instragramclone.fragments.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    final FragmentManager fragmentManager = getSupportFragmentManager();
    private BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        final ActionBar actionBar = getSupportActionBar(); // or getActionBar();
        getSupportActionBar().setTitle("                          Instagram  "); // set the top title
        String title = actionBar.getTitle().toString(); // get the title

        bottomNavigationView = findViewById(R.id.bottom);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                switch (item.getItemId()) {
                    case R.id.iHome:
                        //Toast.makeText(MainActivity.this, "home!" + Post.KEY_USER, Toast.LENGTH_SHORT).show();
                        fragment = new PostFragment();
                        break;

                    case R.id.iCompose:
                       // Toast.makeText(com.example.instragramclone.MainActivity.this, "compose!", Toast.LENGTH_SHORT).show();
                        fragment = new ComposeFragment();
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

        bottomNavigationView.setSelectedItemId(R.id.iCompose);
    }
}
