package com.imran.randomquotes.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.imran.randomquotes.models.Result

@Database(entities = [Result::class], version = 1)
abstract class QuotesDatabase : RoomDatabase(){

    abstract fun quotesDao() : QuotesDao

    companion object{
        private var INSTANCE : QuotesDatabase? = null

        fun getDatabase(context: Context):QuotesDatabase {
            if (INSTANCE == null){
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(context,
                        QuotesDatabase::class.java,
                        "quotes_db"
                    ).build()
                }
            }
            return INSTANCE!!
        }
    }
}