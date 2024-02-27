package com.example.cse227

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ShowDetail : AppCompatActivity() {
    lateinit var a: FirebaseAuth
    lateinit var db: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_detail)
        a = FirebaseAuth.getInstance()
        db = Firebase.database.reference
        var add = findViewById<TextView>(R.id.empAdd)
        var name = findViewById<TextView>(R.id.empName)
        var phn = findViewById<TextView>(R.id.empPhn)
        db.child("EmployeeInfo").child("employeeAddress").get().addOnSuccessListener {
            add.text = "address: ${it.value}"
        }
        db.child("EmployeeInfo").child("employeeContactNumber").get().addOnSuccessListener {
            add.text = "phone: ${it.value}"
        }
        db.child("EmployeeInfo").child("employeeName").get().addOnSuccessListener {
            add.text = "name: ${it.value}"
        }
    }
}