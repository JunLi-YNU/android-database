package com.junli.java_room.room.migration;

import androidx.annotation.NonNull;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

public class DataBaseMigration {

    public static Migration mMigration_1_2 = new Migration(1,2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("ALTER TABLE normal_user_java ADD COLUMN sex INTEGER NOT NULL DEFAULT 0");
        }
    };
}
