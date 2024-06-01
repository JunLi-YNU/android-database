package com.junli.java_room.room.api;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.junli.java_room.room.domain.NormalUser;

import java.util.List;


@Dao
public interface NormalUserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertNormalUser(NormalUser normalUser);

    @Delete
    int deleteNormalUser(NormalUser normalUser);

    /**
     * 排序查询
     * @return
     */
    @Query("SELECT * FROM normal_user_java ORDER BY user_id DESC")
    List<NormalUser> orderByQuery();

    @Update
    int updateNormalUser(NormalUser normalUser);

    @Query("UPDATE normal_user_java SET nick_name=:nickName WHERE user_id = :userID")
    void updateNormalUserNickNameByID(String nickName, Long userID);

    @Query("DELETE FROM normal_user_java WHERE user_id = :userID")
    int deleteNormalUserByID(Long userID);

    @Query("SELECT * FROM normal_user_java WHERE user_id= :userID")
    List<NormalUser> getNormalUserByID(Long userID);

    @Query("SELECT * FROM normal_user_java")
    List<NormalUser> getAllNormalUser();
}
