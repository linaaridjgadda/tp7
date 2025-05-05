package com.example.conversionmenus;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    EditText editFloat;
    RadioButton radioDinarToEuro, radioEuroToDinar;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        editFloat = findViewById(R.id.edit_float);
        radioDinarToEuro = findViewById(R.id.radio_dinar_to_euro);
        radioEuroToDinar = findViewById(R.id.radio_euro_to_dinar);
        txtResult = findViewById(R.id.txt_result);
    }

    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    public void auClic(View view) {
        String input = editFloat.getText().toString().trim();

        if (input.isEmpty()) {
            txtResult.setText("Veuillez entrer une valeur");
            return;
        }

        try {
            double value = Double.parseDouble(input);
            double result;

            if (radioDinarToEuro.isChecked()) {
                result = value / 230.0;
                txtResult.setText(String.format("%.2f DA = %.2f €", value, result));
            } else if (radioEuroToDinar.isChecked()) {
                result = value * 230.0;
                txtResult.setText(String.format("%.2f € = %.2f DA", value, result));
            } else {
                txtResult.setText("Veuillez sélectionner une conversion");
            }
        } catch (NumberFormatException e) {
            txtResult.setText("Valeur invalide !");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 1, 0, "Conversion C ↔ F");
        menu.add(0, 2, 1, "Quitter");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == 1) {
            Intent intent = new Intent(this, ConversionTemperature.class);
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
