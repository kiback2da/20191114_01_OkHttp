package com.tjoeun.a20191114_01_okhttp

import android.os.Bundle
import com.tjoeun.a20191114_01_okhttp.utils.ServerUtil
import kotlinx.android.synthetic.main.activity_login.*

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
            ServerUtil.postRequestLogin(mContext, inputId,inputPW,null)
        }
    }

    override fun setValues() {
    }
}
