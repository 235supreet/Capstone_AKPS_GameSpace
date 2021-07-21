package com.example.akps_capstone_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class BuyGameActivity extends AppCompatActivity {
    ImageView imageView,star1,star2,star3,star4,star5;
    int rating, imageNumber;
    Button buy, exit;
    String game_name;
    TextView title, overview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_game);
        star1=findViewById(R.id.star1);
        star2=findViewById(R.id.star2);
        star3=findViewById(R.id.star3);
        star4=findViewById(R.id.star4);
        star5=findViewById(R.id.star5);
        imageView=findViewById(R.id.imageVieww);
        title=findViewById(R.id.titlee);
        buy=findViewById(R.id.buy);
        exit=findViewById(R.id.exit);
        overview=findViewById(R.id.overviewText);

        Bundle bundle=getIntent().getExtras();
        game_name=bundle.getString("game_name");
        rating=bundle.getInt("rating");
        title.setText(game_name);
        if (game_name.equals("Destiny 2: Beyond Light")) {
            imageView.setImageResource(R.drawable.destiny);
            String text=getString(R.string.beyond_light_desc);
            overview.setText(text);
        }
        else if (game_name.equals("Little Nightmares")) {
            imageView.setImageResource(R.drawable.nightmares);
            String text=getString(R.string.little_nightmares_desc);
            overview.setText(text);
        }
        else if (game_name.equals("Human: Fall Flat")) {
            imageView.setImageResource(R.drawable.fall);
            String text=getString(R.string.fall_flat_desc);
            overview.setText(text);
        }
        else if (game_name.equals("Resident Evil: Village")){
            imageView.setImageResource(R.drawable.village);
            String text=getString(R.string.village_desc);
            overview.setText(text);
        }

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

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),HomeActivity.class);
                startActivity(i);
            }
        });
    }
}