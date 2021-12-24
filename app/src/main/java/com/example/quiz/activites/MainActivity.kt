package com.example.quiz.activites

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.quiz.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class MainActivity : AppCompatActivity() {
    lateinit var firebaseAuth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        firebaseAuth= FirebaseAuth.getInstance()
        val user: FirebaseUser? =firebaseAuth.currentUser

        if (user!=null)
        {
            val intet1= Intent(this, homeScreen::class.java)
            startActivity(intet1)

        }

        var start=findViewById<Button>(R.id.button)
            val intet= Intent(this, login::class.java)

        start.setOnClickListener {
            startActivity(intet)
        }
    }
}