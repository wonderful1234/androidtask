package com.example.myapplicationlocation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.telephony.SmsManager;

public class Main4Activity extends AppCompatActivity {
    private SharedPreferences pres;
    private SharedPreferences press;
    String s=new String();
    String se=new String();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        pres=getSharedPreferences("crazyit", Context.MODE_PRIVATE);
        press=getSharedPreferences("crazyii", Context.MODE_PRIVATE);
        s=pres.getString("user",null).trim();
        se="我有危险，我在"+press.getString("message",null).trim();
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(s, null, se, null, null);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }


}
