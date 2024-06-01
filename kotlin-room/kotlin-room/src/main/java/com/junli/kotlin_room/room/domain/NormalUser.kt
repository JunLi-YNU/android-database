package com.junli.kotlin_room.room.domain

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "normal_user_kotlin")
data class NormalUser(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_id")
    var userID:Long? = null,
    @ColumnInfo(name = "user_name")
    var userName:String,
    @ColumnInfo(name = "nick_name")
    var nickName:String,
    @ColumnInfo(name = "sex")
    var sex:Int? = 0
)
