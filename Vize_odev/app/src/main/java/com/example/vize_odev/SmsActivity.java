package com.example.vize_odev;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SmsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        // Buton ve EditText'leri bağlama
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) EditText editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) EditText editTextMessage = findViewById(R.id.editTextMessage);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button btnSend = findViewById(R.id.btnSend);

        // Gönderme butonu tıklama olayını işleme
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = editTextPhoneNumber.getText().toString();
                String message = editTextMessage.getText().toString();

                if (!phoneNumber.isEmpty() && !message.isEmpty()) {
                    // SMS gönderme işlemi
                    sendSMS(phoneNumber, message);
                } else {
                    Toast.makeText(SmsActivity.this, "Lütfen tüm alanları doldurun", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // SMS gönderme metodu
    private void sendSMS(String phoneNumber, String message) {
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNumber, null, message, null, null);
            Toast.makeText(this, "Mesaj gönderildi", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, "Mesaj gönderilemedi", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
}
