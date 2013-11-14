package km81m.say_it_right.activities;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import km81m.say_it_right.R;
import km81m.say_it_right.logic.Level;
import km81m.say_it_right.logic.TestBlock;
import km81m.say_it_right.logic.TestResults;
import km81m.say_it_right.logic.UserAnswer;
import km81m.say_it_right.logic.dao.TestCaseDAO;
import km81m.say_it_right.logic.dao.TestCaseDAOSQLite;
import km81m.say_it_right.logic.entities.User;

/**
 * User: alexeydushenin
 * Date: 11/9/13
 * Time: 6:30 PM
 */
public class GameActivity extends FragmentActivity {

    private TestCollectionAdapter testCollectionAdapter;
    private ViewPager viewPager;

    private UserAnswer userAnswer;
    private TestBlock testBlock;
    private User user;
    private Level level;

    private TestCaseDAO testCaseDAO = TestCaseDAOSQLite.INSTANCE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);

        Intent intent = getIntent();
        user = (User) intent.getExtras().get("user");
        level = (Level) intent.getExtras().get("level");

        testBlock = testCaseDAO.getTestBlock(level);
        userAnswer = new UserAnswer();

        testCollectionAdapter = new TestCollectionAdapter(getSupportFragmentManager(), userAnswer, testBlock);

        final ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(testCollectionAdapter);
    }

    public void showResult(View view) {
        Intent intent = new Intent(this, ResultActivity.class);
        Bundle args = new Bundle();
        TestResults testResults = new TestResults();
        args.putSerializable("res", testResults);
        intent.putExtras(args);
        startActivity(intent);
    }

}
