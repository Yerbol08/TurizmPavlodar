package com.example.turizmpavlodar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        auth = FirebaseAuth.getInstance()

        val username_et = findViewById<EditText>(R.id.editTextUsername)
        val pass_et = findViewById<EditText>(R.id.editTextPassword)
        val signUp = findViewById<Button>(R.id.buttonRegister)
        val signIn = findViewById<Button>(R.id.buttonLogin)

        signUp.setOnClickListener {
            val username = username_et.text.toString()
            val password = pass_et.text.toString()
            if (username.isNotEmpty() && password.isNotEmpty()){
                auth.createUserWithEmailAndPassword(username, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Регистрация прошла успешно, пользователь создан
                            val user = auth.currentUser
                            val i = Intent(this,    GetChatIDActivity::class.java)
                            startActivity(i)

                        } else {
                            // Возникла ошибка при регистрации пользователя
                            Toast.makeText(baseContext, "Регистрация не удалась: " + task.exception?.message, Toast.LENGTH_SHORT).show()
                        }
                    }
            }

        }

    }
}