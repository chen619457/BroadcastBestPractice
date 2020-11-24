package com.example.broadcastbestpractice

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        //记住密码
        val prefs = getPreferences(Context.MODE_PRIVATE)
        val isRemember = prefs.getBoolean("记住密码",false)
        if (isRemember){
            //将账号和密码都设置到文本框中
            val id = prefs.getString("id","")
            val password  = prefs.getString("password","")
            UserID.setText(id)
            UserPwd.setText(password)
            rememberPass.isChecked = true
        }


        LoginButton.setOnClickListener {
            val id :String=UserID.text.trim().toString()
            val password :String=UserPwd.text.trim().toString()
            if (id=="1175275831"&&password=="123456")
            {
                //记住密码
                val editor = prefs.edit()
                if (rememberPass.isChecked){//检查复选框是否被选中
                    editor.putBoolean("记住密码",true)
                    editor.putString("id",id)
                    editor.putString("password",password)
                }else{
                    editor.clear()
                }
                editor.apply()


                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
            }else
                Toast.makeText(this,"QQ号码或密码错误,请重试",Toast.LENGTH_LONG).show()
        }


    }
}