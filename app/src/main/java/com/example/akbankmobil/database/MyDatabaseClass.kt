package com.example.akbankmobil.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.akbankmobil.dao.UserDao
import com.example.akbankmobil.entity.User

@Database(entities = [User::class], version = 1)
abstract class MyDatabaseClass : RoomDatabase() {

    abstract fun kisilerDao(): UserDao

    companion object{
        var INSTANCE : MyDatabaseClass? = null

        fun databaseConnect(context: Context): MyDatabaseClass?{

            if (INSTANCE ==null){

                synchronized(MyDatabaseClass::class){
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        MyDatabaseClass::class.java,
                        "AkbankMobil").build()
                }

            }

            return INSTANCE

        }


    }

}