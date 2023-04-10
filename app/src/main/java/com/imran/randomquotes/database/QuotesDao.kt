package com.imran.randomquotes.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.imran.randomquotes.models.Result
@Dao
interface QuotesDao {

    @Insert
    suspend fun addQuotes(quoteList : List<Result>)

    @Query("SELECT * FROM quotes_table")
   suspend fun getQuotes() : List<Result>
}