package com.realm.examples.models;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class User extends RealmObject {

    @PrimaryKey
    private String userId;
    @Ignore
    private String sessionId;
    @Required
    private String name;
    private int age;
    private Date birthday;
    private Restaurant favoriteRestaurant;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Restaurant getFavoriteRestaurant() {
        return favoriteRestaurant;
    }

    public void setFavoriteRestaurant(Restaurant favoriteRestaurant) {
        this.favoriteRestaurant = favoriteRestaurant;
    }

    public boolean isAdult() {
        return age >= 18;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
