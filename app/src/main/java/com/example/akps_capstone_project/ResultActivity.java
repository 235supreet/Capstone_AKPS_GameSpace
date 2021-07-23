package com.example.akps_capstone_project;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    DBHelper dbhelper;
    SharedPreference sharedPreference;
    Activity context = this;
    TextView tv, tv2, tv3;
    Button btnRestart;
    Integer s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tv = (TextView)findViewById(R.id.tvres);
        tv2 = (TextView)findViewById(R.id.tvres2);
        tv3 = (TextView)findViewById(R.id.tvres3);
        btnRestart = (Button) findViewById(R.id.btnRestart);
        dbhelper = new DBHelper(this);
        sharedPreference = new SharedPreference();

        StringBuffer sb = new StringBuffer();
        sb.append("Correct answers: " + QuestionsActivity.correct + "\n");
        StringBuffer sb2 = new StringBuffer();
        sb2.append("Wrong Answers: " + QuestionsActivity.wrong + "\n");
        StringBuffer sb3 = new StringBuffer();
        sb3.append("Final Score: " + QuestionsActivity.correct + "\n");
        tv.setText(sb);
        tv2.setText(sb2);
        tv3.setText(sb3);

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sc = 0;
                Cursor cursor=dbhelper.getAll();
                while (cursor.moveToNext()) {
                     sc=cursor.getInt(4);
                }
                dbhelper.update(sharedPreference.getValue(context), sc+QuestionsActivity.correct);
                QuestionsActivity.correct=0;
                QuestionsActivity.wrong=0;
                Intent in = new Intent(getApplicationContext(),VIPActivity.class);
                startActivity(in);
            }
        });
    }

    public void showData() {
        Cursor result = dbhelper.getAll();
        while(result.moveToNext()) {
            String n = result.getString(1);
            String m = result.getString(2);
            String p = result.getString(3);
            s = result.getInt(5);
        }
    }
}