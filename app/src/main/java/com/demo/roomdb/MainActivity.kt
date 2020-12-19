package com.demo.roomdb

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.demo.roomdb.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var myViewModel: LoginViewModel
    lateinit var strUsername: String
    lateinit var strPassword: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myViewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)

        btnAddLogin.setOnClickListener {
            strUsername = txtUsername.text.toString().trim()
            strPassword = txtPassword.text.toString().trim()

            if (strPassword.isEmpty()) {
                txtUsername.error = "Please enter the username"
            } else if (strPassword.isEmpty()) {
                txtPassword.error = "Please enter the username"
            } else {
                myViewModel.insertData(strUsername, strPassword)
            }
        }

        btnReadLogin.setOnClickListener {
            strUsername = txtUsername.text.toString().trim()
            myViewModel.getUserData(strUsername)!!.observe(
                this,
                Observer {

                    lblUseraname.text = it.userName!!
                    lblPassword.text = it.userPass!!
                }
            )
        }
    }
}