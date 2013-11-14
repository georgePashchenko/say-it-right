package km81m.say_it_right.logic.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * User: alexeydushenin
 * Date: 11/13/13
 * Time: 3:32 PM
 */
public class DBHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DB_NAME = "say_it_right.sql";

    private Context context;

    public DBHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
        this.context = context;
        create();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void create() {
        boolean isExists = isExists(getReadableDatabase());
        if (!isExists) {
            BufferedReader reader = null;
            SQLiteDatabase db = getWritableDatabase();
            try {
                reader = new BufferedReader(new InputStreamReader(context.getAssets().open(DB_NAME)));
                String sqlQuery;
                while ((sqlQuery = reader.readLine()) != null) {
                    if (sqlQuery.trim().equals("")) {
                        continue;
                    }
                    db.execSQL(sqlQuery);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {}
                }
            }
        }
        System.out.println(isExists);
    }

    private boolean isExists(SQLiteDatabase db) {
        /*Cursor cursor = null;
        try {
            String[] projection = {SettingsDAO.ID, SettingsDAO.LEVEL, SettingsDAO.USER};
            cursor = db.query(SettingsDAO.TABLE, projection, null, null, null, null, null);
            return cursor.getCount() != 0;
        } catch (SQLiteException e) {
            return false;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }*/
        return false;
    }

}
