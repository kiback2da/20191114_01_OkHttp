package com.tjoeun.a20191114_01_okhttp

import android.content.Intent
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
                            val dataObject = json.getJSONObject("data")
                            val userObject = dataObject.getJSONObject("user")

                            var loginId = userObject.getString("login_id")
                            var name = userObject.getString("name")

                            Toast.makeText(mContext,"${loginId} : ${name}님 환영합니다.",Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })
        }

        loginBtnSignUp.setOnClickListener {
            var intent = Intent(mContext,SignUpActivity::class.java)
            startActivity(intent)
        }
    }

    override fun setValues() {
    }
}
