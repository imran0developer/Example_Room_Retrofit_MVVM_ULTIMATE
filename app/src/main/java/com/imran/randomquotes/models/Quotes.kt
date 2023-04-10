package com.imran.randomquotes.models

import com.google.gson.annotations.SerializedName

data class Quotes(
    val page: Int,
    val results: List<Result>,
    val totalCount: Int,
    val totalPages: Int
)