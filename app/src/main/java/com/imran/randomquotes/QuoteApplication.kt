package com.imran.randomquotes

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import com.imran.randomquotes.api.ApiClient
import com.imran.randomquotes.api.ApiSet
import com.imran.randomquotes.database.QuotesDatabase
import com.imran.randomquotes.repo.QuotesRepo
import com.imran.randomquotes.viewModelFactory.QuotesVMFactory
import com.imran.randomquotes.viewModels.QuoteVM

class QuoteApplication : Application() {

    lateinit var quotesRepo: QuotesRepo

    override fun onCreate() {
        super.onCreate()
        initialize()
    }




    private fun initialize() {
        val apiSet = ApiClient.getClient().create(ApiSet::class.java)
        val quotesDatabase = QuotesDatabase.getDatabase(applicationContext)
        quotesRepo = QuotesRepo(apiSet,quotesDatabase,applicationContext)


    }
}