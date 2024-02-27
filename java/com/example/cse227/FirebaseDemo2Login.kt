package com.example.cse227

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class FirebaseDemo2Login : AppCompatActivity() {
    lateinit var a: FirebaseAuth
    lateinit var email: EditText
    lateinit var pass: EditText
    lateinit var login: Button
    lateinit var link: TextView
    lateinit var e: String
    lateinit var p: String
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_firebase_demo2_login)
        a = FirebaseAuth.getInstance()
        email = findViewById(R.id.email2)
        pass = findViewById(R.id.pass2)
        login = findViewById(R.id.SignUp2)
        link= findViewById(R.id.link2)
        login.setOnClickListener {
            e = email.text.toString()
            p = pass.text.toString()
            a.signInWithEmailAndPassword(e, p)
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        Toast.makeText(this, "Login done " + it.exception, Toast.LENGTH_LONG)
                            .show()
                    } else {
                        Toast.makeText(this, "Login not done " + it.exception, Toast.LENGTH_LONG)
                            .show()

                    }
                }
        }
    }
}