package net.wawczak.brian.mccwirelessbrianw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class currentDeals extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_deals);

        Button viewPhones = findViewById(R.id.idBtnViewPhones);
        Button viewPlans = findViewById(R.id.idBtnViewPlans);
        Button home = findViewById(R.id.idBtnHome);

        viewPhones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (currentDeals.this, viewPhones.class);
                startActivity(intent);
            }
        });

        viewPlans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (currentDeals.this, wirelessPlans.class);
                startActivity(intent);

            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (currentDeals.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }

}
