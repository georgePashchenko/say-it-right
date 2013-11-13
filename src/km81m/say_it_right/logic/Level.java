package km81m.say_it_right.logic;

import java.io.Serializable;

/**
 * User: alexeydushenin
 * Date: 11/4/13
 * Time: 8:17 PM
 */
public enum Level implements Serializable {
    LOW(0), MEDIUM(1), HARD(2);

    private final int position;

    private Level(int position) {
        this.position = position;
    }

    public static Level getLevelByString(String level) {
        if (level.equalsIgnoreCase("HARD")) {
            return HARD;
        } else if (level.equalsIgnoreCase("MEDIUM")) {
            return MEDIUM;
        } else {
            return LOW;
        }
    }

    public int getPosition() {
        return position;
    }
}
