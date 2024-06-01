package com.junli.android_database.java.room.api;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.junli.android_database.java.room.domain.NormalUser;

import java.util.List;

@Dao
public interface NormalUserDao {
    @Insert
    void insertNormalUser(NormalUser normalUser);

    @Delete
    int deleteNormalUser(NormalUser normalUser);

    @Update
    int updateNormalUser(NormalUser normalUser);

    @Query("Update normal_user_java set nick_name=:nickName where user_id = :userID")
    void updateNormalUserNickNameByID(String nickName, Long userID);

    @Query("delete from normal_user_java where user_id = :userID")
    int deleteNormalUserByID(Long userID);

    @Query("SELECT * FROM normal_user_java where user_id= :userID")
    List<NormalUser> getNormalUserByID(Long userID);

    @Query("SELECT * FROM normal_user_java")
    List<NormalUser> getAllNormalUser();
}
