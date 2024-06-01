package com.junli.java_room.room.api;

import androidx.room.Dao;
import androidx.room.Query;

@Dao
public interface DatabaseOptionalApi {

    @Query("")
    String getDatabaseName();
}
