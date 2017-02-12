package com.realm.examples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.realm.examples.models.Restaurant;
import com.realm.examples.models.User;
import com.realm.examples.repositories.Repository;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        User user1 = new User();
        user1.setUserId("1");
        user1.setName("John");
        user1.setAge(37);
        user1.setBirthday(new Date());
        user1.setSessionId("sessionId");
        user1.setFavoriteRestaurant(r2);

        User user2 = new User();
        user2.setUserId("2");
        user2.setName("Bob");
        user2.setAge(32);
        user2.setBirthday(new Date());
        user2.setSessionId("sessionId");
        user2.setFavoriteRestaurant(r2);

        User user3 = new User();
        user3.setUserId("3");
        user3.setName("Ana");
        user3.setAge(27);
        user3.setBirthday(new Date());
        user3.setSessionId("sessionId");
        user3.setFavoriteRestaurant(r1);


        Repository.getInstance().createOrUpdate(r1);
        Repository.getInstance().createOrUpdate(r2);
        Repository.getInstance().createOrUpdate(user1);
        Repository.getInstance().createOrUpdate(user2);
        Repository.getInstance().createOrUpdate(user3);

    }
}
