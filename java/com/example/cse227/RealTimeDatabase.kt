package com.example.cse227

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class RealTimeDatabase : AppCompatActivity() {
    lateinit var a: FirebaseAuth
    lateinit var db:DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_real_time_database)
        a = FirebaseAuth.getInstance()
        db = Firebase.database.reference
        db.child("Person").child("name").setValue("Nisha")
        db.child("Person").child("contact num").child("personal no").setValue("9876543210")
        db.child("Person").child("contact num").child("official no").setValue("1234567890")
    }
}