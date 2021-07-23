package com.example.akps_capstone_project;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomListView extends ArrayAdapter<String> {

    String[] games;
    String[] price;
    Integer[] image;
    Integer[] rating;
    private Activity context;

    public CustomListView(Activity context, String[] games,String[] price,  Integer[] image , Integer[] rating) {
        super(context, R.layout.listview_layout,games);
        this.context = context;
        this.games = games;
        this.price = price;
        this.image = image;
        this.rating = rating;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View r = convertView;
        ViewHolder viewHolder = null;

        if (r == null) {
            LayoutInflater layoutInflater=context.getLayoutInflater();
            r = layoutInflater.inflate(R.layout.listview_layout,null,true);
            viewHolder = new ViewHolder(r);
            r.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) r.getTag();
        }

        viewHolder.game_name.setText(games[position]);
        viewHolder.img.setImageResource(image[position]);
        viewHolder.price.setText(price[position]);
        System.out.println("Rating" + rating + rating[position]);

        if (rating[position] == 1) {
            viewHolder.s1.setVisibility(View.VISIBLE);
        }
        else if (rating[position] == 2) {
            viewHolder.s1.setVisibility(View.VISIBLE);
            viewHolder.s2.setVisibility(View.VISIBLE);
        }
        else if (rating[position] == 3) {
            viewHolder.s1.setVisibility(View.VISIBLE);
            viewHolder.s2.setVisibility(View.VISIBLE);
            viewHolder.s3.setVisibility(View.VISIBLE);

        }
        else if (rating[position] == 4) {
            viewHolder.s1.setVisibility(View.VISIBLE);
            viewHolder.s2.setVisibility(View.VISIBLE);
            viewHolder.s3.setVisibility(View.VISIBLE);
            viewHolder.s4.setVisibility(View.VISIBLE);

        }
        else if (rating[position] == 5) {
            viewHolder.s1.setVisibility(View.VISIBLE);
            viewHolder.s2.setVisibility(View.VISIBLE);
            viewHolder.s3.setVisibility(View.VISIBLE);
            viewHolder.s4.setVisibility(View.VISIBLE);
            viewHolder.s5.setVisibility(View.VISIBLE);
        }
        return r;
    }

    class ViewHolder {

        TextView game_name;
        ImageView img,s1,s2,s3,s4,s5;
        TextView price;

        ViewHolder(View v) {
            game_name=v.findViewById(R.id.game_name);
            price = v.findViewById(R.id.price);
            img = v.findViewById(R.id.imageV);
            s1 = v.findViewById(R.id.star1);
            s2 = v.findViewById(R.id.star2);
            s3 = v.findViewById(R.id.star3);
            s4 = v.findViewById(R.id.star4);
            s5 = v.findViewById(R.id.star5);

        }
    }
}

