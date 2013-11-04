package km81m.say_it_right.logic.dao;

import km81m.say_it_right.logic.entities.User;

import java.util.Set;

/**
 * User: alexeydushenin
 * Date: 11/4/13
 * Time: 8:24 PM
 */
public interface UserDAO {
    public void save(User user);
    public Set<User> getAllUsers();
    public void delete(User user);
    public void clear();
}
