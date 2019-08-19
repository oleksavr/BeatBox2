package com.example.beatbox.model;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;





import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.IsAnything.anything;

@RunWith(AndroidJUnit4.class)
public class BeatBoxActivityTest {

   @Rule
    public ActivityTestRule<BeatBoxActivity> mActivityRule =
           new ActivityTestRule<>(BeatBoxActivity.class);

   @Test
    public void showsFirstFileName(){
       onView(withText("45_cj"))
               .check(matches(anything()));
    }


}