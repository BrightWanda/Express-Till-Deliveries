package com.ndinaholding.expresstilldeliveries;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ItemDetails extends Activity {
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        Button proceed = (Button) findViewById(R.id.proceed);
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), GroceryList.class);
                startActivity(intent);
            }
        });
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Choose Brand");
        listDataHeader.add("Choose size");

        // Adding child data
        List<String> brands = new ArrayList<String>();
        brands.add("Hullets");
        brands.add("Illovo");
        brands.add("No Name");

        List<String> size = new ArrayList<String>();
        size.add("500 g");
        size.add("1 kg");
        size.add("2.5 kg");
        size.add("5 kg");

        listDataChild.put(listDataHeader.get(0), brands); // Header, Child data
        listDataChild.put(listDataHeader.get(1), size);
    }
}