package com.imran.randomquotes.viewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.imran.randomquotes.repo.QuotesRepo
import com.imran.randomquotes.viewModels.QuoteVM

class QuotesVMFactory(private val quotesRepo: QuotesRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return QuoteVM(quotesRepo) as T
    }
}