package com.ndinaholding.expresstilldeliveries;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.ndinaholding.expresstilldeliveries.POJOs.Login;
import com.ndinaholding.expresstilldeliveries.POJOs.Retailer;
import com.ndinaholding.expresstilldeliveries.POJOs.Retailer_;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetailerList extends Activity implements AdapterView.OnItemSelectedListener {
	// All static variables
	ListView list;
    LazyAdapter adapter;

	private ApiInterface apiInterface;
	private ProgressBar spinner;
	private Retailer retailerRes;
    private RadioGroup rdGroup;
	public static final String EXTRA_MESSAGE = "com.ndinaholding.expresstilldeliveries.MESSAGE";
	private String apiKey;

    // Declaring the String Array with the Text Data for the Spinners
    String[] Languages = { "Select Your Retailer", "Boxer", "Checkers",
            "Pick n Pay", "Shoprite" };
    // Declaring the Integer Array with resourse Id's of Images for the Spinners
    Integer[] images = { 0, R.drawable.boxer, R.drawable.checkers,
            R.drawable.picknpay, R.drawable.shoprite };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_retailer_list);

        // Declaring and typecasting a Spinner
        Spinner mySpinner = (Spinner) findViewById(R.id.retailer_spinner);

        // Setting a Custom Adapter to the Spinner

        /*MyAdapter myAdapter = new MyAdapter(RetailerList.this, R.layout.custom,
                Languages);
        mySpinner.setAdapter(myAdapter);

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if(selectedItem.equals("Select a Retailer"))
                {

                }
                else {
                    ///Intent intent = new Intent(getApplicationContext(), GroceryList.class);
                    //startActivity(intent);
                }
            } // to close the onItemSelected
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });*/
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();

    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }

    // Creating an Adapter Class

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


}