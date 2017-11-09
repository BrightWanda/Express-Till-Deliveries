package com.ndinaholding.expresstilldeliveries;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.ndinaholding.expresstilldeliveries.POJOs.Special;

import java.util.ArrayList;
import java.util.List;

public class Specials extends AppCompatActivity {
    ListView list;
    SpecialsAdapter adapter;
    private List<Special> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specials);

        list= (ListView)findViewById(R.id.list);

        Special special = new Special();
        Special special1 = new Special();
        Special special2 = new Special();

        special.setError(false);
        special.setItem("Albany White Bread");
        special.setDateValidity("Valid Until October 28");
        special.setImageString("albany");
        special.setPrice(17.50);

        items = new ArrayList<>();

        items.add(0, special);

        special1.setError(false);
        special1.setItem("Koo Baked Beans");
        special1.setDateValidity("Valid Until October 18");
        special1.setImageString("koo");
        special1.setPrice(9.90);

        items.add(1, special1);

        special2.setError(false);
        special2.setItem("Hullet White Sugar 500ml");
        special2.setDateValidity("Valid Until October 20");
        special2.setImageString("hullet");
        special2.setPrice(7.45);

        items.add(2, special2);

        /*adapter=new SpecialsAdapter(this, items);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Toast.makeText(getApplicationContext(), position, Toast.LENGTH_LONG).show();
/*
                Intent intent = new Intent(getApplicationContext(), TripConfirm.class);
                intent.putExtra(EXTRA_MESSAGE, adapter.getItem(position));
                intent.putExtra(LONG,longitude+"");
                intent.putExtra(DESTINATION, dest);
                intent.putExtra(LAT,latitude+"");

                startActivity(intent);
        }
    });*/
    }
}
