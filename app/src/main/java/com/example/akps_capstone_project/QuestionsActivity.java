package com.example.akps_capstone_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class QuestionsActivity extends AppCompatActivity {

    TextView tv;
    Button submitButton, quitButton;
    RadioGroup radioGroup;
    RadioButton radioButton1, radioButton2, radioButton3, radioButton4;

    String questions[] = {
            "What is the best selling videogame of all time?",
            "What is the highest-selling gaming console to date?",
            "What year was the first virtual reality headset created?",
            "What movie franchise influenced the creation of the game “Doom?”",
            "What food was the character Pac Man modeled after?",
    };
    String answers[] = {"Minecraft","Playstation 2","1995","Aliens","Pizza"};
    String opt[] = {
            "Minecraft","Mario Bros","GTA: San Andreas","The Legend of Zelda",
            "SNES","Xbox","Playstation 2","Nintendo Wii",
            "2000","1990","2001","1995",
            "Aliens","Mortal Kombat","Predator","Dune",
            "Bagel","Pizza","Taco","Burger"
    };
    int flag = 0;
    public static int marks = 0, correct = 0, wrong = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        final TextView score = (TextView)findViewById(R.id.textView4);
        Intent intent = getIntent();

        submitButton = (Button)findViewById(R.id.button3);
        quitButton = (Button)findViewById(R.id.buttonquit);
        tv = (TextView) findViewById(R.id.tvque);

        radioGroup = (RadioGroup)findViewById(R.id.answersgrp);
        radioButton1 = (RadioButton)findViewById(R.id.radioButton);
        radioButton2 = (RadioButton)findViewById(R.id.radioButton2);
        radioButton3 = (RadioButton)findViewById(R.id.radioButton3);
        radioButton4 = (RadioButton)findViewById(R.id.radioButton4);
        tv.setText(questions[flag]);
        radioButton1.setText(opt[0]);
        radioButton2.setText(opt[1]);
        radioButton3.setText(opt[2]);
        radioButton4.setText(opt[3]);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (radioGroup.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton ans = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
                String ansText = ans.getText().toString();
                if (ansText.equals(answers[flag])) {
                    correct++;
                }
                else {
                    wrong++;
                }

                flag++;

                if (score != null)
                    score.setText(""+correct);

                if (flag < questions.length) {
                    tv.setText(questions[flag]);
                    radioButton1.setText(opt[flag*4]);
                    radioButton2.setText(opt[flag*4 +1]);
                    radioButton3.setText(opt[flag*4 +2]);
                    radioButton4.setText(opt[flag*4 +3]);
                }
                else {
                    marks = correct;
                    Intent in = new Intent(getApplicationContext(), ResultActivity.class);
                    startActivity(in);
                }
                radioGroup.clearCheck();
            }
        });

        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), ResultActivity.class);
                startActivity(intent);
            }
        });
    }
}