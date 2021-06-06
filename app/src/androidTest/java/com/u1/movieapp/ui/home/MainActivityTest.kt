package com.u1.movieapp.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.u1.movieapp.R
import com.u1.movieapp.data.utils.DummyBuilder
import org.junit.Rule
import org.junit.Test

class MainActivityTest {

    private val dataMoviesPlaying = DummyBuilder.generateDummyMoviesPlaying()
    private val dataMoviesPopular = DummyBuilder.generateDummyMoviesPopular()
    private val dataSeriesPlaying = DummyBuilder.generateDummySeriesPlaying()
    private val dataSeriesPopular = DummyBuilder.generateDummySeriesPopular()

    @get:Rule
    var activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun onFragmentMovies() {
        //click fragment
        onView(withId(R.id.navigation_movies)).perform(click())
        //check fragment display
        onView(withId(R.id.fragment_movies)).check(matches(isDisplayed()))
        //check rv poster display
        onView(withId(R.id.rv_poster_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_poster_movies)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dataMoviesPlaying.size))
        //check rv poster desc display
        onView(withId(R.id.rv_poster_desc_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_poster_desc_movies)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dataMoviesPopular.size))

        //click on rv poster movies
        onView(withId(R.id.rv_poster_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        //test only one attribute because its parcelable should be the same to another
        onView(withId(R.id.title)).check(matches(isDisplayed()))
        onView(withId(R.id.title)).check(matches(withText(dataMoviesPlaying[0].title)))
    }


    @Test
    fun onFragmentSeries() {
        //click fragment series
        onView(withId(R.id.navigation_series)).perform(click())
        //check fragment display
        onView(withId(R.id.fragment_series)).check(matches(isDisplayed()))
        //check rv poster display
        onView(withId(R.id.rv_poster_series)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_poster_series)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dataSeriesPlaying.size))
        //check rv poster desc display
        onView(withId(R.id.rv_poster_desc_series)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_poster_desc_series)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dataSeriesPopular.size))

        //click on rv poster series
        onView(withId(R.id.rv_poster_series)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        //test only one attribute because its parcelable should be the same to another
        onView(withId(R.id.title)).check(matches(isDisplayed()))
        onView(withId(R.id.title)).check(matches(withText(dataSeriesPlaying[0].title)))
    }
}