package com.example.iggy.beautyapp;

import android.app.Activity;
import android.support.v4.app.FragmentTransaction;

import android.os.Bundle;
import android.support.annotation.Nullable;
 import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Iggy on 7/16/2018.
 */

public class MainActivity extends AppCompatActivity {

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



}
