package com.example.predifoot.model

import com.google.gson.annotations.SerializedName

data class Match(
    @SerializedName("home_team")  val homeTeam: String,
    @SerializedName("away_team")  val awayTeam: String,
    @SerializedName("prediction") val prediction: String,
    @SerializedName("is_expired") val isExpired: Boolean,
    @SerializedName("result")     val result: String,
    @SerializedName("start_date") val startDate: String,
    @SerializedName("odds")       val odds: Map<String, Double>
)