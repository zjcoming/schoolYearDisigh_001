package com.example.test_demo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_bilibili.*

class BilibiliActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bilibili)
        imageView5.setOnClickListener {
            Intent().apply {
                action = Intent.ACTION_VIEW
                data = Uri.parse("https://www.bilibili.com/video/BV1AV411S7yc?from=search&seid=6525162438161297195")
            }.also {
                startActivity(it)
            }
        }
        imageView7.setOnClickListener {
            Intent().apply {
                action = Intent.ACTION_VIEW
                data = Uri.parse("https://www.bilibili.com/bangumi/play/ep337607")
            }.also {
                startActivity(it)
            }
        }
        imageView8.setOnClickListener {
            Intent().apply {
                action = Intent.ACTION_VIEW
                data = Uri.parse("https://www.bilibili.com/video/BV1Cp4y1v7f8?from=search&seid=16776536508352214666")
            }.also {
                startActivity(it)
            }
        }
        imageView9.setOnClickListener {
            Intent().apply {
                action = Intent.ACTION_VIEW
                data = Uri.parse("https://www.bilibili.com/video/BV11f4y197Db?from=search&seid=776373473116380992")
            }.also {
                startActivity(it)
            }
        }
        imageView10.setOnClickListener {
            Intent().apply {
                action = Intent.ACTION_VIEW
                data = Uri.parse("https://www.bilibili.com/video/BV1a54y127Xp?from=search&seid=14729994124507993206")
            }.also {
                startActivity(it)
            }
        }
        imageView11.setOnClickListener {
            Intent().apply {
                action = Intent.ACTION_VIEW
                data = Uri.parse("https://www.bilibili.com/video/BV1FK411K7Vy?from=search&seid=6972504670150480778")
            }.also {
                startActivity(it)
            }
        }
        searchBtn.setOnClickListener{
            var searchContent = searchContentText.text.toString()
            Intent().apply {
                action = Intent.ACTION_VIEW
                data = Uri.parse("https://m.bilibili.com/search?keyword=${searchContent}")
            }.also {
                startActivity(it)
            }
        }

    }
}