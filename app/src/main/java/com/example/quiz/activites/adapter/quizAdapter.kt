package com.example.quiz.activites.adapter

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.quiz.R
import com.example.quiz.activites.model.quiz
import com.example.quiz.activites.question_option
import com.example.quiz.activites.utils.colourPicker
import com.example.quiz.activites.utils.iconPicker
import java.security.AccessControlContext

class quizAdapter (val context: Context, val quizess:List<quiz>):
    RecyclerView.Adapter<quizAdapter.QuizViewHolder>() {
    inner class QuizViewHolder(itamView:View):RecyclerView.ViewHolder(itamView)
    {
        var textviewTitle:TextView=itemView.findViewById(R.id.textTitle)
        var imageCard:ImageView=itemView.findViewById(R.id.home_card_image)
        var CardContainer:CardView=itemView.findViewById(R.id.card_container)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuizViewHolder {
        val view:View=LayoutInflater.from(context).inflate(R.layout.list_item,parent,false)
        return QuizViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuizViewHolder, position: Int) {
        holder.textviewTitle.text=quizess[position].Title
        holder.CardContainer.setCardBackgroundColor(Color.parseColor(colourPicker.getcolor()))
        holder.imageCard.setImageResource(iconPicker.geticon())
        holder.CardContainer.setOnClickListener {
//            Toast.makeText(context, quizess[position].Title, Toast.LENGTH_SHORT).show()
            val intent=Intent(context, question_option::class.java)
            intent.putExtra("Date", quizess[position].Title)
            context.startActivity(intent)

        }



    }

    override fun getItemCount(): Int {
        return quizess.size
    }



}