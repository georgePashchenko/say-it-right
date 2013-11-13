package km81m.say_it_right.logic.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.*;

/**
 * User: alexeydushenin
 * Date: 11/13/13
 * Time: 3:32 PM
 */
public class DBHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static String DB_PATH = "/data/data/km81m.say-it-right/databases/";
    private static final String DB_NAME = "say_it_right.sql";

    private Context context;
    private SQLiteDatabase db;

    public DBHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
        this.context = context;
        //createDB();
        create();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //importSettings(db);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    /*private void importSettings(SQLiteDatabase db) {
        ContentValues values = new ContentValues();
        values.put(SettingsDAO.LEVEL, "LOW");
        values.put(SettingsDAO.USER, 1);
        db.insert(SettingsDAO.TABLE, null, values);
    }*/

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
        Cursor cursor = null;
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
        }
        //return false;
    }

    public void createDB() {
        getReadableDatabase();
        copyData();
        openDB();
    }

    private void copyData() {
        InputStream myInput = null;
        OutputStream myOutput = null;

        try {
            myInput = context.getAssets().open(DB_NAME);
            String outFileName = DB_PATH + DB_NAME;
            myOutput = new FileOutputStream(outFileName);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = myInput.read(buffer)) > 0) {
                myOutput.write(buffer, 0, length);
            }
            myOutput.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (myOutput != null) {
                    myOutput.close();
                }
                if (myInput != null) {
                    myInput.close();
                }
            } catch (IOException e) {}

        }
    }

    private void openDB() {
        String myPath = DB_PATH + DB_NAME;
        db = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
    }

    @Override
    public synchronized void close() {
        if (db != null) {
            db.close();
        }
        super.close();
    }

    public SQLiteDatabase getDb() {
        return db;
    }
}
