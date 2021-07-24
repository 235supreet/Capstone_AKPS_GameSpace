package com.example.akps_capstone_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PaymentActivity extends AppCompatActivity {

    EditText message;
    TextView phoneNumber;
    Button send, home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        send = findViewById(R.id.sendMessageTxt);
        message = findViewById(R.id.buyMessageTxt);
        home= findViewById(R.id.homePayment);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PaymentActivity.this, HomeActivity.class);
                startActivity(i);
                finish();
            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String number = "9988697940";
                String msg = message.getText().toString();
                if (checkPermission(Manifest.permission.SEND_SMS)) {
                    send.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if (number == null){
                                return;
                            }
                            if (checkPermission((Manifest.permission.SEND_SMS))) {
                                SmsManager smsManager = SmsManager.getDefault();
                                smsManager.sendTextMessage(number,null, msg,null,null);
                                Toast.makeText(PaymentActivity.this, "Message Sent", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
                else {
                    ActivityCompat.requestPermissions(PaymentActivity.this,new String[]{Manifest.permission.SEND_SMS},1);
                }
            }
        });
    }
    
    public boolean checkPermission(String permission){
        int check = ContextCompat.checkSelfPermission(this,permission);
        return (check == PackageManager.PERMISSION_GRANTED);
    }
}