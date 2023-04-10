package com.imran.randomquotes.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("quotes_table")
data class Result(
    @PrimaryKey(autoGenerate = true)
    val quoteId: Int,
    val _id: String,
    val author: String,
    val content: String,
    val dateAdded: String
    )