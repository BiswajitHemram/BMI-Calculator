package com.example.bmicalculatorapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BMICalculator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bmicalculator);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setTitle("BMI Calculator");
    }

   public void calculate(View view){
       EditText weightInput, heightInput;
       TextView bmiResult;

       // Find views by their ID
       weightInput = findViewById(R.id.weightInput);
       heightInput = findViewById(R.id.heightInput);
       bmiResult = findViewById(R.id.bmiResult);

       String weightStr = weightInput.getText().toString();
       String heightStr = heightInput.getText().toString();

       // Validate input (optional but recommended)
       if (!weightStr.isEmpty() && !heightStr.isEmpty()) {
           double weight = Double.parseDouble(weightStr);
           double heightCm = Double.parseDouble(heightStr);

           // Convert height from cm to meters
           double heightM = heightCm / 100;

           // Calculate BMI
           double bmi = weight / (heightM * heightM);

           // Display BMI result
           bmiResult.setText(String.format("Your BMI is: %.2f", bmi));
       } else {
           bmiResult.setText("Please enter valid height and weight");
       }
   }
}