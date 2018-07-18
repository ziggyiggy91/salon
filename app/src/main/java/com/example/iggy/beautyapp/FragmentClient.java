package com.example.iggy.beautyapp;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by Iggy on 7/16/2018.
 */

public class FragmentClient extends Fragment {
    String [] columnName = {};
    String TAG = "FragmentClient";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.client_fragment,container, false);

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
        Log.d(TAG,"onStart()");
        Cursor cursor;
        String[] mProjection = new String[]
                {
                        ContactsContract.Profile._ID,
                        ContactsContract.Profile.DISPLAY_NAME_PRIMARY,
                        ContactsContract.Profile.LOOKUP_KEY,
                        ContactsContract.Profile.PHOTO_THUMBNAIL_URI
                };


        cursor = getActivity().getContentResolver().query(
                ContactsContract.Profile.CONTENT_URI,
                mProjection ,
                null,
                null,
                null);



        while(cursor.moveToNext()) {
            columnName = cursor.getColumnNames();

            for(int i = 0; i < columnName.length; i++) {
                String itemId = cursor.getString(cursor.getColumnIndexOrThrow(""+columnName[i] +""));
            Log.d(TAG, "item: " + itemId);
            }
        }
      //  Cursor cursor = db.query(table,column,null,null,null,null,null);


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
