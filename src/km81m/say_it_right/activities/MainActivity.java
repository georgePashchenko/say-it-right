package km81m.say_it_right.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import km81m.say_it_right.R;
import km81m.say_it_right.logic.Level;
import km81m.say_it_right.logic.dao.*;
import km81m.say_it_right.logic.entities.Settings;
import km81m.say_it_right.logic.entities.User;

import java.util.List;

public class MainActivity extends Activity {

    private SettingsDAO settingsDAO = SettingsDAOSQLite.INSTANCE;
    private UserDAO userDAO = UserDAOSQLite.INSTANCE;
    private HistoryDAO historyDAO = HistoryDAOSQLite.INSTANCE;

    private List<User> users;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Spinner spinner = (Spinner) findViewById(R.id.settings_level);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.level_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        DBHolder.init(getBaseContext());

        setActiveSettings();
    }


    private void setActiveSettings() {
        Settings settings = settingsDAO.getActiveSettings();
        users = userDAO.getAllUsers();

        Spinner spinner = (Spinner) findViewById(R.id.settings_level);
        spinner.setSelection(settings.getLevel().getPosition());

        Spinner userSpinner = (Spinner) findViewById(R.id.settings_user);
        ArrayAdapter<User> usersAdapter = new ArrayAdapter<User>(this, android.R.layout.simple_spinner_item, users);
        usersAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        userSpinner.setAdapter(usersAdapter);

        int pos = users.indexOf(settings.getActiveUser());
        userSpinner.setSelection(pos);
    }

    public void startTest(View view) {
        Intent intent = new Intent(this, GameActivity.class);
        Spinner userSpinner = (Spinner) findViewById(R.id.settings_user);
        User user = (User) userSpinner.getSelectedItem();
        Spinner spinner = (Spinner) findViewById(R.id.settings_level);
        Level level = Level.getByPos(spinner.getSelectedItemPosition());

        Settings settings = new Settings();
        settings.setActiveUser(user);
        settings.setLevel(level);
        settingsDAO.setActiveSettings(settings);

        intent.putExtra("user", user);
        intent.putExtra("level", level);
        startActivity(intent);
    }

    public void modifyUserData(View view) {
        Intent intent = new Intent(this, UserActivity.class);
        startActivity(intent);
    }

    public void removeUserData(View view) {
        Spinner userSpinner = (Spinner) findViewById(R.id.settings_user);
        User userToDelete = (User) userSpinner.getSelectedItem();
        if (userToDelete.getId() != 1) {
            userDAO.delete(userToDelete);
            historyDAO.clear(userToDelete);
            User defUser = new User();
            defUser.setId(1);
            settingsDAO.updateActiveUser(defUser);
            setActiveSettings();
        }
    }

    public void showHistory(View view) {
        Spinner userSpinner = (Spinner) findViewById(R.id.settings_user);
        User user = (User) userSpinner.getSelectedItem();
        Intent intent = new Intent(this, HistoryActivity.class);
        intent.putExtra("user", user);
        startActivity(intent);
    }
}
