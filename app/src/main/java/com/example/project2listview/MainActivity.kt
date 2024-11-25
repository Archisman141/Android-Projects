package com.example.project2listview

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var userArrayList: ArrayList<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val name = arrayOf("Archisman","Jain","Sohan","Soumya","Arnab")
        val lastMsg = arrayOf("Hey awesome","I'm fine","Good","Awesome","Cool")

        val lastMsgTime = arrayOf("8:00 AM","9:00 AM","10:00 AM","11:00 AM","12:00 PM")

        val phoneNumber = arrayOf("+91 9876543210","+91 9776543210","+91 9676543210","+91 9576543210","+91 9476543210")

        val imgId = intArrayOf(R.drawable.my_picture,R.drawable.jain,R.drawable.sohan,R.drawable.soumyo,R.drawable.arnab)

        userArrayList = ArrayList() //Initialization
        for (eachIndex in name.indices){
            val user = User(name[eachIndex],lastMsg[eachIndex],lastMsgTime[eachIndex],phoneNumber[eachIndex],imgId[eachIndex])
            userArrayList.add(user)
        }
        //Making Adapter
        val lstView = findViewById<ListView>(R.id.listView)
        lstView.isClickable = true
        lstView.adapter = MyAdapter(this,userArrayList) //Creating Adapter by MyAdapter

        lstView.setOnItemClickListener { parent, view, position, id ->
            //open a new activity
            val userName = name[position]
            val userPhone = phoneNumber[position]
            val imageId = imgId[position]

            val intent = Intent(this,UserActivity::class.java)

            intent.putExtra("name",userName)
            intent.putExtra("phoneNumber",userPhone)
            intent.putExtra("imgId",imageId)

            startActivity(intent)
        }
    }
}