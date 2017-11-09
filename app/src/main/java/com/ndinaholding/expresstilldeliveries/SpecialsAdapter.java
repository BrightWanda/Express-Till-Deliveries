package com.ndinaholding.expresstilldeliveries;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ndinaholding.expresstilldeliveries.POJOs.Special;

import java.text.DecimalFormat;
import java.util.List;

public class SpecialsAdapter extends BaseAdapter {

    private Activity activity;
    private List<Special> specials;
    private static LayoutInflater inflater=null;
    private ImageLoader imageLoader;

    public static final String MyORDER = "MyOrder";
    public static final String Item = "itemKey";
    public static final String Price = "priceKey";
    public static final String Total = "totalKey";
    public static final String ItemCount = "itemCount";

    private String orderItem;
    private String orderPrice;
    private TextView txtTot;

    SharedPreferences sharedpreferences;

    public SpecialsAdapter(Activity a, List<Special> d, TextView txtTot) {
        this.specials = d;
        this.activity = a;
        this.txtTot = txtTot;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        imageLoader=new ImageLoader(activity.getApplicationContext());
    }

    public int getCount() {
        return specials.size();
    }

    public Special getItem(int position) {
        return specials.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View vi=convertView;
        if(convertView==null)
            vi = inflater.inflate(R.layout.list_row, null);

        TextView txtItem = vi.findViewById(R.id.title); // title
        TextView txtValidDate = vi.findViewById(R.id.artist); // artist name
        TextView txtPrice = vi.findViewById(R.id.duration); // duration
        ImageView thumb_image= vi.findViewById(R.id.list_image); // thumb image

        orderItem = txtItem.getText().toString();
        orderPrice = txtPrice.getText().toString();

        vi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Do something
                sharedpreferences = activity.getSharedPreferences(MyORDER, Context.MODE_PRIVATE);

                float localTotal = 0.00f;
                localTotal = sharedpreferences.getFloat(Total, localTotal);


                Toast.makeText(activity, localTotal + "", Toast.LENGTH_LONG).show();

                localTotal = localTotal + Float.parseFloat(orderPrice.substring(2));

                int count = 0;
                count = sharedpreferences.getInt(ItemCount, count);
                if(count < 15)
                {
                    txtTot.setText("Total: R " + String.format("%.2f", localTotal));
                    SharedPreferences.Editor editor = sharedpreferences.edit();

                    editor.putString(Item, orderItem);
                    editor.putString(Price, orderPrice);
                    editor.putFloat(Total, localTotal);
                    editor.putInt(ItemCount, count++);
                    editor.commit();

                    Toast.makeText(activity, "Item Added to the order.", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(activity, "Items exceeded the maximum number of items allowed.", Toast.LENGTH_LONG).show();
                }
            }
        });


        String item = specials.get(position).getImageString();

        txtItem.setText(specials.get(position).getItem() );

        String txt = "R " + specials.get(position).getPrice();
        txtPrice.setText(txt);
        txtValidDate.setText(specials.get(position).getDateValidity());
        imageLoader.DisplayImage(activity, item, thumb_image);
        return vi;
    }
}