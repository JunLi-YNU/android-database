package com.junli.java_room.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.junli.java_room.room.api.NormalUserDao;
import com.junli.java_room.room.domain.NormalUser;
import com.junli.java_room.room.migration.DataBaseMigration;


@Database(entities = {NormalUser.class}, version = 2, exportSchema = false)
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
                            DATABASE_NAME)
                            .addMigrations(DataBaseMigration.mMigration_1_2)
                            .build();
                }
            }
        }
        return dataBaseInstance;
    }

    public abstract NormalUserDao getNormalUserDao();
}
