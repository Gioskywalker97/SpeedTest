package com.teamtreehouse.testingbase;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityUITest<ActivityTestRule> {

    @Rule
    public ActivityTestRule activityTestRule = new ActivityTestRule(MainActivity.class);
}
