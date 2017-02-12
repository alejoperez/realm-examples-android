package com.realm.examples.repositories;

import android.util.Log;

import com.realm.examples.storage.StorageManager;

import io.realm.Realm;
import io.realm.RealmObject;

public class Repository {
    private static Repository repository = new Repository();

    public static Repository getInstance() {
        return repository;
    }

    private Repository() {
    }

    public void createOrUpdate(final RealmObject object) {
        StorageManager.getInstance().getRealm().executeTransactionAsync(
                new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        realm.insertOrUpdate(object);
                    }
                },
                new Realm.Transaction.OnSuccess() {
                    @Override
                    public void onSuccess() {
                        Log.d("Repository","onSuccess()");
                    }
                },
                new Realm.Transaction.OnError() {
                    @Override
                    public void onError(Throwable error) {
                        Log.e("Repository","onError() = "+error.toString());
                    }
                }
        );
    }

}
