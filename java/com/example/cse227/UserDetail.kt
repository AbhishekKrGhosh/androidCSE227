package com.example.cse227

import android.widget.Button
import android.widget.EditText

class UserDetail {
    lateinit var name:String

    lateinit var address: String

    lateinit var Contact: String
    @JvmName("setName1")
    fun setName(n:String){
        name=n
    }
    @JvmName("getName1")
    fun getName():String{
        return name
    }
}