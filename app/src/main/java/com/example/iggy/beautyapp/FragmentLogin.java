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
    public void onStart() {
        super.onStart();
    }


}
