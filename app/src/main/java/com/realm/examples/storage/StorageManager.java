package com.realm.examples.storage;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class StorageManager {

    private static StorageManager storageManager = new StorageManager();

    public static StorageManager getInstance() {
        return storageManager;
    }

    private RealmConfiguration realmConfig;

    private StorageManager() {
        realmConfig = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
    }

    public Realm getRealm() {
        return Realm.getInstance(realmConfig);
    }
}
