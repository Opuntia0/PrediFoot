package com.example.predifoot

import com.example.predifoot.model.PredictionResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface FootballPredictionApiService {
    @GET("predictions")
    suspend fun getPredictions(
        @Header("X-RapidAPI-Key") apiKey: String,
        @Header("X-RapidAPI-Host") apiHost: String,
        @Query("market") market: String,
        @Query("iso_date") isoDate: String,
        @Query("federation") federation: String
    ): Response<PredictionResponse>
}
