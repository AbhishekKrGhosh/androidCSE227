package com.example.cse227

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider

class FirebaseActivity2 : AppCompatActivity() {
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_firebase2)
        auth=FirebaseAuth.getInstance()
// get storedVerificationId from the intent
        val storedVerificationId= intent.getStringExtra("storedVerificationId")
// fill otp and call the on click on button
        findViewById<Button>(R.id.verify).setOnClickListener {
            val otp = findViewById<EditText>(R.id.otp).text.trim().toString()
            if(otp.isNotEmpty()){
                val credential : PhoneAuthCredential = PhoneAuthProvider.getCredential(
                    storedVerificationId.toString(), otp)
                signInWithPhoneAuthCredential(credential)
            }else{
                Toast.makeText(this,"Enter OTP", Toast.LENGTH_SHORT).show()
            }
        } }
    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val intent = Intent(this ,MainActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
// Sign in failed, display a message and update the UI
                    if (task.exception is FirebaseAuthInvalidCredentialsException) {
// The verification code entered was invalid
                        Toast.makeText(this,"Invalid OTP", Toast.LENGTH_SHORT).show()
                    }
                }
            }
    }
}