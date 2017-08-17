package com.ndinaholding.expresstilldeliveries;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;

public class RetailerList extends Activity {
	// All static variables
	ListView list;
    LazyAdapter adapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_retailer_list);

		String[] items = {"Bread", "Milk", "Eggs", "Sugar", "Soap"};
/*
		list= findViewById(R.id.list);

		// Getting adapter by passing xml data ArrayList
        adapter=new LazyAdapter(this,items);
        list.setAdapter(adapter);

        // Click event for single list row
        list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent intent = new Intent(getApplicationContext(), ItemDetails .class);
				startActivity(intent);
			}
		});

		Button proceed = (Button) findViewById(R.id.proceed);
		proceed.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(getApplicationContext(), Checkout .class);
				startActivity(intent);
			}
		});*/
	}

	public void onRadioButtonClicked(View view) {
		// Is the button now checked?
		boolean checked = ((RadioButton) view).isChecked();
		Intent intent = new Intent(getApplicationContext(), GroceryList.class);

		// Check which radio button was clicked
		switch(view.getId()) {
			case R.id.shoprite:
				startActivity(intent);
				break;
			case R.id.checkers:
				startActivity(intent);
				break;
            case R.id.boxer:
                startActivity(intent);
                break;
            case R.id.spar:
                startActivity(intent);
                break;
            case R.id.pick_n_pay:
                startActivity(intent);
                break;
		}
	}
}