package com.tjoeun.a20191114_01_okhttp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tjoeun.a20191114_01_okhttp.utils.ServerUtil

class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

    }

    override fun setValues() {
        ServerUtil.postRequestLogin(mContext, "cho881020","qlalfqjsgh!",null)
    }
}