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

/**
 * Created by Iggy on 7/16/2018.
 */

public class FragmentSalon extends Fragment  {
    NavigationView navigation;
    DrawerLayout drawer;
    Button salonButton;
    FragmentTransaction ft;
    String TAG = "FragmentSalon";

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
                                    ft.replace(R.id.salonClassLayout, client);
                                    ft.addToBackStack(null);
                                    ft.commit();

                                 break;
                            case "Inventory":
                                FragmentInventory inventory = new FragmentInventory();
                                ft = getFragmentManager().beginTransaction();
                                ft.replace(R.id.salonClassLayout,inventory);
                                ft.addToBackStack(null);
                                ft.commit();
                                break;
                            case "Calendar":
                                FragmentCalendar calendar = new FragmentCalendar();
                                ft = getFragmentManager().beginTransaction();
                                ft.replace(R.id.salonClassLayout,calendar);
                                ft.addToBackStack(null);
                                ft.commit();
                                break;
                            case "Settings":
                                FragmentSettings settings = new FragmentSettings();
                                ft = getFragmentManager().beginTransaction();
                                ft.replace(R.id.salonClassLayout,settings);
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

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG,"onActivityCreated()");

    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG,"onStart()");

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

