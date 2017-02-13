package com.realm.examples;

import android.database.DataSetObserver;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.realm.examples.models.Restaurant;
import com.realm.examples.models.User;
import com.realm.examples.repositories.Repository;

import java.util.Arrays;
import java.util.Date;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmList;
import io.realm.RealmResults;
import io.realm.Sort;

public class MainActivity extends AppCompatActivity {

    private Realm realm = Realm.getDefaultInstance();

    ArrayAdapter listAdapter;
    ListView listView;

    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRealm();

        listAdapter = new ArrayAdapter<String>(this,0,Arrays.asList());
        listView = new ListView(this);
        listView.setAdapter(listAdapter);

        RealmResults<Restaurant> restaurants = realm.where(Restaurant.class).findAllAsync();
        restaurants.addChangeListener(callback);

    }

    private RealmChangeListener callback = new RealmChangeListener<RealmResults<Restaurant>>() {
        @Override
        public void onChange(RealmResults<Restaurant> result) {
            // Called when the query complete or updated
            // Adapter with RealmResults<Restaurant> as data
            // It is not necessary to re-query
            listAdapter.notifyDataSetChanged();
        }
    };

    @Override
    protected void onStop() {
        super.onStop();
        realm.removeAllChangeListeners();
    }

    private void initRealm() {
        Restaurant r1 = new Restaurant();
        r1.setRestaurantId("1");
        r1.setName("KFC");
        r1.setLatitude(4.578163);
        r1.setLongitude(-74.348358);

        Restaurant r2 = new Restaurant();
        r2.setRestaurantId("2");
        r2.setName("Dominos");
        r2.setLatitude(4.678163);
        r2.setLongitude(-74.048358);

        Restaurant r3 = new Restaurant();
        r3.setRestaurantId("3");
        r3.setName("Krispy Kreme");
        r3.setLatitude(4.478163);
        r3.setLongitude(-74.248358);

        RealmList<Restaurant> rl1 = new RealmList<>();
        rl1.add(r1);
        rl1.add(r2);
        rl1.add(r3);

        Date d1 = new Date();
        d1.setYear(100);

        User user1 = new User();
        user1.setUserId("1");
        user1.setName("John");
        user1.setAge(13.8);
        user1.setFavoriteRestaurant(rl1);
        user1.setBirthday(d1);

        RealmList<Restaurant> rl2 = new RealmList<>();
        rl2.add(r2);
        rl2.add(r3);

        Date d2 = new Date();
        d2.setYear(90);

        User user2 = new User();
        user2.setUserId("2");
        user2.setName("Bob");
        user2.setAge(13.6);
        user2.setFavoriteRestaurant(rl2);
        user2.setBirthday(d2);

        RealmList<Restaurant> rl3 = new RealmList<>();
        rl3.add(r1);
        rl3.add(r3);

        Date d3 = new Date();
        d3.setYear(80);

        User user3 = new User();
        user3.setUserId("3");
        user3.setName("Ana");
        user3.setAge(13.5);
        user3.setFavoriteRestaurant(rl3);
        user3.setBirthday(d3);

        Repository.getInstance().createOrUpdate(realm,r1);
        Repository.getInstance().createOrUpdate(realm,r2);
        Repository.getInstance().createOrUpdate(realm,r3);
        Repository.getInstance().createOrUpdate(realm,user1);
        Repository.getInstance().createOrUpdate(realm,user2);
        Repository.getInstance().createOrUpdate(realm,user3);
    }


}
