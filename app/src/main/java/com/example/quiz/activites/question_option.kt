package com.example.quiz.activites

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quiz.R
import com.example.quiz.activites.adapter.optionAdapter
import com.example.quiz.activites.model.Question
import com.example.quiz.activites.model.quiz
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_question_option.*
import java.util.function.LongFunction


class question_option : AppCompatActivity() {
    lateinit var descrption: TextView
    var quizzs:MutableList<quiz>?=null
    var Question1:MutableMap<String,Question>?=null
    lateinit var prvBtn: Button
    lateinit var nxtBtn: Button
    lateinit var submitBtn: Button
    var index=1
    lateinit var recyleviewOption:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_option)
        descrption = findViewById(R.id.description)
        recyleviewOption = findViewById(R.id.recyclerViewOption)
        prvBtn = findViewById(R.id.preBtn)
        nxtBtn = findViewById(R.id.nextbtn)
        submitBtn = findViewById(R.id.submit_btn)

        setUpfirestore()
        setupEventListner()



    }

    private fun setupEventListner() {
        prvBtn.setOnClickListener {
            index--
            bindview()
        }
        nxtBtn.setOnClickListener {
            index++
            bindview()
        }
        submitBtn.setOnClickListener {

            Log.d("submitbtn",Question1.toString())
        }

    }

    private fun setUpfirestore() {
//

        Toast.makeText(this, Question1?.size.toString(), Toast.LENGTH_SHORT).show()






        val firestore:FirebaseFirestore= FirebaseFirestore.getInstance()
        var date: String? =intent.getStringExtra("Date")
        Toast.makeText(this, date, Toast.LENGTH_SHORT).show()

        if (date!=null) {
            firestore.collection("Quiz").whereEqualTo("Title",date)
                .get().addOnSuccessListener {
                     Log.d("Dataset",it.toObjects(quiz::class.java).toString())
                    if (it!=null && !it.isEmpty)
                    {
                        quizzs=it.toObjects(quiz::class.java)
                        Question1= quizzs!![0].Question
                        bindview()
                        Log.d("setup fire",it.toObjects(quiz::class.java).toString())
                    }
                     else{
                        Toast.makeText(this, "else", Toast.LENGTH_SHORT).show()
                     }
                }
        }
    }

    private fun bindview( ) {
        prvBtn.visibility= View.GONE
        nextbtn.visibility= View.GONE
        submitBtn.visibility= View.GONE

        if (index==1) {


            nextbtn.visibility=View.VISIBLE
        }

        else if (index== Question1!!.size )
        {
            submitBtn.visibility=View.VISIBLE
            prvBtn.visibility=View.VISIBLE
            nextbtn.visibility=View.GONE

        }
        else{

            prvBtn.visibility=View.VISIBLE
            nxtBtn.visibility=View.VISIBLE
        }

        val question= Question1!!["Question$index"]

        question?.let {
        descrption.text = it.description
        val optionAdapter = optionAdapter(this,it)
        recyleviewOption.layoutManager = LinearLayoutManager(this)
        recyleviewOption.adapter = optionAdapter
        recyleviewOption.setHasFixedSize(true)

        }


    }
}