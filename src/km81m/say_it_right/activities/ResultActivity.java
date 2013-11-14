package km81m.say_it_right.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import km81m.say_it_right.R;
import km81m.say_it_right.logic.Level;
import km81m.say_it_right.logic.TestResults;
import km81m.say_it_right.logic.dao.HistoryDAO;
import km81m.say_it_right.logic.dao.HistoryDAOSQLite;
import km81m.say_it_right.logic.entities.History;
import km81m.say_it_right.logic.entities.User;

/**
 * User: alexeydushenin
 * Date: 11/12/13
 * Time: 6:11 PM
 */
public class ResultActivity extends Activity {

    private HistoryDAO historyDAO = HistoryDAOSQLite.INSTANCE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        Intent intent = getIntent();
        TestResults testResults = (TestResults) intent.getExtras().get("res");
        User user = (User) intent.getExtras().get("user");
        Level level = (Level) intent.getExtras().get("level");

        History history = new History();
        history.setUser(user);
        history.setLevel(level);
        history.setResult(testResults.getCorrectAnswers());

        historyDAO.save(history);

        TextView textView = (TextView) findViewById(R.id.result_user_value);
        textView.setText(user.getName());

        textView = (TextView) findViewById(R.id.result_level_value);
        textView.setText(level.getName());

        textView = (TextView) findViewById(R.id.result_correct_value);
        textView.setText(testResults.getCorrectAnswers() + "/10");
    }

    public void toMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}
