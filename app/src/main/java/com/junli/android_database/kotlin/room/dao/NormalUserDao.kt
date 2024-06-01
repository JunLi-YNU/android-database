package com.junli.android_database.kotlin.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.junli.android_database.kotlin.room.domain.NormalUser

@Dao
interface NormalUserDao {
    @Insert
    fun insertNormalUser(normalUser: NormalUser)

    @Query("SELECT * FROM normal_user WHERE user_id = :userID")
    fun selectNormaUserByID(userID: Long): NormalUser

    @Query("SELECT * FROM normal_user")
    fun selectAllNormalUser(): List<NormalUser>
}