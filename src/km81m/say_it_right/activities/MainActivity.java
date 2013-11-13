package km81m.say_it_right.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import km81m.say_it_right.R;
import km81m.say_it_right.logic.dao.*;
import km81m.say_it_right.logic.entities.Settings;
import km81m.say_it_right.logic.entities.User;

import java.util.List;

public class MainActivity extends Activity {

    private SettingsDAO settingsDAO = SettingsDAOImpl.INSTANCE;
    private UserDAO userDAO = UserDAOImpl.INSTANCE;

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

        Settings settings = settingsDAO.getActiveSettings();
        users = userDAO.getAllUsers();

        spinner.setSelection(settings.getLevel().getPosition());

        Spinner userSpinner = (Spinner) findViewById(R.id.settings_user);
        ArrayAdapter<User> usersAdapter = new ArrayAdapter<User>(this, android.R.layout.simple_spinner_item, users);
        usersAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        userSpinner.setAdapter(usersAdapter);
    }

    public void startTest(View view) {
        Intent intent = new Intent(this, GameActivity.class);
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
        }
    }

    public void showHistory(View view) {
        Intent intent = new Intent(this, HistoryActivity.class);
        startActivity(intent);
    }

}
