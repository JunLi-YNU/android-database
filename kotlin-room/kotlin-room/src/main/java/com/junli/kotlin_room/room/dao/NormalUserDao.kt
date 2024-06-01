package com.junli.kotlin_room.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.junli.kotlin_room.room.domain.NormalUser

@Dao
interface NormalUserDao {
    @Insert
    fun insertNormalUser(normalUser: NormalUser)

    @Query("SELECT * FROM normal_user_kotlin WHERE user_id = :userID")
    fun selectNormaUserByID(userID: Long): NormalUser

    @Query("SELECT * FROM normal_user_kotlin")
    fun selectAllNormalUser(): List<NormalUser>
}