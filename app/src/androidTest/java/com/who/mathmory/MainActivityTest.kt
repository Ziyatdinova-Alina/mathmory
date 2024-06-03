package com.who.mathmory


import androidx.test.espresso.DataInteraction
import androidx.test.espresso.ViewInteraction
import androidx.test.filters.LargeTest
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent

import androidx.test.InstrumentationRegistry.getInstrumentation
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*

import com.who.mathmory.R

import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.core.IsInstanceOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.anything
import org.hamcrest.Matchers.`is`

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun mainActivityTest() {
        val imageView = onView(
            allOf(
                withContentDescription("back"),
                withParent(withParent(IsInstanceOf.instanceOf(androidx.compose.ui.platform.ComposeView::class.java))),
                isDisplayed()
            )
        )
        imageView.check(matches(isDisplayed()))

        val textView = onView(
            allOf(
                withText("???????????"),
                withParent(withParent(IsInstanceOf.instanceOf(androidx.compose.ui.platform.ComposeView::class.java))),
                isDisplayed()
            )
        )
        textView.check(matches(withText("???????????")))

        val imageView2 = onView(
            allOf(
                withContentDescription("menu"),
                withParent(withParent(IsInstanceOf.instanceOf(androidx.compose.ui.platform.ComposeView::class.java))),
                isDisplayed()
            )
        )
        imageView2.check(matches(isDisplayed()))

        val imageView3 = onView(
            allOf(
                withContentDescription("derivative_formula1_question"),
                withParent(withParent(IsInstanceOf.instanceOf(android.view.View::class.java))),
                isDisplayed()
            )
        )
        imageView3.check(matches(isDisplayed()))

        val imageView4 = onView(
            allOf(
                withContentDescription("derivative_formula1_equal"),
                withParent(withParent(IsInstanceOf.instanceOf(android.view.View::class.java))),
                isDisplayed()
            )
        )
        imageView4.check(matches(isDisplayed()))

        val imageView5 = onView(
            allOf(
                withContentDescription("derivative_formula1_answer"),
                withParent(withParent(IsInstanceOf.instanceOf(android.view.View::class.java))),
                isDisplayed()
            )
        )
        imageView5.check(matches(isDisplayed()))

        val imageView6 = onView(
            allOf(
                withContentDescription("derivative_formula12_question"),
                withParent(withParent(IsInstanceOf.instanceOf(android.view.View::class.java))),
                isDisplayed()
            )
        )
        imageView6.check(matches(isDisplayed()))

        val imageView7 = onView(
            allOf(
                withContentDescription("derivative_formula12_equal"),
                withParent(withParent(IsInstanceOf.instanceOf(android.view.View::class.java))),
                isDisplayed()
            )
        )
        imageView7.check(matches(isDisplayed()))

        val imageView8 = onView(
            allOf(
                withContentDescription("derivative_formula12_answer"),
                withParent(withParent(IsInstanceOf.instanceOf(android.view.View::class.java))),
                isDisplayed()
            )
        )
        imageView8.check(matches(isDisplayed()))

        val imageView9 = onView(
            allOf(
                withContentDescription("derivative_formula12_answer"),
                withParent(withParent(IsInstanceOf.instanceOf(android.view.View::class.java))),
                isDisplayed()
            )
        )
        imageView9.check(matches(isDisplayed()))
    }
}
