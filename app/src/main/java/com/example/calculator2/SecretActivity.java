package com.example.calculator2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecretActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secret);
        Button buttonOpenCalculator = findViewById(R.id.buttonOpenCalculator);
        buttonOpenCalculator.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.buttonOpenCalculator) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
}
