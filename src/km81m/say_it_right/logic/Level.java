package km81m.say_it_right.logic;

import java.io.Serializable;

/**
 * User: alexeydushenin
 * Date: 11/4/13
 * Time: 8:17 PM
 */
public enum Level implements Serializable {
    LOW(0, "ЛЕГКИЙ"), MEDIUM(1, "СРЕДНИЙ"), HARD(2, "ТЯЖЕЛЫЙ");

    private final int position;
    private final String name;

    private Level(int position, String name) {
        this.position = position;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public static Level getByPos(int pos) {
        if (pos == 0) {
            return LOW;
        } else if (pos == 1) {
            return MEDIUM;
        } else {
            return HARD;
        }
    }

}
