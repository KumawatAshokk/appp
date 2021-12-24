package com.example.quiz.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Adapter
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quiz.R
import com.example.quiz.activites.adapter.quizAdapter
import com.example.quiz.activites.model.quiz
import com.google.android.material.appbar.MaterialToolbar

class homeScreen : AppCompatActivity() {
    lateinit var actionBarDrawerToggle:ActionBarDrawerToggle
    lateinit var drawerLayout:DrawerLayout
    lateinit var adpter:quizAdapter
    lateinit var recylerview:RecyclerView
    private var quizList= mutableListOf<quiz>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)
        var appbar:MaterialToolbar =findViewById(R.id.AppBar)
        recylerview=findViewById(R.id.home_recylerView)
        drawerLayout =findViewById(R.id.drawer)
        setUpdrawer(appbar)
        dummyData()
        setUpRecyle()

    }

    public fun dummyData() {
        quizList.add(quiz("123","23-12-21"))
        quizList.add(quiz("123","23-12-21"))
        quizList.add(quiz("123","23-12-21"))
        quizList.add(quiz("123","23-12-21"))
        quizList.add(quiz("123","23-12-21"))
        quizList.add(quiz("123","23-12-21"))
        quizList.add(quiz("123","23-12-21"))
        quizList.add(quiz("123","23-12-21"))
        quizList.add(quiz("123","23-12-21"))
        quizList.add(quiz("123","23-12-21"))
        quizList.add(quiz("123","23-12-21"))
        quizList.add(quiz("123","23-12-21"))
        quizList.add(quiz("123","23-12-21"))
        quizList.add(quiz("123","23-12-21"))
        quizList.add(quiz("123","23-12-21"))
    }

    fun setUpRecyle()
    {
        adpter= quizAdapter(this,quizList)
        recylerview.layoutManager=GridLayoutManager(this,2)
        recylerview.adapter=adpter
    }


     fun setUpdrawer(appbar:MaterialToolbar) {
        setSupportActionBar(appbar)
         actionBarDrawerToggle=ActionBarDrawerToggle(this,drawerLayout,appbar,
             R.string.app_name,
             R.string.app_name
         )
         actionBarDrawerToggle.syncState()


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (actionBarDrawerToggle.onOptionsItemSelected(item))
        {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}