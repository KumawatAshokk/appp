package com.example.quiz.activites

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.quiz.R
import com.google.firebase.auth.FirebaseAuth

class signup : AppCompatActivity() {
    private lateinit var firebaseAuth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val email:EditText=findViewById(R.id.EdtxtEmail)
        val password:EditText=findViewById(R.id.editTextPassword2)
        val confirmPassword:EditText=findViewById(R.id.editTextPasswordConfirm)
        val SignUpBtn: Button =findViewById(R.id.SignUpBtn)

        firebaseAuth= FirebaseAuth.getInstance()

        SignUpBtn.setOnClickListener {

            signUpuser(email,password,confirmPassword)


        }



    }

    fun signUpuser(email:EditText, password:EditText, confirmPassword:EditText)
    {
        var emailStr:String=email.text.toString()
        var passwordStr:String = password.text.toString()
        var confirmpasswordStr:String=confirmPassword.text.toString()

        if (emailStr.isBlank()||passwordStr.isBlank()|| confirmpasswordStr.isBlank())
        {
            Toast.makeText(this,"Please fill field ",Toast.LENGTH_SHORT).show()

            return
        }
        if (passwordStr!=confirmpasswordStr)
        {
            Toast.makeText(this,"password and confirm password do not match ",Toast.LENGTH_SHORT).show()
            return
        }


        firebaseAuth.createUserWithEmailAndPassword(emailStr, passwordStr)
            .addOnCompleteListener(this){
                if (it.isSuccessful)
                {
                    Toast.makeText(this,"succesful signUp ",Toast.LENGTH_SHORT).show()
                    var intetn:Intent= Intent(this, homeScreen::class.java)
                    startActivity(intetn)

                }
                else

                {
                    Toast.makeText(this,"signup failed ",Toast.LENGTH_SHORT).show()
                }
            }





    }
}