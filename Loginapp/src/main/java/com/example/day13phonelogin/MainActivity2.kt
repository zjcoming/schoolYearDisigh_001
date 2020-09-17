package com.example.day13phonelogin

import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main2.*


class MainActivity2 : AppCompatActivity() {
    private val verifyViews:Array<TextView> by lazy {
        arrayOf(mv1,mv2,mv3,mv4,mv5,mv6)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        intent.getStringExtra("number").also {
            mNum.text = it
        }

        mOrignal.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                for ((i,item) in s?.withIndex()!!){
                    verifyViews[i].text = item.toString()
            }
                for (i in s.length..5){
                    verifyViews[i].text = ""
                }

                if (s.length == 6){
                    BmobUtil.verifySmsCode(mNum.text.toString(),s.toString()){
                        if (it == BmobUtil.SUCCESS){
                            val intent = Intent()
                            intent.component = ComponentName(
                                "com.example.test_demo",
                                "com.example.test_demo.BilibiliActivity"
                            )
                            startActivity(intent)
                        }else{
                            Toast.makeText(this@MainActivity2,"验证失败",Toast.LENGTH_SHORT).show()
                            mOrignal.text.clear()
                        }
                    }
                }
        } })


    }

    override fun onResume() {
        super.onResume()
        BmobUtil.requestSMSCode(mNum.text.toString()){
            if (it == BmobUtil.SUCCESS){
                Toast.makeText(this,"发送验证码成功",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this,"发送验证码失败",Toast.LENGTH_SHORT).show()
            }
        }
    }
}