package com.junli.android_database.kotlin.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.junli.android_database.kotlin.room.dao.NormalUserDao
import com.junli.android_database.kotlin.room.domain.NormalUser


@Database(
    version = 1,
    entities = [NormalUser::class],
    exportSchema = false
)
abstract class DatabaseRoomCreator : RoomDatabase() {

    companion object {
        private var database: DatabaseRoomCreator? = null
        private const val DATABASE_NAME = "android_database_kotlin"

        fun getDataBaseInstance(context: Context): DatabaseRoomCreator {
            if (database == null) {
                database =
                    Room.databaseBuilder(context, DatabaseRoomCreator::class.java, DATABASE_NAME)
                        .enableMultiInstanceInvalidation().build().apply {
                            database = this
                        }
            } else {
                database!!
            }
            return database as DatabaseRoomCreator
        }
    }

    abstract fun getNormalUserApi(): NormalUserDao
}