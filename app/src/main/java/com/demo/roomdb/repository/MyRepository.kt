package com.demo.roomdb.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.demo.roomdb.model.UserModel
import com.virgo.readdirectory.room.LoginDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class MyRepository{
    companion object{
        var loginDb : LoginDatabase? = null

        var loginDataModel : LiveData<UserModel>? = null

        fun initDatabase(context: Context) : LoginDatabase{
            return LoginDatabase.getDataseClient(context)
        }

        fun insertUserData(context: Context, username : String, password : String) {
            loginDb = initDatabase(context)

            CoroutineScope(IO).launch {
                var userModel = UserModel(username,password)
                loginDb!!.loginDao().InsertData(userModel)
            }
        }

        fun getUserData(context: Context,username: String) : LiveData<UserModel>? {
            loginDb = initDatabase(context)
            loginDataModel = loginDb!!.loginDao().getLoginDetails(username)
            return loginDataModel
        }
    }
}