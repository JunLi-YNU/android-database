package com.junli.android_database.java.room.domain;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Objects;


@Entity(tableName = "normal_user_java")
public class NormalUser {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_id")
    private Long userID = null;
    @ColumnInfo(name = "user_name")
    private String userName;
    @ColumnInfo(name = "nick_name")
    private String nickName;

    public NormalUser() {
    }
    @Ignore
    public NormalUser(String userName, String nickName) {
        this.userName = userName;
        this.nickName = nickName;
    }
    @Ignore
    public NormalUser(Long userID, String userName, String nickName) {
        this.userID = userID;
        this.userName = userName;
        this.nickName = nickName;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NormalUser that = (NormalUser) o;
        return Objects.equals(userID, that.userID) && Objects.equals(userName, that.userName) && Objects.equals(nickName, that.nickName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID, userName, nickName);
    }
}
