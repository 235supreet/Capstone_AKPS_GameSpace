package com.example.akps_capstone_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    ListView listView;
    String[] games = {"Destiny 2: Beyond Light", "Little Nightmares", "Human: Fall Flat", "Resident Evil: Village", "Red Dead Redemption 2", "Star Wars Jedi: Fallen Order", "Call of Duty: Black Ops Cold War"};
    Integer[] image = {R.drawable.destiny, R.drawable.nightmares, R.drawable.fall, R.drawable.village, R.drawable.reddead, R.drawable.jedifallen, R.drawable.coldwar};
    Integer[] rating = {3, 2, 1, 5, 5, 4, 2};
    String[] price = {"$85", "$30", "$50", "$40", "60$", "39$", "99$"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bottomNavigation();
        listView = findViewById(R.id.listView);
        CustomListView customListView = new CustomListView(this, games,price,image,rating);
        listView.setAdapter(customListView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(HomeActivity.this,BuyGameActivity.class);
                intent.putExtra("game_name", games[position]);
                intent.putExtra("rating",rating[position]);
                intent.putExtra("price",price[position]);
                startActivity(intent);
            }
        });
    }

    private void bottomNavigation() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                        overridePendingTransition(0,0);
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
    }
}