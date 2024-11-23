package com.example.listview

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val listView = findViewById<ListView>(R.id.listview)

        val taskList = arrayListOf<String>()
        taskList.add("Attend Meeting")
        taskList.add("Complete Android Development")
        taskList.add("Learn the basics of Kotlin")
        taskList.add("Learn the clean architecture of App Development")
        taskList.add("Learn MVVI architecture")

        val adapterForListView = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, taskList)
        listView.adapter = adapterForListView

        listView.setOnItemClickListener{
            parent, view, position, id ->

            val text = "Clicked on Item : " + (view as TextView).text.toString()
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()

        }

    }
}