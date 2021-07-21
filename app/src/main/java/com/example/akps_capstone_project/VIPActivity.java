package com.example.akps_capstone_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class VIPActivity extends AppCompatActivity {

    ImageView imPlay;
    Button coupons, secondButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vip);
        replaceFragment(new CouponsFragment());
        bottomNavigation();

        coupons = findViewById(R.id.coupons);
        secondButton = findViewById(R.id.secondButton);

        coupons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                replaceFragment(new CouponsFragment());

            }
        });

        secondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                replaceFragment(new SecondFragment());

            }
        });

        imPlay=findViewById(R.id.play);
        imPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(VIPActivity.this,QuizActivity.class);
                startActivity(i);
            }
        });
    }

    private void replaceFragment(Fragment fragment) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();
    }

    private void bottomNavigation() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.vip);

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
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.contact:
                        startActivity(new Intent(getApplicationContext(),ContactUsActivity.class));
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        return true;
                    case R.id.user:
                        startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        return true;
                }
                return false;
            }
        });
    }
}