package com.example.predifoot

class LocalDataExample {

    // OM / Metz 9/2 (passé) 1 - 1
    val match1 = Match(
        homeTeam = "Marseille",
        awayTeam = "Metz",
        prediction = "1",
        isExpired = true,
        result = "1 - 1",
        startDate = "2024-02-09T20:00:00",
        odds = mapOf(
            "1" to 1.338,
            "2" to 9.867,
            "12" to 1.17,
            "X" to 5.063,
            "1X" to 1.062,
            "X2" to 3.286
        )
    )

    // Lens - Strasbourg
    val match2 = Match(
        homeTeam = "Lens",
        awayTeam = "Strasbourg",
        prediction = "1",
        isExpired = true,
        result = "3 - 1",
        startDate = "2024-02-10T16:00:00",
        odds = mapOf(
            "1" to 1.737,
            "2" to 4.987,
            "12" to 1.276,
            "X" to 3.703,
            "1X" to 1.17,
            "X2" to 2.116
        )
    )

    // ENCOURS PSG Lille
    val match3 = Match(
        homeTeam = "Paris Saint Germain",
        awayTeam = "Lille",
        prediction = "1",
        isExpired = false,
        result = "",
        startDate = "2024-02-10T20:00:00",
        odds = mapOf(
            "1" to 1.722,
            "2" to 4.755,
            "12" to 1.254,
            "X" to 3.9,
            "1X" to 1.182,
            "X2" to 2.104
        )
    )
}

// Raw
/*
[
  {
    "home_team": "Marseille",
    "away_team": "Metz",
    "id": 286867,
    "market": "classic",
    "competition_name": "Ligue 1",
    "prediction": "1",
    "competition_cluster": "France",
    "status": "lost",
    "federation": "UEFA",
    "is_expired": true,
    "season": "2023 - 2024",
    "result": "1 - 1",
    "start_date": "2024-02-09T20:00:00",
    "last_update_at": "2024-02-09T09:18:56.650114",
    "odds": {
      "1": 1.338,
      "2": 9.867,
      "12": 1.17,
      "X": 5.063,
      "1X": 1.062,
      "X2": 3.286
    }
  },
  {
    "home_team": "Paris Saint Germain",
    "away_team": "Lille",
    "id": 287038,
    "market": "classic",
    "competition_name": "Ligue 1",
    "prediction": "1",
    "competition_cluster": "France",
    "status": "pending",
    "federation": "UEFA",
    "is_expired": false,
    "season": "2023 - 2024",
    "result": "",
    "start_date": "2024-02-10T20:00:00",
    "last_update_at": "2024-02-10T15:18:14.543787",
    "odds": {
      "1": 1.722,
      "2": 4.755,
      "12": 1.254,
      "X": 3.9,
      "1X": 1.182,
      "X2": 2.104
    }
  },
  {
    "home_team": "Lens",
    "away_team": "Strasbourg",
    "id": 287037,
    "market": "classic",
    "competition_name": "Ligue 1",
    "prediction": "1",
    "competition_cluster": "France",
    "status": "won",
    "federation": "UEFA",
    "is_expired": true,
    "season": "2023 - 2024",
    "result": "3 - 1",
    "start_date": "2024-02-10T16:00:00",
    "last_update_at": "2024-02-10T15:18:14.543787",
    "odds": {
      "1": 1.737,
      "2": 4.987,
      "12": 1.276,
      "X": 3.703,
      "1X": 1.17,
      "X2": 2.116
    }
  }
]
 */