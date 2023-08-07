package com.example.calculator2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.calculator2.service.CalculateOperationStrategy;
import com.example.calculator2.thread.ChangeColorThread;
import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String supportText = "Send report on email example@test.com";
    private TextView firstResultOfSum;
    private EditText firstNumber;
    private EditText secondNumber;
    private CalculateOperationStrategy calculateOperationStrategy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculateOperationStrategy = new CalculateOperationStrategy();
        firstNumber = findViewById(R.id.number_field_one);
        secondNumber = findViewById(R.id.number_field_two);
        firstResultOfSum = findViewById(R.id.firstResultOfSum);

        Button buttonPlus = findViewById(R.id.buttonPlus);
        buttonPlus.setOnClickListener(this);
        Button buttonMinus = findViewById(R.id.buttonMinus);
        buttonMinus.setOnClickListener(this);
        Button buttonDivide = findViewById(R.id.buttonDivide);
        buttonDivide.setOnClickListener(this);
        Button buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonMultiply.setOnClickListener(this);

        Button buttonSupport = findViewById(R.id.buttonSupport);
        buttonSupport.setOnClickListener(this);
        Button buttonDonate = findViewById(R.id.buttonDonate);
        buttonDonate.setOnClickListener(this);
        Button buttonSecret = findViewById(R.id.buttonSecret);
        buttonSecret.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.buttonPlus || view.getId() == R.id.buttonMinus ||
                view.getId() == R.id.buttonDivide || view.getId() == R.id.buttonMultiply) {
            setResultOfCalculate(view);
        }
        if (view.getId() == R.id.buttonDonate) {
            donate((Button) view);
        }
        if (view.getId() == R.id.buttonSupport) {
            support((Button) view);
        }
        if (view.getId() == R.id.buttonSecret) {
            Intent intent = new Intent(this, SecretActivity.class);
            startActivity(intent);
        }
    }

    private void donate(Button button) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Support our team")
                .setMessage("Do you want to donate?")
                .setCancelable(false)
                .setPositiveButton("Yes", (dialogInterface, i) -> finish())
                .setNegativeButton("No", (dialogInterface, i) -> dialogInterface.dismiss());
        AlertDialog dialog = builder.create();
        dialog.show();
        ChangeColorThread colorThread = new ChangeColorThread(this, button);
        colorThread.start();
    }

    private void support(Button button) {
        Toast.makeText(this, MainActivity.supportText, Toast.LENGTH_LONG).show();
        ChangeColorThread colorThread = new ChangeColorThread(this, button);
        colorThread.start();
    }

    private void setResultOfCalculate(View view) {
        firstResultOfSum.setText(String.valueOf(calculateOperationStrategy
                .calculate(view, getBigDecimalFromEditText(firstNumber),
                        getBigDecimalFromEditText(secondNumber))));
    }

    private BigDecimal getBigDecimalFromEditText(EditText number) {
        return number.getText().toString().equals("") ? BigDecimal.ZERO : new
                BigDecimal(number.getText().toString());
    }
}
