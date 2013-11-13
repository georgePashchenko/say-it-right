package km81m.say_it_right.logic.dao;

import km81m.say_it_right.logic.entities.Settings;

/**
 * User: alexeydushenin
 * Date: 11/13/13
 * Time: 3:46 PM
 */
public interface SettingsDAO {

    String TABLE = "settings_tb";
    String ID = "_id";
    String LEVEL = "settings_level";
    String USER = "settings_user";

    Settings getActiveSettings();
    void setActiveSettings(Settings settings);
}
