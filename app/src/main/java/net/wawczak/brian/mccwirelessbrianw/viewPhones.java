package net.wawczak.brian.mccwirelessbrianw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class viewPhones extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_phones);

        Button btnPlans = findViewById(R.id.idBtnP);
        Button btnHm = findViewById(R.id.idBtnHm);

        btnPlans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(viewPhones.this, wirelessPlans.class);
                startActivity(intent);
            }
        });

        btnHm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(viewPhones.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
