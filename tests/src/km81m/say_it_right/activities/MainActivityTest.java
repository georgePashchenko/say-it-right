package km81m.say_it_right.activities;

import android.test.ActivityInstrumentationTestCase2;
import km81m.say_it_right.activities.MainActivity;

/**
 * This is a simple framework for a test_case of an Application.  See
 * {@link android.test.ApplicationTestCase ApplicationTestCase} for more information on
 * how to write and extend Application tests.
 * <p/>
 * To run this test_case, you can type:
 * adb shell am instrument -w \
 * -e class km81m.say_it_right.activities.MainActivityTest \
 * km81m.say_it_right.tests/android.test_case.InstrumentationTestRunner
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    public MainActivityTest() {
        super("km81m.say_it_right", MainActivity.class);
    }

}
