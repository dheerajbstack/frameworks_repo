package com.example.dheeraj.get_user_ip;


import android.Manifest;
import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.rule.GrantPermissionRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.support.test.espresso.IdlingPolicies;


import com.squareup.spoon.Spoon;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.concurrent.TimeUnit;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class WebViewActivityTest {

    @Rule
    public ActivityTestRule<WebViewActivity> webActivityTestRule = new ActivityTestRule<>(WebViewActivity.class);

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Rule public GrantPermissionRule mRuntimePermissionRule = GrantPermissionRule.grant(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE);

    @Test
    public void testWebView() throws Exception {
        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.button), withText("Next Page"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        appCompatButton.perform(click());
        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.button2), withText("WebView"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        Thread.sleep(3000);
        appCompatButton2.perform(click());
        Thread.sleep(2000);
//        WebInteration webInteration = onWebView(
//                allOf(withId(R.id.button2), withText("WebView"),
//                        childAtPosition(
//                                childAtPosition(
//                                        withId(android.R.id.content),
//                                        0),
//                                1),
//                        isDisplayed()));
        Spoon.screenshot(mActivityTestRule.getActivity(), "test_spoon_screenshots");
    }

    @Test
    public void testSpoonScreenshot() throws InterruptedException {
//        Thread.sleep(5000);
        Spoon.screenshot(mActivityTestRule.getActivity(), "test_spoon_screenshots_1");
        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.button), withText("Next Page"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
//        Thread.sleep(5000);
        Spoon.screenshot(webActivityTestRule.getActivity(), "test_spoon_screenshots_2");
        appCompatButton.perform(click());
//        Thread.sleep(2000);
        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.button2), withText("WebView"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
//        Thread.sleep(5000);
        Spoon.screenshot(webActivityTestRule.getActivity(), "test_spoon_screenshots_3");
        appCompatButton2.perform(click());
//        Thread.sleep(2000);
        Spoon.screenshot(webActivityTestRule.getActivity(), "test_spoon_screenshots_42183nas_canscjkashdiuqw_2kjasnjkasnjsdkabfkhsdjbfhksdjbfhjabfhkjfbhsdaflsjdfbldsfbdslhvbsh shlbvdhsbdsvdsjnvsdjlncsjdnlajkdsnlkajc_aljsdkncj");
    }


    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
