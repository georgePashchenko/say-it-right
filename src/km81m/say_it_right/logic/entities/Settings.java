package km81m.say_it_right.logic.entities;

import km81m.say_it_right.logic.Level;

/**
 * User: alexeydushenin
 * Date: 11/13/13
 * Time: 3:44 PM
 */
public class Settings {

    private User activeUser;
    private Level level;

    public User getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
}
