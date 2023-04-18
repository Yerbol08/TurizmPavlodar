package com.example.turizmpavlodar

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class GetChatIDActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_chat_idactivity)
        val click_tg = findViewById<TextView>(R.id.title_text2)
        val save_btn = findViewById<Button>(R.id.save_btn)
        val chat_id_et = findViewById<EditText>(R.id.chat_edittext)
        click_tg.setOnClickListener {
            val telegramIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/diploma777Bot"))
            startActivity(telegramIntent)
        }
        save_btn.setOnClickListener {
            val chat_id = chat_id_et.text.toString()
            if (chat_id.isNotEmpty()){
                val sharedPreference =  getSharedPreferences("CHAT_ID", Context.MODE_PRIVATE)
                val editor = sharedPreference.edit()
                editor.putString("chat_id",chat_id)
                editor.apply()

                val i = Intent(this, LoginActivity::class.java)
                startActivity(i)
            }
        }
    }
}