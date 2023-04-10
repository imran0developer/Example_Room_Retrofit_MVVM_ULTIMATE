package com.imran.randomquotes.api

import com.imran.randomquotes.models.Quotes
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiSet {

    @GET("/quotes")
    suspend fun getQuotes(
        @Query("page")  page : Int
    ) : Response<Quotes>


}