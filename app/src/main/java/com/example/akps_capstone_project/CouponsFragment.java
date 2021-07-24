package com.example.akps_capstone_project;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CouponsFragment extends Fragment {

    DBHelper dbhelper;
    View view, coupon1, coupon2, coupon3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_coupons, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        coupon1 = view.findViewById(R.id.promo1);
        coupon2 = view.findViewById(R.id.promo2);
        coupon3 = view.findViewById(R.id.promo3);

        dbhelper = new DBHelper(getActivity());
        int sc = 0;
        Cursor cursor = dbhelper.getAll();
        while (cursor.moveToNext()) {
            sc = cursor.getInt(4);
        }

        coupon1.setEnabled(false);
        coupon2.setEnabled(false);
        coupon3.setEnabled(false);

        if (sc >= 5) {
            coupon1.setBackgroundResource(R.color.darkest_blue);
            coupon1.setEnabled(true);
            coupon1.isFocusable();
            coupon1.isClickable();
        }
        if (sc >= 10) {
            coupon2.setBackgroundResource(R.color.darkest_blue);
            coupon2.setEnabled(true);
            coupon2.isFocusable();
            coupon2.isClickable();
        }
        if (sc >= 15) {
            coupon3.setBackgroundResource(R.color.darkest_blue);
            coupon3.setEnabled(true);
            coupon3.isFocusable();
            coupon3.isClickable();
        }

        coupon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), HomeActivity.class);
                startActivity(intent);
            }
        });

        coupon2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), HomeActivity.class);
                startActivity(intent);
            }
        });
    }

    public void showData() {
        Cursor result = dbhelper.getAll();
        while (result.moveToNext()) {
            String n = result.getString(1);
            String m = result.getString(2);
            String p = result.getString(3);
            String s = result.getString(5);

        }
    }
}