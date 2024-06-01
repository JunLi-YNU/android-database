package com.junli.kotlin_room.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.junli.kotlin_room.room.dao.NormalUserDao
import com.junli.kotlin_room.room.domain.NormalUser
import java.util.Objects


@Database(
    version = 2,
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
                        .allowMainThreadQueries()//允许主线程查询
                        .fallbackToDestructiveMigration()//版本更新时清空数据
                        .addMigrations(this.migration_1_2)
                        .enableMultiInstanceInvalidation().build().apply {
                            database = this
                        }
            } else {
                database!!
            }
            return database as DatabaseRoomCreator
        }

        private val migration_1_2 = object : Migration(1, 2) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("ALTER TABLE normal_user_kotlin ADD COLUMN sex INTEGER NOT NULL DEFAULT 0;")
            }
        }
    }

    abstract fun getNormalUserApi(): NormalUserDao
}