package km81m.say_it_right.activities;

import android.R;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import km81m.say_it_right.logic.dao.HistoryDAO;
import km81m.say_it_right.logic.dao.HistoryDAOSQLite;
import km81m.say_it_right.logic.entities.History;
import km81m.say_it_right.logic.entities.User;

import java.util.List;

/**
 * User: alexeydushenin
 * Date: 11/9/13
 * Time: 6:30 PM
 */
public class HistoryActivity extends ListActivity {

    private HistoryDAO historyDAO = HistoryDAOSQLite.INSTANCE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        User user = (User) intent.getExtras().get("user");
        List<History> history = historyDAO.getHistoryByUser(user);
        ListAdapter listAdapter = new ArrayAdapter<String>(this, R.layout.simple_list_item_1, prepareHistory(history));
        setListAdapter(listAdapter);
    }

    private String[] prepareHistory(List<History> records) {
        if (records.size() == 0) {
            String[] res = new String[1];
            res[0] = "НЕТ АКТИВНЫХ ЗАПИСЕЙ";
            return res;
        }

        String[] result = new String[records.size()];
        for (int i = 0; i < records.size(); i++) {
            result[i] = records.get(i).toString();
        }
        return result;
    }

}
