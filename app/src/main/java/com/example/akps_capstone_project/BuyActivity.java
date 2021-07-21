package com.example.akps_capstone_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BuyActivity extends AppCompatActivity {

    ListView listView;
    String[] games = {"Greedy Goblin", "Little Nightmare", "Human Fall Flat", "Hello"};
    Integer[] image = {R.drawable.gameee, R.drawable.gameee, R.drawable.gameee, R.drawable.gameee};
    Integer[] rating = {3, 2, 4, 5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);
        //bottomNavigation();
        listView=findViewById(R.id.listView);
        /*CustomListView customListView=new CustomListView(this, games,image,rating);
        listView.setAdapter(customListView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(BuyActivity.this, "Working", Toast.LENGTH_SHORT).show();
            }
        });*/



    }

   /*private void bottomNavigation() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.buy);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                        return true;
                    case R.id.buy:
                        startActivity(new Intent(getApplicationContext(),BuyActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.vip:
                        startActivity(new Intent(getApplicationContext(), VIPActivity.class));
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
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
    }*/


}