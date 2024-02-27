package com.example.cse227

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class UpdateActivity : AppCompatActivity() {
    lateinit var empIdUpdate : EditText
    lateinit var empNameUpdate: EditText
    lateinit var empAgeUpdate: EditText
    lateinit var empSalaryUpdate: EditText
    lateinit var btnSaveUpdate : Button
    private lateinit var dbRef: DatabaseReference

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)
        empIdUpdate = findViewById(R.id.tvEmpIdUpdate)
        empNameUpdate = findViewById(R.id.tvEmpNameUpdate)
        empAgeUpdate = findViewById(R.id.tvEmpAgeUpdate)
        empSalaryUpdate = findViewById(R.id.tvEmpSalaryUpdate)
        btnSaveUpdate = findViewById(R.id.btnSaveUpdate)
        lateinit var name: String
        lateinit var age: String
        lateinit var salary: String
        getValuesToViews()
        btnSaveUpdate.setOnClickListener {
            name = empNameUpdate.text.toString()
            age = empAgeUpdate.text.toString()
            salary = empSalaryUpdate.text.toString()
            Toast.makeText(this, "hello "+empIdUpdate.text.toString(), Toast.LENGTH_LONG).show()
            updateEmpData(empIdUpdate.text.toString(), name, age, salary)
        }

    }

    private fun updateEmpData(tvEmpId: String, name: String, age: String, salary: String){
        dbRef = FirebaseDatabase.getInstance().getReference("Employees")
        var empInfo = EmployeeModel(tvEmpId, name, age, salary)
        dbRef.child(tvEmpId).setValue(empInfo)
            .addOnCompleteListener {
                Toast.makeText(this, "Data updated successfully", Toast.LENGTH_LONG).show()
                val intent = Intent(this@UpdateActivity, LoginBasic::class.java)
                startActivity(intent)
            }.addOnFailureListener { err ->
                Toast.makeText(this, "Error ${err.message}", Toast.LENGTH_LONG).show()
            }
    }
    private fun getValuesToViews(){
        empIdUpdate.setText(intent.getStringExtra("empId"))
        empNameUpdate.setText(intent.getStringExtra("empName"))
        empAgeUpdate.setText (intent.getStringExtra("empAge"))
        empSalaryUpdate.setText(intent.getStringExtra("empSalary"))
    }

}