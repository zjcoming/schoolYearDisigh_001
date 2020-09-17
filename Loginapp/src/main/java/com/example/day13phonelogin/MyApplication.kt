package com.example.day13phonelogin

import android.app.Application
import cn.bmob.v3.Bmob

/**
 *Description
 *by cu
 */
class MyApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        Bmob.initialize(this, "2e937cb19b6877d761bc9c1e95cb593e");
    }
}