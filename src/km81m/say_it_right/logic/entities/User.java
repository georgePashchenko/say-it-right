package km81m.say_it_right.logic.entities;

/**
 * User: alexeydushenin
 * Date: 11/4/13
 * Time: 8:17 PM
 */
public class User {
    private int id;
    private String name;

    public User() {}

    public User(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
