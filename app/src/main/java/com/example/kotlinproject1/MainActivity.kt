package com.example.kotlinproject1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var button:Button
    private lateinit var userName:EditText
    private lateinit var password:EditText
    private var LOG:String = "MAINACTIVITY"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        userName = username
//        userName = findViewById(R.id.username) as EditText
        password = findViewById(R.id.password) as EditText
        button = findViewById(R.id.enter_button) as Button
        button.setOnClickListener(View.OnClickListener {
            Log.i(LOG, "button pressed")
            if(userName.text.isEmpty() && password.text.isEmpty()){
                Log.i(LOG,"not empty")
                Toast.makeText(this, "Empty", Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this, EventList::class.java)
                startActivity(intent)
//                Toast.makeText(this, "Empty", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
