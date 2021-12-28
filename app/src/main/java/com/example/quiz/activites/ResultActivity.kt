package com.example.quiz.activites

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.quiz.R
import com.example.quiz.activites.model.Question
import com.example.quiz.activites.model.quiz
import com.google.gson.Gson

class resultActivity : AppCompatActivity() {
    lateinit var quizjosn:quiz
    lateinit var scoreTv:TextView
    lateinit var answerTextView:TextView
    lateinit var continueBtn:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        scoreTv=findViewById(R.id.score_view)
        answerTextView=findViewById(R.id.answerTxt)
        continueBtn=findViewById(R.id.homeBtn)

        setUpView()

        setAnswerView()
        continueBtn.setOnClickListener {
            val intent=Intent(this,homeScreen::class.java)
            startActivity(intent)
            onStop()
        }

    }

    private fun setAnswerView() {
        val builder=StringBuilder()
        for (entry in quizjosn.Question.entries)
        {
            val Question=entry.value
            builder.append("<font color'#18206F'><b>Question: ${Question.description}</b></font><br/><br/>")
            builder.append("<font color='#009688'>Answer: ${Question.answer}</font><br/><br/>")


        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
           answerTextView.text = Html.fromHtml(builder.toString(), Html.FROM_HTML_MODE_COMPACT);
        } else {
            answerTextView.text = Html.fromHtml(builder.toString());
        }
    }

    private fun setUpView() {
        var jsondata:String=intent.getStringExtra("jsondata").toString()
        quizjosn= Gson().fromJson(jsondata,quiz::class.java)
        Log.d("quizjson",quizjosn.toString())
        calculteScore()
    }

    private fun calculteScore() {
        var score=0

        for ( entry in quizjosn.Question.entries)
        {
            val question=entry.value
            if (question.answer==question.userAnswer)
            {
                score +=10
            }

        }
     scoreTv.append(score.toString())

    }
}