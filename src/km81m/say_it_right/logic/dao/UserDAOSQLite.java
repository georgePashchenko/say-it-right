package km81m.say_it_right.logic.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import km81m.say_it_right.logic.entities.User;

import java.util.ArrayList;
import java.util.List;

/**
 * User: alexeydushenin
 * Date: 11/13/13
 * Time: 3:21 PM
 */
public enum UserDAOSQLite implements UserDAO {

    INSTANCE;

    @Override
    public User save(User user) {
        SQLiteDatabase db = DBHolder.getDBHelper().getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(UserDAO.NAME, user.getName());
        long newRowId = db.insert(UserDAO.TABLE, null, values);
        user.setId((int) newRowId);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> result = new ArrayList<User>();
        SQLiteDatabase db = DBHolder.getDBHelper().getReadableDatabase();
        String[] projection = {UserDAO.ID, UserDAO.NAME};

        Cursor cursor = null;
        try {
            cursor = db.query(UserDAO.TABLE, projection, null, null, null, null, null);
            cursor.moveToFirst();
            do {
                User user = new User();
                user.setId(cursor.getInt(cursor.getColumnIndex(UserDAO.ID)));
                user.setName(cursor.getString(cursor.getColumnIndex(UserDAO.NAME)));
                result.add(user);
            } while (cursor.moveToNext());
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return result;
    }

    @Override
    public void delete(User user) {
        SQLiteDatabase db = DBHolder.getDBHelper().getWritableDatabase();
        String selection = UserDAO.ID + "= ?";
        String[] selectionArgs = {String.valueOf(user.getId())};
        db.delete(UserDAO.TABLE, selection, selectionArgs);
    }

    @Override
    public void clear() {
        SQLiteDatabase db = DBHolder.getDBHelper().getWritableDatabase();
        db.delete(UserDAO.TABLE, null, null);
    }

    @Override
    public User getUser(int id) {
        SQLiteDatabase db = DBHolder.getDBHelper().getReadableDatabase();
        String[] projection = {UserDAO.ID, UserDAO.NAME};
        String selection = UserDAO.ID + "= ?";
        String[] selectionArgs = {String.valueOf(id)};

        Cursor cursor = null;

        User user = new User();
        try {
            cursor = db.query(UserDAO.TABLE, projection, selection, selectionArgs, null, null, null);
            cursor.moveToFirst();
            user.setId(cursor.getInt(cursor.getColumnIndex(UserDAO.ID)));
            user.setName(cursor.getString(cursor.getColumnIndex(UserDAO.NAME)));
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return user;
    }
}
