package km81m.say_it_right.logic.dao;

import android.content.Context;

import java.util.concurrent.atomic.AtomicReference;

/**
 * User: alexeydushenin
 * Date: 11/13/13
 * Time: 3:35 PM
 */
public class DBHolder {

    private static AtomicReference<DBHelper> dbHelper = new AtomicReference<DBHelper>();

    public static void init(Context context) {
        dbHelper.set(new DBHelper(context));
    }

    public static  DBHelper getDBHelper() {
        return dbHelper.get();
    }

}
