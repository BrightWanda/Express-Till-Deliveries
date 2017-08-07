package com.ndinaholding.expresstilldeliveries;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class LazyAdapter extends BaseAdapter {
    
    private Activity activity;
    private String [] items;
    private static LayoutInflater inflater=null;
    public ImageLoader imageLoader; 
    
    public LazyAdapter(Activity a, String[] d) {
        this.activity = a;
        this.items = d;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        imageLoader=new ImageLoader(activity.getApplicationContext());
    }

    public int getCount() {
        return items.length;
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }
    
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi=convertView;
        if(convertView==null)
            vi = inflater.inflate(R.layout.list_row, null);

        TextView title = vi.findViewById(R.id.title); // title
        TextView artist = vi.findViewById(R.id.artist); // artist name
        TextView duration = vi.findViewById(R.id.duration); // duration
        ImageView thumb_image= vi.findViewById(R.id.list_image); // thumb image

        String item = items[position];
        
        // Setting all values in listview
        title.setText(item);
        artist.setText("");
        duration.setText("");
        imageLoader.DisplayImage(activity, item, thumb_image);
        return vi;
    }
}