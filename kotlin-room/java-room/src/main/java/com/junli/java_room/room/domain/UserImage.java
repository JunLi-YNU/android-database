package com.junli.java_room.room.domain;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user_image")
public class UserImage {
    @PrimaryKey
    @ColumnInfo(name = "user_id")
    private Long userID;
    @ColumnInfo(name = "image_name")
    private String imageName;
    @ColumnInfo(name = "local_url")
    private String localUrl;
    @ColumnInfo(name = "remote_url")
    private String remoteUrl;

    public UserImage(Long userID, String imageName, String localUrl, String remoteUrl) {
        this.userID = userID;
        this.imageName = imageName;
        this.localUrl = localUrl;
        this.remoteUrl = remoteUrl;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getLocalUrl() {
        return localUrl;
    }

    public void setLocalUrl(String localUrl) {
        this.localUrl = localUrl;
    }

    public String getRemoteUrl() {
        return remoteUrl;
    }

    public void setRemoteUrl(String remoteUrl) {
        this.remoteUrl = remoteUrl;
    }
}
