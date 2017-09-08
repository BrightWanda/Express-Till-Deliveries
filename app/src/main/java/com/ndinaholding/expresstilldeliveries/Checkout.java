package com.ndinaholding.expresstilldeliveries;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Checkout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        TextView groceryDetails = (TextView) findViewById(R.id.grocery_details);
        String text = "Grocery Checkout\n" +
                "\t Hullets Sugar 1kg = R14.50\n" +
                "\t Eggs 6's = R10.99\n" +
                "\t Clover Full Cream Milk 1tr = R27.50\n" +
                "\t Total = R52.99";

        groceryDetails.setText(text);

        Button mProceedButton = (Button) findViewById(R.id.proceed);
        mProceedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(intent);
            }
        });
    }
}
