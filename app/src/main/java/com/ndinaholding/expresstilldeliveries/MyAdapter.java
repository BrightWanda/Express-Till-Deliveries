package com.ndinaholding.expresstilldeliveries;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ndinaholding.expresstilldeliveries.POJOs.Client;
import com.ndinaholding.expresstilldeliveries.POJOs.Retailer_;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by wandab on 2017/10/03.
 */

public class MyAdapter extends ArrayAdapter {

    private static LayoutInflater inflater=null;
    private List<Client> clients;
    private Context ctx;

    public MyAdapter(Context context, int textViewResourceId,
                     List<Client> clients) {
        super(context, textViewResourceId, clients);
        this.clients = clients;
        this.ctx = context;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public View getCustomView(int position, View convertView,
                              ViewGroup parent) {

        // Inflating the layout for the custom Spinner
        View layout = inflater.inflate(R.layout.custom, parent, false);

        // Declaring and Typecasting the textview in the inflated layout
        TextView tvLanguage = layout.findViewById(R.id.tvLanguage);

        tvLanguage.setText(clients.get(position).getClientName());

        tvLanguage.setTextColor(Color.rgb(33,53,114));

        tvLanguage.setTextSize(30);
        tvLanguage.setTypeface(null, Typeface.BOLD_ITALIC);

        // Declaring and Typecasting the imageView in the inflated layout
        ImageView img = (ImageView) layout.findViewById(R.id.imgLanguage);

        // Setting an image using the id's in the array
        //img.setImageResource(R.drawable.image_3);

        Picasso.with(ctx)  //Here, this is context.
                .load("http://testqa.co.za/admin/uploads/2/logos/"+clients.get(position).getClientCode()+"/logo.jpg")  //Url of the image to load.
                .resize(150, 150) //resizing width and height of image
                .centerCrop()  // transform image.
                .into(img);

        // Setting Special atrributes for 1st element
        if (position == 0) {
            // Removing the image view
            img.setVisibility(View.GONE);
            // Setting the size of the text
            tvLanguage.setTextSize(20f);
            // Setting the text Color
            tvLanguage.setTextColor(Color.rgb(33,53,114));
        }

        return layout;
    }

    // It gets a View that displays in the drop down popup the data at the specified position
    @Override
    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    // It gets a View that displays the data at the specified position
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }
}