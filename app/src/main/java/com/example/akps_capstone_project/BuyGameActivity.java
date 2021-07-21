package com.example.akps_capstone_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class BuyGameActivity extends AppCompatActivity {
    ImageView imageView,star1,star2,star3,star4,star5;
    int rating;
    Button buy;
    String game_name;
    TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_game);
        star1=findViewById(R.id.star1);
        star2=findViewById(R.id.star2);
        star3=findViewById(R.id.star3);
        star4=findViewById(R.id.star4);
        star5=findViewById(R.id.star5);
        title=findViewById(R.id.titlee);
        buy=findViewById(R.id.buy);
        Bundle bundle=getIntent().getExtras();
        game_name=bundle.getString("game_name");
        rating=bundle.getInt("rating");
        title.setText(game_name);

        if (rating==1){
            star1.setVisibility(View.VISIBLE);
        }
        else if (rating==2){
            star1.setVisibility(View.VISIBLE);
            star2.setVisibility(View.VISIBLE);
        }
        else if (rating==3){
            star1.setVisibility(View.VISIBLE);
            star2.setVisibility(View.VISIBLE);
            star3.setVisibility(View.VISIBLE);

        }
        else if (rating==4){
            star1.setVisibility(View.VISIBLE);
            star2.setVisibility(View.VISIBLE);
            star3.setVisibility(View.VISIBLE);
            star4.setVisibility(View.VISIBLE);

        }
        else if (rating==5){
            star1.setVisibility(View.VISIBLE);
            star2.setVisibility(View.VISIBLE);
            star3.setVisibility(View.VISIBLE);
            star4.setVisibility(View.VISIBLE);
            star5.setVisibility(View.VISIBLE);
        }

        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),PaymentActivity.class);
                startActivity(i);
            }
        });
    }
}