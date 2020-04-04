package com.example.myapplicationlocation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void clickbu1(View source){
        Intent it=new Intent(MainActivity.this,Main2Activity.class);
        startActivity(it);
    }
    public void clickbu4(View source){
        Intent it=new Intent(MainActivity.this,Main3Activity.class);
        startActivity(it);



    }

    public void clickbu2(View view) {
        Intent it=new Intent(MainActivity.this,Main4Activity.class);
        startActivity(it);
    }

    public void clickbu3(View view) {
        Intent it=new Intent(MainActivity.this,WeatherSearchActivity.class);
        startActivity(it);

    }
}
