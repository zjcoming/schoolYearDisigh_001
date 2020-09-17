package com.example.day13phonelogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.SpannableStringBuilder
import android.text.TextWatcher
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var shouldsplit = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextPhone.addTextChangedListener(object : textWatcher(){
            override fun afterTextChanged(s: Editable?) {
                mLogin.isEnabled = editTextPhone.text.length == 13
                if (shouldsplit) {
                    s.toString().length.also {
                        if (it == 3 || it == 8) {
                            s?.append(' ')
                        }
                    }
                }else return
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                shouldsplit = (count ==1)
            } })

        mLogin.setOnClickListener{
            Intent().apply {
                setClass(this@MainActivity,MainActivity2::class.java)
                putExtra("number",getNumber(editTextPhone.text))
                startActivity(this)
            }

        }
    }

    private fun getNumber(editable: Editable):String{
        SpannableStringBuilder(editable.toString()).also {
            it.delete(3,4)
            it.delete(7,8)
            return it.toString()
        }



    }
}

open class textWatcher:TextWatcher{
    override fun afterTextChanged(s: Editable?) {

    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

    }

}

//将带空格的号码转化为连续号码

