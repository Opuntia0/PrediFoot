package com.example.predifoot

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.predifoot.model.Match
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MatchViewModel : ViewModel() {

    private val apiService: FootballPredictionApiService

    private val _incomingMatches = MutableLiveData<List<Match>>()
    val incomingMatches: LiveData<List<Match>> get() = _incomingMatches

    private val _finishedMatches = MutableLiveData<List<Match>>()
    val finishedMatches: LiveData<List<Match>> get() = _finishedMatches


    private val _matches = MutableLiveData<List<Match>>()

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://football-prediction-api.p.rapidapi.com/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder().build())
            .build()

        apiService = retrofit.create(FootballPredictionApiService::class.java)

        fetchDataFromApi()
    }

    fun fetchDataFromApi() {
        val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val currentDate = sdf.format(Date())

        val apiKey = "TODO" // TODO Replace with your key
        val apiHost = "football-prediction-api.p.rapidapi.com"
        val market = "classic"
        val isoDate = currentDate
        val federation = "UEFA"

        Log.d("Api Calls", "Start Fetching function")
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response =
                    apiService.getPredictions(apiKey, apiHost, market, isoDate, federation)
                withContext(Dispatchers.Main) {
                    if (response.isSuccessful) {
                        val predictionResponse = response.body()
                        Log.d("Api Calls", "Pred : ${predictionResponse?.data}")
                        _matches.postValue(predictionResponse?.data ?: emptyList())

                        updateMatches(predictionResponse?.data)
                    } else {
                    }
                }
            } catch (e: Exception) {
                Log.e("API Call", "Exception: ${e.message}")
            }
        }
    }

    private fun updateMatches(matches: List<Match>?) {
        Log.d("Api Calls", "Uptading matches. Size: " + matches?.size)

        matches?.let {
            val (finishedMatches, incomingMatches) = matches.partition { it.isExpired }

            _incomingMatches.postValue(incomingMatches)
            _finishedMatches.postValue(finishedMatches)
        } ?: run {
            Log.e("MatchViewModel", "Matches is null")
        }
    }

}

