package com.realm.examples.activities;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.realm.examples.R;
import com.realm.examples.models.User;

import io.realm.Realm;

public class SecondActivity extends AppCompatActivity {

    Realm realm = Realm.getDefaultInstance();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String userId = getIntent()
                .getStringExtra("userId");

        User user = realm.where(User.class)
                .equalTo("userId",userId)
                .findFirst();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }
}
