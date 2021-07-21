package com.example.akps_capstone_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        bottomNavigation();
    }
    private void bottomNavigation() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.user);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
                        return true;
                    /*case R.id.buy:
                        startActivity(new Intent(getApplicationContext(),BuyActivity.class));
                        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
                        return true;*/
                    case R.id.vip:
                        startActivity(new Intent(getApplicationContext(), VIPActivity.class));
                        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
                        return true;
                    case R.id.contact:
                        startActivity(new Intent(getApplicationContext(),ContactUsActivity.class));
                        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
                        return true;
                    case R.id.user:
                        startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }


}