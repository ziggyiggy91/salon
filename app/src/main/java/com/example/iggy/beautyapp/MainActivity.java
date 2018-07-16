package com.example.iggy.beautyapp;


import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

// this imports all your items from your layout
/**
 * Created by Iggy on 7/16/2018.
 */

public class MainActivity extends AppCompatActivity {
    /**
     *  onCreate - Program invokes a login fragment object.
     *
     * @param savedInstanceState
     */
    //Application entering state
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentLogin login = new FragmentLogin();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        // removes the existing fragment calling onDestroy
        ft.add(R.id.fragmentLayout,login);
        ft.addToBackStack(null);
        ft.commit();
    }

    //Instatiated after onCreate
   @Override
    public void onStart(){
        super.onStart();
   }

   //User returns to the activity
   @Override
   public void onResume(){
        super.onResume();
   }

   //Another activity comes into the foreground
   @Override
    public void onPause(){
        super.onPause();
   }

   //User navigates to the activity
    @Override
    public void onRestart() {
        super.onRestart();
    }

    //The activity is no longer visible
    @Override
    public void onStop(){
        super.onStop();
    }

}
