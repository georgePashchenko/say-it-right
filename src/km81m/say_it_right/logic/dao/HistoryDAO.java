package km81m.say_it_right.logic.dao;

import km81m.say_it_right.logic.entities.History;
import km81m.say_it_right.logic.entities.User;

import java.util.List;

/**
 * User: alexeydushenin
 * Date: 11/4/13
 * Time: 8:22 PM
 */
public interface HistoryDAO {

    String TABLE = "history_tb";
    String ID = "_id";
    String DATE = "history_date";
    String LEVEL = "history_level";
    String USER = "history_user";
    String RESULT = "history_result";

    public List<History> getHistoryByUser(User user);
    public void save(History history);
    public void clear(User user);
}
