package com.example.callapi

import SongResponse
import com.example.callapi.Model.Song
import retrofit2.http.GET

interface SongAPI
{
    @GET("resources/braniumapis/songs.json")
    suspend fun getSongs(): SongResponse
}