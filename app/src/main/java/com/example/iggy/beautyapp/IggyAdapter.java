package com.example.iggy.beautyapp;

import android.app.Activity;
import android.graphics.Bitmap;
import android.media.Image;
 import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by Iggy on 4/2/2018.
 */

public class IggyAdapter extends ArrayAdapter<String> {
    CursorAdapter mAdapter;
    ListView list;
    ListAdapter listAdapter;
    Activity mContext;
    ArrayList<String> name;
    ArrayList<String> number;

    String TAG = "IggyAdapter";

    public IggyAdapter(Activity context, ArrayList<String> name0,ArrayList<String>number0){
        super(context, R.layout.scrollclient_layout,name0);
        this.mContext = context;
        this.name = name0;
        this.number = number0;
        Log.d(TAG,"IggyAdapter Constructor: " + name.get(0) + " size: " + name.size());
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = mContext.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.scrollclient_layout, null, true);
        TextView txtTitle =  rowView.findViewById(R.id.dictWord);
        txtTitle.setText(name.get(position));
        TextView texTitle2 = rowView.findViewById(R.id.locale);
        texTitle2.setText(number.get(position));
         return rowView;
    }


}
