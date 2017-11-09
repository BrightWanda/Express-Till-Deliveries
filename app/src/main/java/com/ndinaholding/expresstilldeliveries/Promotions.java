package com.ndinaholding.expresstilldeliveries;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Promotions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promotions);

        GridView gridview = (GridView) findViewById(R.id.gridview);

        List<ItemObject> allItems = getAllItemObject();
        //CustomAdapter customAdapter = new CustomAdapter(Promotions.this, allItems);
        //gridview.setAdapter(customAdapter);

        /*gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Promotions.this, "Position: " + position, Toast.LENGTH_SHORT).show();
            }
        });*/
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private List<ItemObject> getAllItemObject(){
        ItemObject itemObject = null;
        List<ItemObject> items = new ArrayList<>();
        items.add(new ItemObject("AquaFresh", "aquafresh", "R 59.00"));
        items.add(new ItemObject("Colgate", "aquafresh", "R 34.00"));
        items.add(new ItemObject("Mentadyne", "aquafresh", "R 45.00"));
        items.add(new ItemObject("Colgate", "aquafresh", "R 20.00"));
        items.add(new ItemObject("AquaFresh", "aquafresh", "R 60.00"));
        items.add(new ItemObject("Mentadyne", "aquafresh", "R 114.00"));
        items.add(new ItemObject("Colgate", "aquafresh", "R 36.00"));
        items.add(new ItemObject("AquaFresh", "aquafresh", "R 76.00"));
        items.add(new ItemObject("Mentadyne", "aquafresh", "R 90.00"));
        items.add(new ItemObject("Colgate", "aquafresh", "R 63.00"));
        items.add(new ItemObject("Aquafresh", "aquafresh", "R 73.00"));
        items.add(new ItemObject("Mentadyne", "aquafresh", "R 49.00"));
        return items;
    }
}
