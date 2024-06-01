package com.junli.android_database;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.junli.android_database.java.room.DatabaseRoomAssistant;
import com.junli.android_database.java.room.domain.NormalUser;
import com.junli.android_database.kotlin.room.DatabaseRoomCreator;

public class MainActivity extends AppCompatActivity {
    @Override
    public boolean navigateUpTo(Intent upIntent) {
        return super.navigateUpTo(upIntent);
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button createKotlinDBBtn = findViewById(R.id.create_kotlin_database_btn);

        createKotlinDBBtn.setOnClickListener(v -> {
            new Thread(() -> {
                DatabaseRoomCreator databaseRoomCreator = DatabaseRoomCreator.Companion.getDataBaseInstance(getApplicationContext());
                databaseRoomCreator.getNormalUserApi().insertNormalUser(
                        new com.junli.android_database.kotlin.room.domain.NormalUser(null, "LiJun", "JunLi")
                );
            }).start();
            new Thread(() -> {
                DatabaseRoomAssistant databaseRoomAssistant = DatabaseRoomAssistant.getDataBaseInstance(getApplicationContext());
                databaseRoomAssistant.getNormalUserDao().insertNormalUser(new NormalUser("LiJun2", "JunLi2"));
            }).start();
        });
    }
}