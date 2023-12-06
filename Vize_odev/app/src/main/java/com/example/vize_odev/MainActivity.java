package com.example.vize_odev;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btnConvertor = findViewById(R.id.btnConvertor);
        Button btnRandom = findViewById(R.id.btnRandom);
        Button btnSms = findViewById(R.id.btnSms);

        btnConvertor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Convertor sayfasına geçiş yapılabilir
                Intent intent = new Intent(MainActivity.this, ConvertorActivity.class);
                startActivity(intent);
            }
        });

        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Random sayfasına geçiş yapılabilir
                Intent intent = new Intent(MainActivity.this, RandomActivity.class);
                startActivity(intent);
            }
        });

        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Sms sayfasına geçiş yapılabilir
                Intent intent = new Intent(MainActivity.this, SmsActivity.class);
                startActivity(intent);
            }
        });
    }
}