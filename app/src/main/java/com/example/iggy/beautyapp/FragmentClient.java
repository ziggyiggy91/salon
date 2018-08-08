package com.example.iggy.beautyapp;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.Contacts;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * Created by Iggy on 7/16/2018.
 */

public class FragmentClient extends Fragment {
    String [] columnName = {"example","example2","example3"};
    ArrayList<String> data;
    ArrayList<String> data2;

    String TAG = "FragmentClient";
    ListView listView;
    //ArrayAdapter<String> adapter;
    //ArrayAdapter<String> adapter2;
    IggyAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.client_fragment,container, false);
        listView = v.findViewById(R.id.listClient);

        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG,"onActivityCreated()");

    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart()");
        Cursor cursor;
        data = new ArrayList<>();
        data2 = new ArrayList<>();
        int i = 0;
        String[] mProjection = new String[]
                {
                        ContactsContract.Profile._ID,
                        ContactsContract.Profile.DISPLAY_NAME_PRIMARY,
                        ContactsContract.Profile.LOOKUP_KEY,
                        ContactsContract.Profile.PHOTO_THUMBNAIL_URI
                };
        ContentResolver cr;
        cr = getActivity().getContentResolver();
        cursor = getActivity().getContentResolver().query(
                ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                null,
                null,
                null,
                null);


        while (cursor.moveToNext()) {
                 Log.d("cursor", "cursor data : " + cursor.getColumnName(i));
            //for(int i = 0; i < columnName.length; i++) {
            String itemId = cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.NUMBER));
             String number = cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            //Cursor phones = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                  //  null, null, null);
           // String number = phones.getString(phones.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.NUMBER));

            //while(phones.moveToNext()){
              //  String number = phones.getString(phones.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.NUMBER));
            Log.d(TAG, "number: " + number);

            //}
            Log.d(TAG, "item: " + itemId);
            data.add(number);
            data2.add(itemId);

             i++;
            //}
        }
        adapter = new IggyAdapter(getActivity(),data,data2);
        //adapter = new ArrayAdapter<>(getContext(),R.layout.scrollclient_layout,R.id.dictWord,data);
        //adapter2 = new ArrayAdapter<>(getContext(),R.layout.scrollclient_layout,R.id.locale,data2);

        //  Cursor cursor = db.query(table,column,null,null,null,null,null);
        //listView.setAdapter(adapter);
        //listView.setAdapter(adapter2);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
            int position, long id) {
                Toast.makeText(getContext(), "You Clicked at " + data.get(position), Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG,"onResume()");

    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG,"onPause()");

    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG,"onStop()");

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG,"onDestroyView()");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy()");

    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG,"onDetach()");
    }
}
