package com.example.turizmpavlodar

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    val mAuth: FirebaseAuth = FirebaseAuth.getInstance()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val email_et = findViewById<EditText>(R.id.edit_text_username)
        val password_et = findViewById<EditText>(R.id.edit_text_password)
        val signIn = findViewById<Button>(R.id.buttonLogin)
        val signUp = findViewById<Button>(R.id.buttonRegister)

        signIn.setOnClickListener {
            val email = email_et.text
            val password =  password_et.text
            if (email.isNotEmpty() && password.isNotEmpty()){
                mAuth.signInWithEmailAndPassword(email.toString(), password.toString())
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Вход выполнен успешно
                            val user = mAuth.currentUser
                            // Дополнительный код для работы с пользователем
                            val i = Intent(this, FA2Activity::class.java)
                            startActivity(i)
                        } else {
                            // Произошла ошибка
                            Toast.makeText(this, "Authentication failed.", Toast.LENGTH_SHORT).show()
                        }
                    }
            }
        }

        signUp.setOnClickListener {
            val i = Intent(this, RegisterActivity::class.java)
            startActivity(i)
        }
    }
}