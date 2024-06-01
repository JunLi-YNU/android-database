package com.junli.kotlin_room

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.junli.kotlin_room.room.DatabaseRoomCreator
import com.junli.kotlin_room.room.domain.NormalUser

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.button)
        val tv = findViewById<TextView>(R.id.tv_sqlite_return)
        val databaseRoomCreator = DatabaseRoomCreator.getDataBaseInstance(applicationContext)
        val normalUserDao = databaseRoomCreator.getNormalUserApi()

        btn.setOnClickListener {
            Thread {
                var i = 0
                repeat(5) {
                    normalUserDao.insertNormalUser(
                        NormalUser(
                            null,
                            "LiJun Kotlin $i",
                            "JunLi Kotlin ${i++}"
                        )
                    )
                }
            }.start()
        }
        tv.setOnClickListener {
            Log.d(TAG, "点击了")
            Thread {
                val normalUserList = normalUserDao.selectAllNormalUser()
                val stringBuilder: StringBuilder = StringBuilder()
                normalUserList.forEach {
                    stringBuilder.append("UserID:${it.userID} UserName:${it.userName} NickName:${it.nickName}")
                        .append("\n")
                }
                runOnUiThread {
                    tv.text = stringBuilder
                }
            }.start()
        }

    }
}