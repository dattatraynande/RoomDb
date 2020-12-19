package com.demo.roomdb.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Login")
data class UserModel(
    @ColumnInfo(name = "username")
    var userName : String,

    @ColumnInfo(name = "password")
    var userPass : String
){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id : Int? = 0

}
