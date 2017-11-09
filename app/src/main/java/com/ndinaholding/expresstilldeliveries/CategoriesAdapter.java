package com.ndinaholding.expresstilldeliveries;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ndinaholding.expresstilldeliveries.fragment.PromotionsFragment;
import com.ndinaholding.expresstilldeliveries.fragment.ClientsFragment;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CategoriesAdapter extends BaseAdapter {

    private LayoutInflater layoutinflater;
    private List<ItemObject> listStorage;
    private Context context;

    public CategoriesAdapter(Context context, List<ItemObject> customizedListView) {
        this.context = context;
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

        final ViewHolder listViewHolder;
        if(convertView == null){
            listViewHolder = new ViewHolder();
            convertView = layoutinflater.inflate(R.layout.listview_categories, parent, false);
            listViewHolder.textHeader = convertView.findViewById(R.id.txtHeader);
            listViewHolder.imageButton = convertView.findViewById(R.id.imageButton);

            listViewHolder.imageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(context, "Button Clicked!!!", Toast.LENGTH_LONG).show();
                    if(listViewHolder.textHeader.getText().toString().equals("Retailer"))
                    {
                        ClientsFragment nextFrag= new ClientsFragment();
                        ((MainNavActivity) context).getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frame, nextFrag,"findThisFragment")
                                .addToBackStack(null)
                                .commit();
                    }
                }
            });
            convertView.setTag(listViewHolder);
        }else{
            listViewHolder = (ViewHolder)convertView.getTag();
        }

        listViewHolder.textHeader.setText(listStorage.get(position).getContent());
        int imageResourceId = this.context.getResources().getIdentifier(listStorage.get(position).getImageResource(), "drawable", this.context.getPackageName());
        Picasso.with(context)
                .load(imageResourceId)  //name of the image to load.
                .resize(600, 600)
                .into(listViewHolder.imageButton);
        return convertView;
    }

    static class ViewHolder{
        TextView textHeader;
        ImageButton imageButton;
    }

}
