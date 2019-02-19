package net.wawczak.brian.mccwirelessbrianw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;

public class wirelessPlans extends AppCompatActivity {


    int newCustomerDiscount;
    int selectedPlan;
    int numOfLines;
    int numOfAndroidOnes;
    int numOfSamsungGalaxy8;
    int numOfSamsungGalaxy9;
    int numOfGooglePixel;
    int numOfSonyX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wireless_plans);

        Button idBtnCheckout = findViewById(R.id.idBtnCheckout);
        Button idBtnPhones = findViewById(R.id.idBtnPhones);
        Button idBtnGoHome = findViewById(R.id.idBtnGoHome);

        final RadioButton rbBudget = findViewById(R.id.rbBudget);
        final RadioButton rbStandard = findViewById(R.id.rbStandard);
        final RadioButton rbUnlimited = findViewById(R.id.rbUnlimited);

        final RadioButton rbNewCustomer = findViewById(R.id.rbNewCustomer);


        final Spinner spNumberOfLines = findViewById(R.id.spNumberOfLines);
        final Spinner spAndroidOne = findViewById(R.id.spAndroidOne);
        final Spinner spSamsungGalaxy9 = findViewById(R.id.spSamsungGalaxy9);
        final Spinner spSamsungGalaxy8 = findViewById(R.id.spSamsungGalaxy8);
        final Spinner spGooglePixel = findViewById(R.id.spGooglePixel);
        final Spinner spSonyX = findViewById(R.id.spSonyX);

        idBtnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rbNewCustomer.isChecked()){
                    newCustomerDiscount = 0;
                }else{
                    newCustomerDiscount = 1;
                }if (rbBudget.isChecked()) {
                    selectedPlan = 1;
                }else if (rbStandard.isChecked()) {
                    selectedPlan = 2;
                }else if (rbUnlimited.isChecked()) {
                    selectedPlan = 3;
                }
                numOfLines = Integer.parseInt(spNumberOfLines.getSelectedItem().toString());
                numOfAndroidOnes = Integer.parseInt(spAndroidOne.getSelectedItem().toString());
                numOfSamsungGalaxy8 = Integer.parseInt(spSamsungGalaxy8.getSelectedItem().toString());
                numOfSamsungGalaxy9 = Integer.parseInt(spSamsungGalaxy9.getSelectedItem().toString());
                numOfGooglePixel = Integer.parseInt(spGooglePixel.getSelectedItem().toString());
                numOfSonyX = Integer.parseInt(spSonyX.getSelectedItem().toString());

                int[] screenData = {newCustomerDiscount, selectedPlan, numOfLines, numOfAndroidOnes, numOfSamsungGalaxy8, numOfSamsungGalaxy9, numOfGooglePixel, numOfSonyX};

                Intent intent = new Intent(wirelessPlans.this, summary.class);
                intent.putExtra("UserChoice", screenData);
                startActivity(intent);
            }
        });

        idBtnPhones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(wirelessPlans.this, viewPhones.class);
                startActivity(intent);
            }
        });

        idBtnGoHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(wirelessPlans.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
