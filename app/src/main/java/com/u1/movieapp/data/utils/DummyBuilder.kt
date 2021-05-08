package com.u1.movieapp.data.utils

import com.u1.movieapp.R
import com.u1.movieapp.data.model.MoviesData
import com.u1.movieapp.data.model.SeriesData

object DummyBuilder {
    fun generateDummyMovies(): List<MoviesData> {
        val movies = ArrayList<MoviesData>()
        movies.add(MoviesData(
                "Glass",
                R.drawable.poster_glass,
                "16/01/2019",
                "2h 9min",
                "Drama, Sci-Fi, Thriller",
                "Security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities."
        ))

        movies.add(MoviesData(
                "Aquaman",
                R.drawable.poster_aquaman,
                "12/12/2018",
                "2h 23min",
                "Action, Adventure, Fantasy",
                "Arthur Curry, the human-born heir to the underwater kingdom of Atlantis, goes on a quest to prevent a war between the worlds of ocean and land."
        ))

        movies.add(MoviesData(
                "Alita: Battle Angel",
                R.drawable.poster_alita,
                "05/02/2019",
                "2h 2min",
                "Action, Adventure, Sci-Fi",
                "A deactivated cyborg's revived, but can't remember anything of her past and goes on a quest to find out who she is."
        ))

        return movies
    }

    fun generateDummySeries(): List<SeriesData> {
        val series = ArrayList<SeriesData>()
        series.add(SeriesData(
                "Gotham",
                R.drawable.poster_gotham,
                "2014-2019",
                "100 episodes",
                "Action, Crime, Drama",
                "The story behind Detective James Gordon's rise to prominence in Gotham City in the years before Batman's arrival."
        ))

        series.add(SeriesData(
                "The Flash",
                R.drawable.poster_flash,
                "2014-",
                "153 episodes",
                "Action, Adventure, Drama",
                "After being struck by lightning, Barry Allen wakes up from his coma to discover he's been given the power of super speed, becoming the next Flash, fighting crime in Central City."
        ))

        series.add(SeriesData(
                "Iron Fist",
                R.drawable.poster_iron_fist,
                "2017-2018",
                "23 episodes",
                "Action, Adventure, Crime",
                "A young man is bestowed with incredible martial arts skills and a mystical force known as the Iron Fist."
        ))

        return series
    }
}