package net.wawczak.brian.mccwirelessbrianw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.text.DecimalFormat;
import static java.util.Arrays.copyOfRange;

public class summary extends AppCompatActivity {

    int[] data;
    int selectedPlan;
    int numOfLines;
    double totalDiscount;
    double planPrice;
    double phoneTotal = 0;
    double grandTotal;
    double additionalLineCost;
    double bonusDiscount;
    boolean existingUpgrade;
    boolean newCustomerDiscount;
    boolean multiLine;
    boolean specialDiscount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        TextView idTxtPhoneCost = findViewById(R.id.idTxtPhoneCost);
        TextView idTxtPlanCost = findViewById(R.id.idTxtPlanCost);
        TextView idTxtNumOfLines = findViewById(R.id.idTxtNumOfLines);
        TextView idTxtPlanTotal = findViewById(R.id.idTxtPlanTotal);
        TextView idTxtMultiDiscount = findViewById(R.id.idTxtMultiDiscount);
        TextView idTxtNewCustDiscount = findViewById(R.id.idTxtNewCustDiscount);
        TextView idTxtTotalCost = findViewById(R.id.idTxtGrandTotal);
        TextView idLblNewCust = findViewById(R.id.idLblNewCust);
        TextView idLblUpgradeDiscount = findViewById(R.id.idLblUpgradeDiscount);
        TextView idBonusDiscount = findViewById(R.id.idBonusDiscount);

        DecimalFormat roundNumber = new DecimalFormat("$###.##");

        Bundle userPicks = getIntent().getExtras();
        if (userPicks != null) {
            data = userPicks.getIntArray("UserChoice");
        }

        assert data != null;
        newCustomerDiscount = data[0] == 1;
        existingUpgrade = data[0] == 0;

        selectedPlan = data[1];
        numOfLines = data[2];
        multiLine = data[2] > 1;

        if((newCustomerDiscount) && (multiLine) || (existingUpgrade) && (multiLine)){
            specialDiscount = true;
        }

        double[] phonePrices = {389.99, 385, 549.99, 549.99, 499.99};
        int[] phoneCount = copyOfRange(data, 3, 8);
        double[] planPriceArray = {29.99, 39.99, 49.99};

        planPrice = planPriceArray[selectedPlan];

        phoneTotal = calculatePhoneCost(phoneCount, phonePrices);

        additionalLineCost = calculateAdditionalLineCost(data[2]);

        totalDiscount = calculateTotalDiscount(newCustomerDiscount, existingUpgrade, multiLine, phoneTotal, planPrice);

        bonusDiscount = calculateSpecialDiscount(specialDiscount, planPrice);

        grandTotal = calculateGrandTotal(planPrice, phoneTotal, additionalLineCost, totalDiscount);


        if (newCustomerDiscount){
            idLblUpgradeDiscount.setVisibility(View.INVISIBLE);
            idLblNewCust.setVisibility(View.VISIBLE);
            if (phoneTotal > 0) {
                idTxtNewCustDiscount.setText(roundNumber.format(300));
            }else{
                idTxtNewCustDiscount.setText(roundNumber.format(0));
            }
        }else{
            idLblUpgradeDiscount.setVisibility(View.VISIBLE);
            idLblNewCust.setVisibility(View.INVISIBLE);
            if (phoneTotal > 0) {
                idTxtNewCustDiscount.setText(roundNumber.format(phoneTotal * .3));
            }else{
                idTxtNewCustDiscount.setText(roundNumber.format(0));
            }
        }

        idTxtPhoneCost.setText(roundNumber.format(phoneTotal));
        idTxtPlanCost.setText(roundNumber.format(planPrice));
        idTxtNumOfLines.setText(String.valueOf(numOfLines));
        idTxtPlanTotal.setText(roundNumber.format((numOfLines - 1) * 20));
        if (multiLine) {
            idTxtMultiDiscount.setText(roundNumber.format(planPrice * .20));
        }else{
            idTxtMultiDiscount.setText(roundNumber.format(0));
        }
        idTxtTotalCost.setText(roundNumber.format(grandTotal));
        idBonusDiscount.setText(roundNumber.format(bonusDiscount));
    }

    public double calculateSpecialDiscount(boolean specialDiscount, double planPrice){
        double x;
        if (specialDiscount){
            x = planPrice * .05;
        }else{
            x = 0;
        }
        return x;
    }
    public double calculatePhoneCost(int[] phoneCount, double[] phonePrices){
        double sum;
        for (int count = 0; count < phonePrices.length; count++) {
            sum = phoneCount[count] * phonePrices[count];
            phoneTotal = phoneTotal + sum;
        }
        return phoneTotal;
    }
    public double calculateAdditionalLineCost(double numberOfLines){
        double total = 0;
        if (numberOfLines > 1){
            total = (numOfLines - 1) * 20;
        }
        return total;
    }
    public double calculateTotalDiscount(boolean newCustomerDiscount, boolean existingUpgrade, boolean multiLine, double phoneTotal, double planPrice) {
        double a;
        double b;
        double c;
        double d;
        double totalDiscount;
        if (newCustomerDiscount){
            a = 300;
        }else{
            a = 0;
        }if (existingUpgrade){
            b = (phoneTotal * .3);
        }else{
            b = 0;
        }if (multiLine){
            c = (planPrice * .2);
        }else{
            c = 0;
        }if ((newCustomerDiscount) && (multiLine) || (existingUpgrade) && (multiLine)){
            d = planPrice * .05;
        }else{
            d = 0;
        }
        totalDiscount = a + b + c + d;
        return totalDiscount;
    }
    public double calculateGrandTotal(double planPrice, double phoneTotal, double additionalLineCost, double totalDiscount){
        double total;
        total = planPrice + phoneTotal + additionalLineCost - totalDiscount;
        return total;
    }

}
