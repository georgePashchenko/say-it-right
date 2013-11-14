package km81m.say_it_right.logic.entities;

import km81m.say_it_right.logic.Level;

import java.text.DateFormat;
import java.util.Date;

/**
 * User: alexeydushenin
 * Date: 11/4/13
 * Time: 8:16 PM
 */
public class History {

    private Date date;
    private Level level;
    private int result;
    private User user;

    public History() {}

    public History(Level level, int result, User user) {
        this.level = level;
        this.result = result;
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return String.format("%10s %10s %10s", DateFormat.getInstance().format(date), level.getName(), result + "б.");
    }
}
