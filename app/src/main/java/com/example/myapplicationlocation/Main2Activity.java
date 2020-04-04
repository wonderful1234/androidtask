package com.example.myapplicationlocation;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class Main2Activity extends AppCompatActivity {
    private EditText text1;
    private Button button1;
    private SharedPreferences pres;
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        pres=getSharedPreferences("crazyit", Context.MODE_PRIVATE);
        editor=pres.edit();
        text1=findViewById(R.id.text1);
        button1=findViewById(R.id.bu1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s,se;
                s=text1.getText().toString().trim();
                    editor.putString("user", s);
                    editor.apply();
                    se = "保存成功";
                Toast.makeText(Main2Activity.this,se,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
