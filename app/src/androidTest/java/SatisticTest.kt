package com.example.lab5

import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.lab5.screens.main.MainActivity
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.*

@RunWith(AndroidJUnit4::class)
class SatisticTest {
    @get:Rule
    var activityRule: ActivityScenarioRule<MainActivity> = ActivityScenarioRule(MainActivity::class.java)
    @Before
    fun before() {
        stopKoin() // to remove 'A Koin Application has already been started'
        startKoin {
            androidContext(ApplicationProvider.getApplicationContext())
            modules(appModule)
        }
    }

    @After
    fun after() {
        stopKoin()
    }
    @Test
    fun mistakesTest() {
        onView(withId(R.id.mistakesEditText)).perform(typeText("12"), closeSoftKeyboard())
        onView(withId(R.id.valueTextInputMistakes)).check(matches(isDisplayed()))
    }
    @Test
    fun pointsTest(){
        onView(withId(R.id.pointsEditText)).perform(typeText("11"), closeSoftKeyboard())
        onView(withId(R.id.valueTextInputPoints)).check(matches(isDisplayed()))
    }
    @Test
    fun buttonAddTest(){
        onView(withId(R.id.addStatisticButton)).perform(click())
    }
    @Test
    fun buttonAllStatTest(){
        onView(withId(R.id.allStatisticButton)).perform(click())
    }
}