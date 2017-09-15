package com.example.kevin.donation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.NumberPicker;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Donate extends AppCompatActivity {
    private Button donateButton;
    private RadioGroup   paymentMethod;
    private ProgressBar  progressBar;
    private NumberPicker amountPicker;
    private int totalDonated;
    private TextView amountBox;
    private TextView totalDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);

        donateButton = (Button) findViewById(R.id.donateButton);
        if (donateButton != null) {
            Log.v("Donate", "got a donate button !");
        }
        paymentMethod = (RadioGroup)   findViewById(R.id.paymentMethod);
        progressBar   = (ProgressBar)  findViewById(R.id.progressBar);
        amountPicker  = (NumberPicker) findViewById(R.id.amountPicker);
        amountBox = (TextView) findViewById(R.id.amountBox);
        totalDisplay = (TextView) findViewById(R.id.totalDisplay);
        
        amountPicker.setMinValue(0);
        amountPicker.setMaxValue(1000);
        progressBar.setMax(10000);

    }

    public void donateButtonPressed (View view)
    {
        String method = paymentMethod.getCheckedRadioButtonId() == R.id.payPal ? "PayPal" : "Direct";

        int donatedAmount = amountPicker.getValue();
        if (donatedAmount == 0)
        {
            String text = amountBox.getText().toString();
            if (!text.equals("")) {
                donatedAmount = Integer.parseInt(text);
            }
        }

        if (totalDonated + donatedAmount > 10000){
            Toast.makeText(this, "Target Reached - Refunding $" + (donatedAmount - (10000 - totalDonated)), Toast.LENGTH_SHORT).show();
            totalDonated = 10000;
        } else {
            totalDonated = totalDonated + donatedAmount;
        }

        progressBar.setProgress(totalDonated);
        String totalAmount = "$" + totalDonated;
        totalDisplay.setText(totalAmount);
        Log.v("Donate", donatedAmount + " donated by " +  method + "\nCurrent total " + totalDonated);
    }
}
