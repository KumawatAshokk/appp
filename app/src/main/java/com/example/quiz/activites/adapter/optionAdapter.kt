package com.example.quiz.activites.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.quiz.R
import com.example.quiz.activites.model.Question

class optionAdapter(val context:Context, val question: Question):
    RecyclerView.Adapter<optionAdapter.optionViewholder>() {
    var options: List<String> = listOf(question.option1,question.option2,question.option3,question.option4)
    //    private var options= listOf(question.option1,question.option2,question.option3,question.option4)
    inner  class optionViewholder(itemView:View):RecyclerView.ViewHolder(itemView)
    {
        var optionTextView:TextView=itemView.findViewById(R.id.optionTextview)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): optionViewholder {
        val view:View=LayoutInflater.from(context).inflate(R.layout.option_item,parent,false)
        return optionViewholder(view)

    }

    override fun onBindViewHolder(holder: optionViewholder, position: Int) {
        holder.optionTextView.text=options[position]
        holder.itemView.setOnClickListener {
//            Toast.makeText(holder.optionTextView.context,options[position],Toast.LENGTH_SHORT).show()
            question.userAnswer=options[position]
            notifyDataSetChanged()
        }
        if(question.userAnswer==options[position]){

            holder.itemView.setBackgroundResource(R.drawable.option_select_border)


        }
        else{

            holder.itemView.setBackgroundResource(R.drawable.option_bg_boder)
        }

    }

    override fun getItemCount(): Int {
        return options.size
    }


}