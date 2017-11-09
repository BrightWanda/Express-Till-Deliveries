package com.ndinaholding.expresstilldeliveries;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.List;

public class CustomAdapter extends BaseAdapter {

    private LayoutInflater layoutinflater;
    private List<ItemObject> listStorage;
    private Context context;
    private TextView txtTot;

    public static final String MyORDER = "MyOrder";
    public static final String Item = "itemKey";
    public static final String Price = "priceKey";
    public static final String Total = "totalKey";
    public static final String ItemCount = "itemCount";

    private String orderItem;
    private String orderPrice;

    SharedPreferences sharedpreferences;

    public CustomAdapter(Context context, List<ItemObject> customizedListView, TextView txtTot) {
        this.context = context;
        this.txtTot = txtTot;
        layoutinflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        listStorage = customizedListView;
    }

    @Override
    public int getCount() {
        return listStorage.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder listViewHolder;
        if(convertView == null){
            listViewHolder = new ViewHolder();
            convertView = layoutinflater.inflate(R.layout.listview_with_text_image, parent, false);
            listViewHolder.textInListView = convertView.findViewById(R.id.textView);
            listViewHolder.textHeader = convertView.findViewById(R.id.txtHeader);
            listViewHolder.imageInListView = convertView.findViewById(R.id.imageView);

            orderPrice = listViewHolder.textHeader.toString();
            orderItem = listViewHolder.textInListView.toString();

            listViewHolder.btnAddToCart = convertView.findViewById(R.id.AddToCart);
            listViewHolder.btnAddToCart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Do something
                    sharedpreferences = context.getSharedPreferences(MyORDER, Context.MODE_PRIVATE);

                    float localTotal = 0.00f;
                    localTotal = sharedpreferences.getFloat(Total, localTotal);

                    localTotal = localTotal + Float.parseFloat(orderPrice.substring(1));
                    //String.format("%.2f", localTotal);
                    txtTot.setText("Total: R " + String.format("%.2f", localTotal));
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

                        Toast.makeText(context, "Item Added to the order.", Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Toast.makeText(context, "Items exceeded the maximum number of items allowed.", Toast.LENGTH_LONG).show();
                    }
                }
            });



            convertView.setTag(listViewHolder);
        }else{
            listViewHolder = (ViewHolder)convertView.getTag();
        }

        listViewHolder.textHeader.setText(listStorage.get(position).getPrice());
        orderPrice = listViewHolder.textHeader.getText().toString();
        listViewHolder.textInListView.setText(listStorage.get(position).getContent());
        orderItem = listViewHolder.textInListView.getText().toString();
        //listViewHolder.textInListView.setText(listStorage.get(position).getContent());
        int imageResourceId = this.context.getResources().getIdentifier(listStorage.get(position).getImageResource(), "drawable", this.context.getPackageName());
        listViewHolder.imageInListView.setImageResource(imageResourceId);
        return convertView;
    }

    static class ViewHolder{
        TextView textHeader;
        TextView textInListView;
        ImageView imageInListView;
        Button btnAddToCart;
    }

}
