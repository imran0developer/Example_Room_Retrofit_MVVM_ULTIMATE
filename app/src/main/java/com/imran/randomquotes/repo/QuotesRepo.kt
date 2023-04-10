package com.imran.randomquotes.repo

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.imran.randomquotes.Response
import com.imran.randomquotes.api.ApiSet
import com.imran.randomquotes.database.QuotesDatabase
import com.imran.randomquotes.models.Quotes
import com.imran.randomquotes.utils.NetworkUtils

class QuotesRepo(
    private val apiSet: ApiSet,
    private val quotesDatabase: QuotesDatabase,
    private val context: Context
    ) {

    private val quotesList = MutableLiveData<Response<Quotes>>()

    val quotes : LiveData<Response<Quotes>>
        get() = quotesList

    suspend fun getQuotes(page:Int){

        if (NetworkUtils.isInternetAvailable(context)){
            try {

                val result = apiSet.getQuotes(page)
                if (result?.body() != null) {
                    quotesDatabase.quotesDao().addQuotes(result.body()!!.results)
                    quotesList.postValue(Response.Success(result.body()))
                }else{
                    quotesList.postValue(Response.Error("API Error"))
                }
            }catch (e : java.lang.Exception){
                quotesList.postValue(Response.Error("Something went wrong while calling API"))
            }

        }else{
            val quotes = quotesDatabase.quotesDao().getQuotes()
            val quoteList = Quotes(1,quotes,1,1)
            quotesList.postValue(Response.Success(quoteList))
        }

    }
}