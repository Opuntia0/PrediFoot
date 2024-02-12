package com.example.predifoot

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.predifoot.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var matchViewModel: MatchViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Init View Model
        matchViewModel = ViewModelProvider(this).get(MatchViewModel::class.java)

        // Observer matches in coming
        matchViewModel.incomingMatches.observe(this) { incomingMatches ->
            val incomingAdapter = MatchAdapter(incomingMatches)
            binding.inComingMatchRv.layoutManager = LinearLayoutManager(this)
            binding.inComingMatchRv.adapter = incomingAdapter
        }

        // Observer finished matches
        matchViewModel.finishedMatches.observe(this) { finishedMatches ->
            val finishedAdapter = MatchAdapter(finishedMatches)
            binding.finishedMatchRv.layoutManager = LinearLayoutManager(this)
            binding.finishedMatchRv.adapter = finishedAdapter
        }

    }

}
