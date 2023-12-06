package com.example.vize_odev;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ConvertorActivity extends AppCompatActivity {

    // Celsius to Kelvin/Fahrenheit Conversion Components
    EditText celsiusInput;
    CheckBox kelvinCheckbox, fahrenheitCheckbox;
    Button convertTemperatureButton;

    // Decimal to Hexadecimal/Binary Conversion Components
    EditText decimalInput;
    Spinner conversionType;
    Button convertButton;
    TextView resultText;


    EditText megabyteInput;
    Spinner megabyteConversionType;
    Button megabyteConvertButton;
    TextView megabyteResultText;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convertor);

        // Celsius to Kelvin/Fahrenheit Conversion Initialization
        celsiusInput = findViewById(R.id.celsiusInput);
        kelvinCheckbox = findViewById(R.id.kelvinCheckbox);
        fahrenheitCheckbox = findViewById(R.id.fahrenheitCheckbox);
        convertTemperatureButton = findViewById(R.id.convertTemperatureButton);

        convertTemperatureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertTemperature();
            }
        });

        // Decimal to Hexadecimal/Binary Conversion Initialization
        decimalInput = findViewById(R.id.decimalInput);
        conversionType = findViewById(R.id.conversionType);
        convertButton = findViewById(R.id.convertButton);
        resultText = findViewById(R.id.resultText);

        String[] conversionTypes = {"Hexadecimal", "Binary"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, conversionTypes);
        conversionType.setAdapter(adapter);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convert();
            }
        });


        megabyteInput = findViewById(R.id.megabyteInput);
        megabyteConversionType = findViewById(R.id.megabyteConversionType);
        megabyteConvertButton = findViewById(R.id.megabyteConvertButton);
        megabyteResultText = findViewById(R.id.megabyteResultText);

        String[] megabyteConversionTypes = {"Kilobyte", "Byte", "Kibibyte", "Bit"};
        ArrayAdapter<String> megabyteAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, megabyteConversionTypes);
        megabyteConversionType.setAdapter(megabyteAdapter);

        megabyteConvertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertMegabyte();
            }
        });
    }

    private void convertTemperature() {
        String input = celsiusInput.getText().toString().trim();
        if (!input.isEmpty()) {
            double celsiusValue = Double.parseDouble(input);

            if (kelvinCheckbox.isChecked()) {
                double kelvinValue = celsiusValue + 273.15;
                displayResult(kelvinValue, "Kelvin");
            } else if (fahrenheitCheckbox.isChecked()) {
                double fahrenheitValue = (celsiusValue * 9 / 5) + 32;
                displayResult(fahrenheitValue, "Fahrenheit");
            } else {
                Toast.makeText(this, "Lütfen dönüşüm tipini seçin.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Lütfen bir sayı girin.", Toast.LENGTH_SHORT).show();
        }
    }

    private void convert() {
        String input = decimalInput.getText().toString().trim();
        if (!input.isEmpty()) {
            int decimalValue = Integer.parseInt(input);

            String selectedType = conversionType.getSelectedItem().toString();
            String result = "";

            if (selectedType.equals("Hexadecimal")) {
                result = Integer.toHexString(decimalValue).toUpperCase();
            } else if (selectedType.equals("Binary")) {
                result = Integer.toBinaryString(decimalValue);
            }

            resultText.setText("Sonuç: " + result);
        } else {
            resultText.setText("Lütfen bir sayı girin.");
        }
    }

    private void displayResult(double result, String unit) {
        Toast.makeText(this, "Sonuç: " + result + " " + unit, Toast.LENGTH_SHORT).show();
    }
    private void convertMegabyte() {
        String input = megabyteInput.getText().toString().trim();
        if (!input.isEmpty()) {
            try {
                double megabyteValue = Double.parseDouble(input);
                double result = 0;

                String selectedType = megabyteConversionType.getSelectedItem().toString();

                switch (selectedType) {
                    case "Kilobyte":
                        result = megabyteValue * 1024;
                        break;
                    case "Byte":
                        result = megabyteValue * 1024 * 1024;
                        break;
                    case "Kibibyte":
                        result = megabyteValue * 8192;
                        break;
                    case "Bit":
                        result = megabyteValue * 8 * 1024 * 1024;
                        break;
                }

                megabyteResultText.setText("Sonuç: " + result);
            } catch (NumberFormatException e) {
                megabyteResultText.setText("Lütfen geçerli bir sayı girin.");
            }
        } else {
            megabyteResultText.setText("Lütfen bir sayı girin.");
        }
    }
}
