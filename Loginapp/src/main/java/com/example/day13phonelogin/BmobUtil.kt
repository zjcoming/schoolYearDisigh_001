package com.example.day13phonelogin

import cn.bmob.v3.Bmob
import cn.bmob.v3.BmobSMS
import cn.bmob.v3.exception.BmobException
import cn.bmob.v3.listener.QueryListListener
import cn.bmob.v3.listener.QueryListener
import cn.bmob.v3.listener.UpdateListener

/**0
 *Description
 *by cu
 */
object BmobUtil {
    const val SUCCESS = 0
    const val FAILURE = 1

    fun requestSMSCode(phone:String,callBack:(Int)->Unit){
        BmobSMS.requestSMSCode(phone,"",object : QueryListener<Int>(){



            override fun done(p0: Int?, p1: BmobException?) {
                if (p1 == null){
                    callBack(SUCCESS)
                }else{
                    callBack(FAILURE)
                }
            }


        })
    }

    //验证验证码
    fun verifySmsCode (phone: String,code:String,callBack: (Int) -> Unit){
        BmobSMS.verifySmsCode(phone,code,object:UpdateListener(){
            override fun done(p0: BmobException?) {
                if (p0 == null){
                    callBack(SUCCESS)
                }else{
                    callBack(FAILURE)
                }
            }

        })
    }
}