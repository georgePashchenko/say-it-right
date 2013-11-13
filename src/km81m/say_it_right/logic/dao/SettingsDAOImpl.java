package km81m.say_it_right.logic.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import km81m.say_it_right.logic.Level;
import km81m.say_it_right.logic.entities.Settings;

/**
 * User: alexeydushenin
 * Date: 11/13/13
 * Time: 3:48 PM
 */
public enum  SettingsDAOImpl implements SettingsDAO {

    INSTANCE;

    private UserDAO userDAO = UserDAOImpl.INSTANCE;

    @Override
    public Settings getActiveSettings() {
        SQLiteDatabase db = DBHolder.getDBHelper().getReadableDatabase();
        String[] projection = {SettingsDAO.ID, SettingsDAO.LEVEL, SettingsDAO.USER};

        Cursor cursor = null;

        Settings settings = new Settings();
        try {
            cursor = db.query(SettingsDAO.TABLE, projection, null, null, null, null, null);
            cursor.moveToFirst();
            int activeUser = cursor.getInt(cursor.getColumnIndex(SettingsDAO.USER));
            settings.setActiveUser(userDAO.getUser(activeUser));
            settings.setLevel(Level.getLevelByString(cursor.getString(cursor.getColumnIndex(SettingsDAO.LEVEL))));
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return settings;
    }

    @Override
    public void setActiveSettings(Settings settings) {

    }

}
