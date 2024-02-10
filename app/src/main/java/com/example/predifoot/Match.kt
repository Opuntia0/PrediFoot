package com.example.predifoot

data class Match(
    val homeTeam: String,
    val awayTeam: String,
    val prediction: String,
    val isExpired: Boolean,
    val result: String,
    val startDate: String,
    val odds: Map<String, Double>
)