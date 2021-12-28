package com.example.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.quiz.activites.login
import com.google.firebase.auth.FirebaseAuth

class profile : AppCompatActivity() {
    lateinit var firebaseAuth:FirebaseAuth
    lateinit var Logout:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        firebaseAuth= FirebaseAuth.getInstance()
        Logout=findViewById(R.id.logoutBt)

        Logout.setOnClickListener {
        firebaseAuth.signOut()
        val intent=Intent(this,login::class.java)
            startActivity(intent)
        }
    }
}