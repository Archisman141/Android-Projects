package com.example.project2listview

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.project2listview.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity() {
    lateinit var bindng: ActivityUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        bindng = ActivityUserBinding.inflate(layoutInflater)
        setContentView(bindng.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val name = intent.getStringExtra("name")
        val phoneNumber = intent.getStringExtra("phoneNumber")
        val imageId = intent.getIntExtra("imgId",R.drawable.my_picture)

        bindng.profileImage.setImageResource(imageId)
        bindng.tVname.text = name
        bindng.tVPhone.text = phoneNumber
    }
}