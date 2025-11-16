package com.example.a412assignment2

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import androidx.test.uiautomator.uiAutomator
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.uiautomator.textAsString

@RunWith(AndroidJUnit4::class)
@SmallTest
class UIAutomatorClass {

    @Test
    fun testStartActivityExplicitly() = uiAutomator {

        //press the home button initially
        device.pressHome()
        device.waitForIdle()

        //click the app icon by app name
        onElement { textAsString() == "412Assignment2" }.click()

        //wait for the app to launch
        waitForAppToBeVisible("com.example.a412assignment2")

        //click the "Start Activity Explicitly" button by using text to find it
        onElement { textAsString() == "Start Activity Explicitly" }.click()

        //wait for the SecondActivity to load
        waitForAppToBeVisible("com.example.a412assignment2")

        //check that at least one mobile software engineering challenge text is visible by searching for it on the second activity
        val challengeFound = onElementOrNull { textAsString()?.contains("Limited battery and performance") == true }

        //check that it worked
        assert(challengeFound != null) { "SecondActivity did not show a mobile software engineering challenge" }
    }
}
