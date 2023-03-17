package com.example.myapplication444;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class ListAdapter1 extends ArrayAdapter<Item> {
    private Context context;
    private List<Item> listItems;

    public ListAdapter1(Context context, List<Item> listItems) {
        super(context, R.layout.list_layout, listItems);
        this.context = context;
        this.listItems = listItems;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_layout, parent, false);

        TextView textView = rowView.findViewById(R.id.item_text);
        ImageView imageView = rowView.findViewById(R.id.item_image);

        textView.setText(listItems.get(position).getText());
        imageView.setImageResource(listItems.get(position).getImage());

        return rowView;
    }
}
