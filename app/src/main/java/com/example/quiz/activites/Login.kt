package com.example.quiz.activites

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.quiz.R
import com.google.firebase.auth.FirebaseAuth

class login : AppCompatActivity() {
    lateinit var firebaseAuth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val  loginBtn: Button =findViewById(R.id.button)
        val  signUpbtn: Button =findViewById(R.id.button2)
        val  emailEdt:EditText=findViewById(R.id.emailEdt)
        val  pwdEdt:EditText=findViewById(R.id.editTextTextPassword)
        firebaseAuth= FirebaseAuth.getInstance()


        var intet1= Intent(this, question_option::class.java)
        signUpbtn.setOnClickListener {
            startActivity(intet1)
        }
        loginBtn.setOnClickListener {
            LoginUser(emailEdt,pwdEdt)
        }



    }
    fun LoginUser(EmailEdt:EditText, passordEdt:EditText){
        var emailStr:String=EmailEdt.text.toString()
        var passwordStr:String=passordEdt.text.toString()
        if (emailStr.isBlank()||passwordStr.isBlank())
        {
            Toast.makeText(this,"Please fill field ",Toast.LENGTH_SHORT).show()

            return
        }

        firebaseAuth.signInWithEmailAndPassword(emailStr,passwordStr).addOnCompleteListener {
            if (it.isSuccessful)
            {
                Toast.makeText(this,"succesful login ", Toast.LENGTH_SHORT).show()
                var intent:Intent= Intent(this, homeScreen::class.java)

                val sharedPreferences:SharedPreferences=this.getSharedPreferences("loginKey",
                    MODE_PRIVATE)
                val editor:SharedPreferences.Editor=sharedPreferences.edit()
                editor.putInt("key",1)
                editor.apply()
                editor.commit()

                startActivity(intent)
            }
            else
            {
                Toast.makeText(this,"failed login ",Toast.LENGTH_SHORT).show()
            }
        }
    }
}