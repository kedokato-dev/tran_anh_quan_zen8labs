package com.example.callapi.Model

data class Song(
    val id: String,
    val title: String,
    val album: String,
    val artist: String,
    val source: String,
    val image: String,
    val duration: Int,
    val favorite: Boolean,
    val counter: Int,
    val replay: Int
)
