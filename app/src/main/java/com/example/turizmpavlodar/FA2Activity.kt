package com.example.turizmpavlodar

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.widget.Button
import android.widget.EditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.POST
import retrofit2.http.Query
import java.net.HttpURLConnection
import java.net.URL

class FA2Activity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fa2)
        val code = (1000..9999).random()
        send_code(code = code.toString())

        val code_et = findViewById<EditText>(R.id.code_edittext)
        val verify = findViewById<Button>(R.id.verify_button)

        verify.setOnClickListener {
            val code_ = code_et.text.toString()
            if(code_.isNotEmpty()){
                if(code_ == code.toString()){
                    val i = Intent(this, MainActivity::class.java)
                    startActivity(i)
                }
            }
        }
    }

    fun send_code (code:String){
        val botToken = "6206678038:AAGbvEdjE3_Hmo1fH4kRA_2iAim-cLvprUA"
        val sharedPreferences = getSharedPreferences("CHAT_ID", Context.MODE_PRIVATE)

        val chatId = sharedPreferences.getString("chat_id", "").toString()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.telegram.org/bot$botToken/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val telegramService = retrofit.create(TelegramService::class.java)
        val call = telegramService.sendMessage(chatId, code)
        call.enqueue(object : Callback<Message> {
            override fun onResponse(call: Call<Message>, response: Response<Message>) {
                if (response.isSuccessful) {
                    val message = response.body()
                    // Обработка успешного ответа
                } else {
                    // Обработка ошибки
                }
            }

            override fun onFailure(call: Call<Message>, t: Throwable) {
                // Обработка ошибки
            }
        })
    }
}

interface TelegramService {
    @POST("sendMessage")
    fun sendMessage(
        @Query("chat_id") chatId: String,
        @Query("text") text: String
    ): Call<Message>
}
