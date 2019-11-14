package com.tjoeun.a20191114_01_okhttp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.tjoeun.a20191114_01_okhttp.utils.ServerUtil
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_sign_up.*
import org.json.JSONObject

class SignUpActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        setupEvents()
    }

    override fun setupEvents() {
        signUpBtnSignUp.setOnClickListener {
            Log.d("로그","signUpBtnSignUp")
            var inputId = signUpEdtID.text.toString()
            var inputPW =  signUpEdtPassword.text.toString()
            var inputName = signUpEdtName.text.toString()
            var inputPhoneNum = signUpEdtPhoneNum.text.toString()

            Log.d("로그",inputId+","+inputPW+","+inputName+","+inputPhoneNum)

            ServerUtil.putRequestSignUp(mContext, inputId,inputPW,inputName,inputPhoneNum,object : ServerUtil.JsonResponseHandler{
                override fun onResponse(json: JSONObject) {
                    runOnUiThread {
                        Log.d("로그","${json.toString()}")
                        finish()
                    }
                }
            })
        }
    }

    override fun setValues() {
    }
}
