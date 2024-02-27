package com.example.cse227

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class FirebaseDemo1 : AppCompatActivity() {
    lateinit var a: FirebaseAuth
    lateinit var db: DatabaseReference
    lateinit var name: EditText
    lateinit var contact: EditText
    lateinit var address: EditText
    lateinit var email: EditText
    lateinit var pass: EditText
    lateinit var conPass: EditText
    lateinit var signup: Button
    lateinit var link: TextView
    lateinit var n: String
    lateinit var c: String
    lateinit var ad: String
    lateinit var e: String
    lateinit var p: String
    lateinit var cp: String
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_firebase_demo1)
        a = FirebaseAuth.getInstance()
        db = Firebase.database.reference
        name = findViewById(R.id.name)
        contact = findViewById(R.id.contact)
        address = findViewById(R.id.address)
        email = findViewById(R.id.email)
        pass = findViewById(R.id.pass)
        conPass = findViewById(R.id.conPass)
        signup = findViewById(R.id.SignUp)
        link= findViewById(R.id.link)

        signup.setOnClickListener {
            n = name.text.toString()
            c = contact.text.toString()
            ad = address.text.toString()
            e = email.text.toString()
            p = pass.text.toString()
            cp = conPass.text.toString()

            db.child("User").child(n).child("contact no").setValue(c)
            db.child("User").child(n).child("address").setValue(ad)
            db.child("User").child(n).child("email").setValue(e)


            if (p != cp) {
                Toast.makeText(this, "password does not match", Toast.LENGTH_LONG)
                    .show()
            } else {
                a.createUserWithEmailAndPassword(e,p)
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            Toast.makeText(this, "SignUp done " + it.exception, Toast.LENGTH_LONG).show()
                        } else {
                            Toast.makeText(this, "SignUp not done " + it.exception, Toast.LENGTH_LONG)
                                .show()

                        }
                    }
            }
        }
        /*a.createUserWithEmailAndPassword()
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    Toast.makeText(this, "SignUp done " + it.exception, Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, "SignUp not done " + it.exception, Toast.LENGTH_LONG)
                        .show()

                }
            }*/
    }

    /*fun login(v: View) {
        run {
            a.signInWithEmailAndPassword("abc@gmail.com", "12345678")
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        Toast.makeText(this, "SignUp done " + it.exception, Toast.LENGTH_LONG)
                            .show()
                    } else {
                        Toast.makeText(this, "SignUp not done " + it.exception, Toast.LENGTH_LONG)
                            .show()

                    }
                }
        }
    }*/

}