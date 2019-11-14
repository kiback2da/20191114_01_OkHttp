package com.tjoeun.a20191114_01_okhttp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.tjoeun.a20191114_01_okhttp.utils.ServerUtil
import kotlinx.android.synthetic.main.activity_login.*
import org.json.JSONObject

class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {
        loginBtnLogin.setOnClickListener {
            var inputId = loginEdtID.text.toString()
            var inputPW =  loginEdtPassword.text.toString()
            ServerUtil.postRequestLogin(mContext, inputId,inputPW,object : ServerUtil.JsonResponseHandler{
                override fun onResponse(json: JSONObject) {
                    runOnUiThread {
                        Log.d("로그","${json.toString()}")

                        val code = json.getInt("code")
                        val message = json.getString("message")

                        if(code == 400){
                            Toast.makeText(mContext,message,Toast.LENGTH_SHORT).show()
                        }else if(code == 200){
                            Toast.makeText(mContext,"로그인 성공",Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })
        }
    }

    override fun setValues() {
    }
}
