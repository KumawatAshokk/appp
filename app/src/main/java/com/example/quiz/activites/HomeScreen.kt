package com.example.quiz.activites

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Adapter
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quiz.R
import com.example.quiz.activites.adapter.quizAdapter
import com.example.quiz.activites.model.quiz
import com.example.quiz.profile
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import java.lang.StringBuilder


class homeScreen : AppCompatActivity() {
    lateinit var actionBarDrawerToggle:ActionBarDrawerToggle
    lateinit var drawerLayout:DrawerLayout
    lateinit var adpter:quizAdapter
    lateinit var recylerview:RecyclerView
    lateinit var navigationView: NavigationView
    private var quizList= mutableListOf<quiz>()
    lateinit var  firestore: FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)
        var appbar:MaterialToolbar =findViewById(R.id.AppBar)
        recylerview=findViewById(R.id.home_recylerView)
        drawerLayout =findViewById(R.id.drawer)
        navigationView=findViewById(R.id.navbarview)

        setUpdrawer(appbar)

        setUpRecyle()
        setUpFireStore()

    }

    private fun setUpFireStore() {

        firestore= FirebaseFirestore.getInstance()
        val collection:CollectionReference=firestore.collection("Quiz")
        collection.addSnapshotListener { value, error ->
            if (value==null || error !=null){
                Toast.makeText(this,"Failed to data fatch",Toast.LENGTH_SHORT).show()
                return@addSnapshotListener
            }

            quizList.clear()
            quizList.addAll(value.toObjects(quiz::class.java))
            adpter.notifyDataSetChanged()
            Log.d("homescreendata",value.toObjects(quiz::class.java).toString())

        }
    }


    fun setUpRecyle()
    {
        adpter= quizAdapter(this,quizList)
        recylerview.layoutManager=GridLayoutManager(this,2)
        recylerview.adapter=adpter
    }


     fun setUpdrawer(appbar:MaterialToolbar) {
         var user = FirebaseAuth.getInstance().currentUser

        var email: String? = user?.email

        setSupportActionBar(appbar)
         actionBarDrawerToggle=ActionBarDrawerToggle(this,drawerLayout,appbar,
             R.string.app_name,
             R.string.app_name
         )
         actionBarDrawerToggle.syncState()
         navigationView.setNavigationItemSelectedListener {
             val intent=Intent(this,profile::class.java)
             startActivity(intent)
             drawerLayout.closeDrawers()
             true
         }


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (actionBarDrawerToggle.onOptionsItemSelected(item))
        {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}