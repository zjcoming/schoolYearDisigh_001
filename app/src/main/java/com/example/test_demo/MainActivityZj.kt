package com.example.test_demo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.AnimationUtils.loadAnimation
import com.example.day13phonelogin.MainActivity
import kotlinx.android.synthetic.main.activity_main_zj.*

class MainActivityZj : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_zj)
        loadAnimation(this,R.anim.activity_set_anim).apply {
            imageView6.startAnimation(this)
        }
        button2.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }
    }

}
