package com.junli.java_room

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.junli.java_room.room.DatabaseRoomAssistant
import com.junli.java_room.room.api.NormalUserDao
import com.junli.java_room.room.domain.NormalUser


class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn = findViewById<Button>(R.id.button)
        val roomAssistant: DatabaseRoomAssistant =
            DatabaseRoomAssistant.getDataBaseInstance(applicationContext)
        val normalUserDao: NormalUserDao = roomAssistant.normalUserDao
        btn.setOnClickListener {
            Thread {
                var i = 0
                repeat(10) {
                    normalUserDao.insertNormalUser(NormalUser("LiJun $i,", "JunLi ${i++}"))
                }
            }.start()
        }
        val tv = findViewById<TextView>(R.id.tv_sqlite_return)
        tv.setOnClickListener {
            Thread {
                val normalUserList: List<NormalUser> = normalUserDao.allNormalUser
                val stringBuilder: StringBuilder = StringBuilder()
                for (normalUser: NormalUser in normalUserList) {
                    stringBuilder.append(normalUser.toString())
                }
                runOnUiThread {
                    tv.text = stringBuilder
                }
            }.start()
        }
    }
}