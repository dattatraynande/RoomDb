package com.demo.roomdb.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.demo.roomdb.model.UserModel
import com.demo.roomdb.repository.MyRepository

class LoginViewModel: AndroidViewModel {

    constructor(application: Application) : super(application)

    var userLiveData: LiveData<UserModel>? = null

    fun insertData(
        username: String,
        password: String
    ) {
        MyRepository.insertUserData(getApplication(), username, password)
    }

    fun getUserData(
        username: String
    ): LiveData<UserModel>? {
        userLiveData = MyRepository.getUserData(getApplication(), username)
        return userLiveData
    }
}