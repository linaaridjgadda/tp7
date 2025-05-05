package com.example.conversionmenus;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ConversionTemperature extends AppCompatActivity {

    EditText inputTemp;
    Button btnToFahrenheit, btnToCelsius;
    TextView resultTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion_temperature);

        Toolbar toolbar = findViewById(R.id.toolbar_temp);
        setSupportActionBar(toolbar);

        inputTemp = findViewById(R.id.input_temp);
        btnToFahrenheit = findViewById(R.id.btn_to_fahrenheit);
        btnToCelsius = findViewById(R.id.btn_to_celsius);
        resultTemp = findViewById(R.id.result_temp);

        btnToFahrenheit.setOnClickListener(v -> {
            String input = inputTemp.getText().toString();
            if (!input.isEmpty()) {
                double celsius = Double.parseDouble(input);
                double fahrenheit = (9.0 / 5.0) * celsius + 32;
                resultTemp.setText(String.format("%.2f °C = %.2f °F", celsius, fahrenheit));
            } else {
                resultTemp.setText("Veuillez entrer une température");
            }
        });

        btnToCelsius.setOnClickListener(v -> {
            String input = inputTemp.getText().toString();
            if (!input.isEmpty()) {
                double fahrenheit = Double.parseDouble(input);
                double celsius = (5.0 / 9.0) * (fahrenheit - 32);
                resultTemp.setText(String.format("%.2f °F = %.2f °C", fahrenheit, celsius));
            } else {
                resultTemp.setText("Veuillez entrer une température");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 1, 0, "Retour Euro ↔ Dinar");
        menu.add(0, 2, 1, "Quitter");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == 1) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
            return true;
        } else if (item.getItemId() == 2) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
