package com.example.predifoot
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.predifoot.model.Match

class MatchAdapter(private val matchList: List<Match>) :
    RecyclerView.Adapter<MatchAdapter.MatchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        // Inflate the item layout and create the ViewHolder
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_match, parent, false)
        return MatchViewHolder(view)
    }

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        // Bind the data to the ViewHolder
        val match = matchList[position]
        holder.bind(match)
    }

    override fun getItemCount(): Int {
        // Return the number of items in the list
        return matchList.size
    }

    inner class MatchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Views inside the item layout
        private val textHomeTeam: TextView = itemView.findViewById(R.id.textHomeTeam)
        private val textAwayTeam: TextView = itemView.findViewById(R.id.textAwayTeam)
        private val textResult: TextView = itemView.findViewById(R.id.textResult)

        fun bind(match: Match) {
            // Bind data to views
            textHomeTeam.text = match.homeTeam
            textAwayTeam.text = match.awayTeam

            // Check if the match is expired
            if (match.isExpired) {
                // Display the result if the match is expired
                textResult.text = match.result
            } else {
                // Otherwise, display the prediction
                textResult.text = match.prediction
            }
        }
    }
}
