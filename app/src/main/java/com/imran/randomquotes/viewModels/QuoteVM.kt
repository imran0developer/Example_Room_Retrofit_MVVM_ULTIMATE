package com.imran.randomquotes.viewModels

import androidx.lifecycle.*
import com.imran.randomquotes.Response
import com.imran.randomquotes.models.Quotes
import com.imran.randomquotes.repo.QuotesRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QuoteVM(private val quotesRepo: QuotesRepo) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            quotesRepo.getQuotes(1)
        }
    }

    val quotesList : LiveData<Response<Quotes>>
    get() = quotesRepo.quotes


}