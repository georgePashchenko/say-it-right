package km81m.say_it_right.activities;

import android.R;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

/**
 * User: alexeydushenin
 * Date: 11/9/13
 * Time: 6:30 PM
 */
public class HistoryActivity extends ListActivity {

    private String[] data = {
                                "18.10.2013     Средний       5б.",
                                "17.10.2013     Легкий        10б."
                            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListAdapter listAdapter = new ArrayAdapter<String>(this, R.layout.simple_list_item_1, data);
        setListAdapter(listAdapter);
    }

}
