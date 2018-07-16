package com.example.iggy.beautyapp;

 import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
 import android.support.v4.app.Fragment;
 import android.support.v4.app.FragmentTransaction;
 import android.util.Log;
 import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

 import static android.content.ContentValues.TAG;

/**
 * Created by Iggy on 7/16/2018.
 */

public class FragmentLogin extends Fragment {
    Button login;
    Button signUp;

    @Override
    public void onCreate(Bundle onSavedInstance){
        super.onCreate(onSavedInstance);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG,"FragmentLogin onCreateView()");
        View v = inflater.inflate(R.layout.login_fragment,container,false);
       login = v.findViewById(R.id.loginButton);
        signUp = v.findViewById(R.id.signUpButton);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentSalon salon = new FragmentSalon();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragmentLayout,salon);
                transaction.commit();
            }
        });
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
