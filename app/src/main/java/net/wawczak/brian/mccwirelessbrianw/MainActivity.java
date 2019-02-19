package net.wawczak.brian.mccwirelessbrianw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button next = findViewById(R.id.idbtnNext);
        final RadioButton deals = findViewById(R.id.rbCurrentDeals);
        final RadioButton plans = findViewById(R.id.rbChooseAPlan);
        final RadioButton phones = findViewById(R.id.rbViewPhones);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(deals.isChecked()){
                    Intent intent = new Intent (MainActivity.this, currentDeals.class);
                    startActivity(intent);
                }else if(plans.isChecked()){
                    Intent intent = new Intent (MainActivity.this, wirelessPlans.class);
                    startActivity(intent);
                }else if(phones.isChecked()){
                    Intent intent = new Intent (MainActivity.this, viewPhones.class);
                    startActivity(intent);
                }

            }
        });

    }
}
