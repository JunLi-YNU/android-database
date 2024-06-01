package com.junli.java_room.room.domain;

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
    @ColumnInfo(name = "sex")
    private int sex = 0;

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

    public NormalUser(Long userID, String userName, String nickName, int sex) {
        this.userID = userID;
        this.userName = userName;
        this.nickName = nickName;
        this.sex = sex;
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

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NormalUser that = (NormalUser) o;
        return sex == that.sex && Objects.equals(userID, that.userID) && Objects.equals(userName, that.userName) && Objects.equals(nickName, that.nickName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID, userName, nickName, sex);
    }
}
