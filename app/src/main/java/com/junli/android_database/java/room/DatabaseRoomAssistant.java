package com.junli.android_database.java.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.junli.android_database.java.room.api.NormalUserDao;
import com.junli.android_database.java.room.domain.NormalUser;

@Database(entities = {NormalUser.class}, version = 1, exportSchema = false)
public abstract class DatabaseRoomAssistant extends RoomDatabase {
    private static volatile DatabaseRoomAssistant dataBaseInstance;
    private final static String DATABASE_NAME = "android_database_java";

    DatabaseRoomAssistant() {
        if (dataBaseInstance != null) {
            throw new RuntimeException("数据库已经存在的单例对象");
        }
    }

    public static DatabaseRoomAssistant getDataBaseInstance(Context context) {
        if (dataBaseInstance == null) {
            synchronized (DatabaseRoomAssistant.class) {
                if (dataBaseInstance == null) {
                    dataBaseInstance = Room.databaseBuilder(context.getApplicationContext(), DatabaseRoomAssistant.class,
                            DATABASE_NAME).build();
                }
            }
        }
        return dataBaseInstance;
    }

    public abstract NormalUserDao getNormalUserDao();
}
