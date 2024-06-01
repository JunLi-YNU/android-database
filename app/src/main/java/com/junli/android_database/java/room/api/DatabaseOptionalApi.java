package com.junli.android_database.java.room.api;

import androidx.room.Dao;
import androidx.room.Query;

@Dao
public interface DatabaseOptionalApi {

    @Query("")
    String getDatabaseName();
}
