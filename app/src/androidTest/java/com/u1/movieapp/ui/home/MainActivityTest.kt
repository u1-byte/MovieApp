package com.u1.movieapp.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.u1.movieapp.R
import com.u1.movieapp.utils.IdlingResources
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainActivityTest {

    @get:Rule
    var activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(IdlingResources.getIdlingRes())
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(IdlingResources.getIdlingRes())
    }

    @Test
    fun loadMovies() {
        //click fragment
        onView(withId(R.id.navigation_movies)).perform(click())
        //check fragment display
        onView(withId(R.id.fragment_movies)).check(matches(isDisplayed()))
        //check rv poster display
        onView(withId(R.id.rv_poster_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_poster_movies)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(10))
    }

    @Test
    fun loadSeries() {
        //click fragment series
        onView(withId(R.id.navigation_series)).perform(click())
        //check fragment display
        onView(withId(R.id.fragment_series)).check(matches(isDisplayed()))
        //check rv poster display
        onView(withId(R.id.rv_poster_series)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_poster_series)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(10))
    }

    @Test
    fun loadMoviesDetail() {
        //click fragment
        onView(withId(R.id.navigation_movies)).perform(click())
        //check fragment display
        onView(withId(R.id.fragment_movies)).check(matches(isDisplayed()))
        //check rv poster display
        onView(withId(R.id.rv_poster_movies)).check(matches(isDisplayed()))
        //click on rv poster movies
        onView(withId(R.id.rv_poster_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        onView(withId(R.id.poster)).check(matches(isDisplayed()))
        onView(withId(R.id.title)).check(matches(isDisplayed()))
        onView(withId(R.id.genre)).check(matches(isDisplayed()))
        onView(withId(R.id.date)).check(matches(isDisplayed()))
        onView(withId(R.id.desc)).check(matches(isDisplayed()))
    }

    @Test
    fun loadSeriesDetail() {
        //click fragment series
        onView(withId(R.id.navigation_series)).perform(click())
        //check fragment display
        onView(withId(R.id.fragment_series)).check(matches(isDisplayed()))
        //check rv poster display
        onView(withId(R.id.rv_poster_series)).check(matches(isDisplayed()))
        //click on rv poster series
        onView(withId(R.id.rv_poster_series)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        onView(withId(R.id.poster)).check(matches(isDisplayed()))
        onView(withId(R.id.title)).check(matches(isDisplayed()))
        onView(withId(R.id.genre)).check(matches(isDisplayed()))
        onView(withId(R.id.date)).check(matches(isDisplayed()))
        onView(withId(R.id.desc)).check(matches(isDisplayed()))
    }

}