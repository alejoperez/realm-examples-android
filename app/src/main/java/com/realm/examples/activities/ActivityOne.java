package com.realm.examples.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.realm.examples.R;
import com.realm.examples.models.User;

import io.realm.Realm;


public class ActivityOne extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Realm realm = Realm.getDefaultInstance();

        User user = realm.where(User.class).findFirst();

        Log.i("User","User = "+user.toString());

    }


}
