package com.u1.movieapp.data.local

import com.u1.movieapp.R
import com.u1.movieapp.data.model.DetailModel
import com.u1.movieapp.data.model.DummyData
import com.u1.movieapp.data.model.MoviesModel
import com.u1.movieapp.data.model.SeriesModel
import com.u1.movieapp.data.remote.response.*

object DummyBuilder {

    //dummy movies
    fun generateDummyMoviesPopular(): List<DummyData> {
        val movies = ArrayList<DummyData>()
        movies.add(DummyData(
            1,
            "Glass",
            R.drawable.poster_glass,
            "16/01/2019",
            "2h 9min",
            "Drama, Sci-Fi, Thriller",
            "Security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities."
        ))

        movies.add(DummyData(
            2,
            "Aquaman",
            R.drawable.poster_aquaman,
            "12/12/2018",
            "2h 23min",
            "Action, Adventure, Fantasy",
            "Arthur Curry, the human-born heir to the underwater kingdom of Atlantis, goes on a quest to prevent a war between the worlds of ocean and land."
        ))

        movies.add(DummyData(
            3,
            "Alita: Battle Angel",
            R.drawable.poster_alita,
            "05/02/2019",
            "2h 2min",
            "Action, Adventure, Sci-Fi",
            "A deactivated cyborg's revived, but can't remember anything of her past and goes on a quest to find out who she is."
        ))

        movies.add(DummyData(
            4,
            "Avengers: Infinity War",
            R.drawable.poster_infinity_war,
            "25/04/2018",
            "2h 29min",
            "Action, Adventure, Sci-Fi",
            "The Avengers and their allies must be willing to sacrifice all in an attempt to defeat the powerful Thanos before his blitz of devastation and ruin puts an end to the universe."
        ))

        movies.add(DummyData(
            5,
            "A Star Is Born",
            R.drawable.poster_a_start_is_born,
            "19/10/2018",
            "2h 16min",
            "Drama, Music, Romance",
            "A musician helps a young singer find fame as age and alcoholism send his own career into a downward spiral."
        ))

        movies.add(DummyData(
            6,
            "Bohemian Rhapsody",
            R.drawable.poster_bohemian,
            "30/10/2018",
            "2h 14min",
            "Drama, Music, Biography",
            "The story of the legendary British rock band Queen and lead singer Freddie Mercury, leading up to their famous performance at Live Aid (1985)."
        ))

        movies.add(DummyData(
            7,
            "How To Train Your Dragon",
            R.drawable.poster_how_to_train,
            "09/01/2019",
            "1h 44min",
            "Animation, Action, Adventure",
            "When Hiccup discovers Toothless isn't the only Night Fury, he must seek \"The Hidden World\", a secret Dragon Utopia before a hired tyrant named Grimmel finds it first."
        ))

        movies.add(DummyData(
                8,
            "Creed II",
            R.drawable.poster_creed,
            "28/11/2018",
            "2h 10min",
            "Drama, Sport",
            "Under the tutelage of Rocky Balboa, newly crowned heavyweight champion Adonis Creed faces off against Viktor Drago, the son of Ivan Drago."
        ))

        movies.add(DummyData(
                9,
            "Mortal Engines",
            R.drawable.poster_mortal_engines,
            "05/12/2018",
            "2h 8min",
            "Action, Adventure, Fantasy",
            "In a post-apocalyptic world where cities ride on wheels and consume each other to survive, two people meet in London and try to stop a conspiracy."
        ))

        movies.add(DummyData(
                10,
            "Robin Hood",
            R.drawable.poster_robin_hood,
            "20/11/2018",
            "1h 56min",
            "Action, Adventure, Drama",
            "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown."
        ))

        movies.add(DummyData(
                11,
            "Mary Queen Of Scots",
            R.drawable.poster_marry_queen,
            "21/12/2018",
            "2h 5min",
            "Biography, Drama, History",
            "Mary Stuart's (Saoirse Ronan's) attempt to overthrow her cousin Elizabeth I (Margot Robbie), Queen of England, finds her condemned to years of imprisonment before facing execution."
        ))

        return movies
    }

    //dummy series
    fun generateDummySeriesPopular(): List<DummyData> {
        val series = ArrayList<DummyData>()
        series.add(DummyData(
            12,
            "Gotham",
            R.drawable.poster_gotham,
            "2014-2019",
            "100 episodes",
            "Action, Crime, Drama",
            "The story behind Detective James Gordon's rise to prominence in Gotham City in the years before Batman's arrival."
        ))

        series.add(DummyData(
            13,
            "The Flash",
            R.drawable.poster_flash,
            "2014-",
            "153 episodes",
            "Action, Adventure, Drama",
            "After being struck by lightning, Barry Allen wakes up from his coma to discover he's been given the power of super speed, becoming the next Flash, fighting crime in Central City."
        ))

        series.add(DummyData(
            14,
            "Iron Fist",
            R.drawable.poster_iron_fist,
            "2017-2018",
            "23 episodes",
            "Action, Adventure, Crime",
            "A young man is bestowed with incredible martial arts skills and a mystical force known as the Iron Fist."
        ))

        series.add(DummyData(
            15,
            "Fairy Tail",
            R.drawable.poster_fairytail,
            "2009-2019",
            "339 episodes",
            "Action, Adventure, Animation",
            "Lucy, an aspiring Celestial Wizard, becomes a friend and ally to powerful wizards Natsu, Gray, and Erza, who are part of the (in)famous wizard guild, Fairy Tail."
        ))

        series.add(DummyData(
            16,
            "Dragon Ball",
            R.drawable.poster_dragon_ball,
            "2015-2018",
            "131 episodes",
            "Action, Adventure, Animation",
            "Six months after the defeat of Majin Buu, The mighty Saiyan Son Goku continues his quest on becoming stronger."
        ))

        series.add(DummyData(
            17,
            "Family Guy",
            R.drawable.poster_family_guy,
            "1999-",
            "371 episodes",
            "Animation, Comedy",
            "In a wacky Rhode Island town, a dysfunctional family strive to cope with everyday life as they are thrown from one crazy scenario to another."
        ))

        series.add(DummyData(
                18,
            "Grey's Anatomy",
            R.drawable.poster_grey_anatomy,
            "2005-",
            "381 episodes",
            "Drama, Romance",
            "A drama centered on the personal and professional lives of five surgical interns and their supervisors."
        ))

        series.add(DummyData(
                19,
            "Hanna",
            R.drawable.poster_hanna,
            "2019-",
            "19 episodes",
            "Action, Drama",
            "In equal parts high-concept thriller and coming-of-age drama, HANNA follows the journey of an extraordinary young girl raised in the forest, as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is."
        ))

        series.add(DummyData(
                20,
            "NCIS: Naval Criminal Investigative Service",
            R.drawable.poster_ncis,
            "2003-",
            "415 episodes",
            "Action, Drama, Crime",
            "The cases of the Naval Criminal Investigative Service's Washington, D.C. Major Case Response Team, led by Special Agent Leroy Jethro Gibbs."
        ))

        series.add(DummyData(
                21,
            "The Walking Dead",
            R.drawable.poster_the_walking_dead,
            "2010-2022",
            "177 episodes",
            "Drama, Horror, Thriller",
            "Sheriff Deputy Rick Grimes wakes up from a coma to learn the world is in ruins and must lead a group of survivors to stay alive."
        ))

        series.add(DummyData(
                22,
            "Shameless",
            R.drawable.poster_shameless,
            "2011-2021",
            "134 episodes",
            "Comedy, Drama",
            "A scrappy, feisty, fiercely loyal Chicago family makes no apologies."
        ))

        return series
    }

    //detail movies
    fun generateDetailMovies(): DetailModel {
        return DetailModel(
                22,
                "Pirates of the Caribbean",
                "2003-07-09",
                listOf("Adventure", "Fantasy", "Action"),
                "Jack Sparrow, a freewheeling 18th-century pirate, quarrels with a rival pirate bent on pillaging Port Royal. When the governor's daughter is kidnapped, Sparrow decides to help the girl's love save her.",
                "/zRBaZxS5YauLvRYjAdL4AUCwlht.jpg"
        )
    }

    //detail series
    fun generateDetailSeries(): DetailModel {
        return DetailModel(
                44,
                "Hero of the Year",
                "1993-12-03",
                listOf("Animation", "Sci-fi & Fantasy", "Comedy"),
                "Wes Weasley pretends to host a roast (actually a clip show) to Sonic that Robotnik uses to force him to surrender.\n\nSonic Says segment: Alcohol",
                "/xjhZhermBwZtWiPA7xT7Rli2tmD.jpg"
        )
    }

    //movies data using new model
    fun generateMoviesData(): List<MoviesModel> {
        return listOf(
                MoviesModel(
                        11,
                        "Star Wars",
                        "/tdQzRSk4PXX6hzjLcQWHafYtZTI.jpg"
                ),

                MoviesModel(
                        12,
                        "Finding Nemo",
                        "/xwggrEugjcJDuabIWvK2CpmK91z.jpg"
                )
        )
    }

    //series data using new model
    fun generateSeriesData(): List<SeriesModel> {
        return listOf(
                SeriesModel(
                        11,
                        "Sexual Chemistry",
                        "/3hFpUg6Ty25Vs5XgbnNz1Xcirb5.jpg"
                ),

                SeriesModel(
                        12,
                        "Han Wu Da Di",
                        "/sg6tjBKBu62mC9uj2CJPoP0Zl2M.jpg"
                )
        )
    }

    //responses data
    fun generateMoviesResponse(): List<MoviesPopularResponse> {
        return listOf(
                MoviesPopularResponse(
                        id = 66,
                        title = "Absolute Power",
                        poster = "/n7U0FEirHej1yQIy2mAzDtF9wBz.jpg",
                        year = "1997-02-14"
                ),

                MoviesPopularResponse(
                        id = 77,
                        title = "Memento",
                        poster = "/yuNs09hvpHVU1cBTCAk9zxsL2oW.jpg",
                        year = "2000-10-11"
                ),

                MoviesPopularResponse(
                        id = 88,
                        title = "Dirty Dancing",
                        poster = "/dvEggyDTTIBDvrUNjTEa9depT0f.jpg",
                        year = "1987-08-21"
                )
        )
    }

    fun generateSeriesResponse(): List<SeriesPopularResponse> {
        return listOf(
                SeriesPopularResponse(
                        id = 66,
                        title = "Absolute Power",
                        poster = "/n7U0FEirHej1yQIy2mAzDtF9wBz.jpg",
                        year = "1997-02-14"
                ),

                SeriesPopularResponse(
                        id = 77,
                        title = "Memento",
                        poster = "/yuNs09hvpHVU1cBTCAk9zxsL2oW.jpg",
                        year = "2000-10-11"
                ),

                SeriesPopularResponse(
                        id = 88,
                        title = "Dirty Dancing",
                        poster = "/dvEggyDTTIBDvrUNjTEa9depT0f.jpg",
                        year = "1987-08-21"
                )
        )
    }

    fun generateDetailMoviesResponse(): MoviesDetailResponse {
        return MoviesDetailResponse(
                id = 101,
                title = "Léon: The Professional",
                year = "1994-09-14",
                genres = listOf(GenreResponse(18, "Drama")),
                overview = "Léon, the top hit man in New York, has earned a rep as an effective \"cleaner\". But when his next-door neighbors are wiped out by a loose-cannon DEA agent, he becomes the unwilling custodian of 12-year-old Mathilda. Before long, Mathilda's thoughts turn to revenge, and she considers following in Léon's footsteps.",
                poster = "/wHqGb8J6tXBVwjqWooGMtNEjs2A.jpg"
        )
    }

    fun generateDetailSeriesResponse(): SeriesDetailResponse {
        return SeriesDetailResponse(
                id = 101,
                title = "Beat the Geeks",
                year = "2002-10-07",
                genres = listOf(GenreResponse(18, "Drama")),
                overview = "Beat the Geeks is an American comedy game show that aired on Comedy Central from 2001 to 2002. The show was rerun on The Comedy Network in Canada and reruns currently air on G4techTV Canada and Prime in New Zealand.\n\nOn the show, contestants face off in trivia matches against \"geeks\" who are well-versed in music, movies, and television, as well as a fourth guest geek with an alternate area of expertise which varies from episode to episode. The object is to outsmart the geek at their own subject; as a handicap, the geeks are given questions of considerably greater difficulty than the contestants. Beat the Geeks was taped at the Hollywood Center Studios.",
                poster = "/iEjDG1ZP0ocUHdqsozEgIlwaCpI.jpg"
        )
    }
}