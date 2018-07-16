package com.example.iggy.beautyapp;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import static android.content.ContentValues.TAG;

/**
 * Created by Iggy on 7/16/2018.
 */

public class FragmentSalon extends Fragment {
    NavigationView navigation;
    DrawerLayout drawer;
    Button salonButton;
    FragmentTransaction ft;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         View v = inflater.inflate(R.layout.salonclass_fragment,container,false);
         navigation = v.findViewById(R.id.salonNavigation);
         drawer = v.findViewById(R.id.salonDrawerLayout);
         salonButton = v.findViewById(R.id.salonClassButton);
         salonButton.setOnClickListener(salonButtonListener);
         navigation.setNavigationItemSelectedListener(
                 new NavigationView.OnNavigationItemSelectedListener() {
                     @Override
                     public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        item.setChecked(true);
                        drawer.closeDrawers();

                        switch(item.toString()){
                            case "Client":
                                FragmentClient client = new FragmentClient();
                                ft = getFragmentManager().beginTransaction();
                                ft.replace(R.id.fragmentLayout,client);
                                ft.addToBackStack(null);
                                ft.commit();
                                break;
                            case "Inventory":
                                FragmentInventory inventory = new FragmentInventory();
                                ft = getFragmentManager().beginTransaction();
                                ft.replace(R.id.fragmentLayout,inventory);
                                ft.addToBackStack(null);
                                ft.commit();
                                break;
                            case "Calendar":
                                FragmentCalendar calendar = new FragmentCalendar();
                                ft = getFragmentManager().beginTransaction();
                                ft.replace(R.id.calendarFragment,calendar);
                                ft.addToBackStack(null);
                                ft.commit();
                                break;
                            case "Settings":
                                FragmentSettings settings = new FragmentSettings();
                                ft = getFragmentManager().beginTransaction();
                                ft.replace(R.id.calendarFragment,settings);
                                ft.addToBackStack(null);
                                ft.commit();
                                break;
                        }
                        Log.d(TAG,"Item: " + item.toString());
                        return true;
                     }
                 }
         );
        return v;
    }

    private View.OnClickListener salonButtonListener = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            drawer.openDrawer(Gravity.START);



        }};


    }

