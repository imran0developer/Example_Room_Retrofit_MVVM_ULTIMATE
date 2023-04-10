package com.imran.randomquotes

import androidx.lifecycle.LiveData
import com.imran.randomquotes.models.Quotes

sealed class Response<T>(val data :  T?=null,val errorMessage:String?=null){
    class Loading<T>() : Response<T>()
    class Success<T>(data: T? = null) : Response<T>(data = data)
    class Error<T>(error: String) : Response<T>(errorMessage = error)

}