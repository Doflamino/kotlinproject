package com.example.kotlinproject.data.api

import android.telecom.Call
import com.example.kotlinproject.data.vo.Player
import retrofit2.http.GET

interface PlayerApi {
    @get:GET("/Doflamino/Android_Project/posts")
    val restResponse: Call<List<Player>>
}