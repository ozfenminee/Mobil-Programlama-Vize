package com.example.vize_odev;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class RandomActivity extends AppCompatActivity {

    private LinearLayout progressBarsContainer;
    private EditText Adet, MinValue, MaxValue;

    @SuppressLint("MissingInflatedId")
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);

        progressBarsContainer = findViewById(R.id.progressBarsContainer);
        Adet = findViewById(R.id.Adet);
        MinValue = findViewById(R.id.MinValue);
        MaxValue = findViewById(R.id.MaxValue);

        Button btnGenerate = findViewById(R.id.btnGenerate);
        btnGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateProgressBars();
            }
        });
    }

    private void generateProgressBars() {
        progressBarsContainer.removeAllViews(); // Önceki ProgressBar'ları temizle

        int adet = Integer.parseInt(Adet.getText().toString());
        int minValue = Integer.parseInt(MinValue.getText().toString());
        int maxValue = Integer.parseInt(MaxValue.getText().toString());

        Random random = new Random();

        for (int i = 0; i < adet; i++) {
            int progressValue = random.nextInt(maxValue - minValue + 1);

            ProgressBar progressBar = new ProgressBar(this, null, android.R.attr.progressBarStyleHorizontal);
            progressBar.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));

            progressBar.setMax(maxValue - minValue);
            progressBar.setProgress(progressValue);




            progressBarsContainer.addView(progressBar);

// İlerleme miktarını yüzde olarak hesapla
            int progressPercentage = (progressValue * 100) / (maxValue - minValue);

// TextView ile ilerleme yüzdesini ve değerleri göster
            TextView textView = new TextView(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            params.gravity = Gravity.CENTER_HORIZONTAL;
            textView.setLayoutParams(params);
            textView.setText(String.format("Min: %d, Max: %d %d%% = %d", minValue, maxValue, progressPercentage, progressValue));

            progressBarsContainer.addView(textView);
        }
    }
}