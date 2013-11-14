package km81m.say_it_right.logic.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import km81m.say_it_right.logic.Level;
import km81m.say_it_right.logic.entities.History;
import km81m.say_it_right.logic.entities.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * User: alexeydushenin
 * Date: 11/14/13
 * Time: 5:37 PM
 */
public enum HistoryDAOSQLite implements HistoryDAO {

    INSTANCE;

    @Override
    public List<History> getHistoryByUser(User user) {
        SQLiteDatabase db = DBHolder.getDBHelper().getReadableDatabase();
        String[] projection = {HistoryDAO.ID, HistoryDAO.LEVEL, HistoryDAO.USER, HistoryDAO.DATE, HistoryDAO.RESULT};
        String selection = HistoryDAO.USER + "= ?";
        String[] selectionArgs = {String.valueOf(user.getId())};
        String sortOrder = HistoryDAO.DATE + " DESC";

        List<History> result = new ArrayList<History>();

        Cursor cursor = null;
        try {
            cursor = db.query(HistoryDAO.TABLE, projection, selection, selectionArgs, null, null, sortOrder);
            if (cursor.moveToFirst()) {
                do {
                    History history = new History();
                    history.setUser(user);
                    history.setDate(new Date(cursor.getLong(cursor.getColumnIndex(HistoryDAO.DATE))));
                    history.setLevel(Level.getLevelByString(cursor.getString(cursor.getColumnIndex(HistoryDAO.LEVEL))));
                    history.setResult(cursor.getInt(cursor.getColumnIndex(HistoryDAO.RESULT)));
                    result.add(history);
                } while (cursor.moveToNext());
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }

        return result;
    }

    @Override
    public void save(History history) {
        SQLiteDatabase db = DBHolder.getDBHelper().getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(HistoryDAO.DATE, System.currentTimeMillis());
        values.put(HistoryDAO.LEVEL, history.getLevel().toString());
        values.put(HistoryDAO.USER, history.getUser().getId());
        values.put(HistoryDAO.RESULT, history.getResult());
        db.insert(HistoryDAO.TABLE, null, values);
    }

    @Override
    public void clear(User user) {
        SQLiteDatabase db = DBHolder.getDBHelper().getWritableDatabase();
        String selection = HistoryDAO.USER + "= ?";
        String[] selectionArgs = {String.valueOf(user.getId())};
        db.delete(HistoryDAO.TABLE, selection, selectionArgs);
    }
}
