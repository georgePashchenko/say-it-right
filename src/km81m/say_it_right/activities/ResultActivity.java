package km81m.say_it_right.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import km81m.say_it_right.R;
import km81m.say_it_right.logic.TestResults;

/**
 * User: alexeydushenin
 * Date: 11/12/13
 * Time: 6:11 PM
 */
public class ResultActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        Intent intent = getIntent();
        TestResults testResults = (TestResults) intent.getExtras().get("res");

    }
}
