package com.faizan.simpleinterestcalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText principleInput, rateInput, timeInput;
    private Button calculateButton;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        principleInput = findViewById(R.id.principleInput);
        rateInput = findViewById(R.id.rateInput);
        timeInput = findViewById(R.id.timeInput);
        calculateButton = findViewById(R.id.calculateButton);
        result = findViewById(R.id.result);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateSimpleInterest();
            }
        });
    }
    private void calculateSimpleInterest() {
        String principleStr = principleInput.getText().toString();
        String rateStr = rateInput.getText().toString();
        String timeStr = timeInput.getText().toString();

        if (principleStr.isEmpty() || rateStr.isEmpty() || timeStr.isEmpty()) {
            Toast.makeText(this, "Please enter all values", Toast.LENGTH_SHORT).show();
            return;
        }

        float principle = Float.parseFloat(principleStr);
        float rate = Float.parseFloat(rateStr);
        float time = Float.parseFloat(timeStr);

        float simpleInterest = (principle * rate * time) / 100;

        result.setText("Simple Interest: " + simpleInterest);
    }

}
