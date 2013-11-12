package km81m.say_it_right.activities;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import km81m.say_it_right.R;

/**
 * User: alexeydushenin
 * Date: 11/9/13
 * Time: 6:30 PM
 */
public class GameActivity extends FragmentActivity {

    private TestCollectionAdapter testCollectionAdapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);

        testCollectionAdapter = new TestCollectionAdapter(getSupportFragmentManager());

        final ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(testCollectionAdapter);
    }
}
