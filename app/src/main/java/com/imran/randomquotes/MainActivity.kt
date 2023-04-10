package com.imran.randomquotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.imran.randomquotes.api.ApiClient
import com.imran.randomquotes.api.ApiSet
import com.imran.randomquotes.repo.QuotesRepo
import com.imran.randomquotes.viewModelFactory.QuotesVMFactory
import com.imran.randomquotes.viewModels.QuoteVM

class MainActivity : AppCompatActivity() {
    lateinit var quoteVM: QuoteVM
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val quotesRepo = (application as QuoteApplication).quotesRepo

        quoteVM = ViewModelProvider(this, QuotesVMFactory(quotesRepo))[QuoteVM::class.java]
        quoteVM.quotesList.observe(this){
            when(it){
                is Response.Loading->{
                    Log.d("TAG2", "onCreate: Loading for api")
                }
                is Response.Success->{
                    it.data?.let {
                        Toast.makeText(applicationContext,"The data is fetched",Toast.LENGTH_SHORT).show()
                    }
                }
                is Response.Error-> {
//                    Toast.makeText(applicationContext, "Error Occured",Toast.LENGTH_SHORT).show()
                    Toast.makeText(applicationContext, "Error: ${it.errorMessage}",Toast.LENGTH_SHORT).show()
                    }

            }
        }
    }
}

