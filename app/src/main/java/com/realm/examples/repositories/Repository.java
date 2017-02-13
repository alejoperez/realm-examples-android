package com.realm.examples.repositories;

import android.util.Log;

import com.realm.examples.models.Restaurant;
import com.realm.examples.models.User;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;

public class Repository {
    private static Repository repository = new Repository();

    public static Repository getInstance() {
        return repository;
    }

    private Repository() {
    }

    public void createOrUpdate(Realm realm,final RealmObject object) {


        realm.executeTransactionAsync(
                new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        realm.insertOrUpdate(object);
                    }
                },
                new Realm.Transaction.OnSuccess() {
                    @Override
                    public void onSuccess() {
                        Log.d("createOrUpdate","onSuccess()");
                    }
                },
                new Realm.Transaction.OnError() {
                    @Override
                    public void onError(Throwable error) {
                        Log.e("createOrUpdate","onError() = "+error.toString());
                    }
                }
        );
    }

}
