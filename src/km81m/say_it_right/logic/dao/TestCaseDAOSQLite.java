package km81m.say_it_right.logic.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import km81m.say_it_right.logic.Level;
import km81m.say_it_right.logic.TestBlock;
import km81m.say_it_right.logic.entities.SingleTest;

import java.util.ArrayList;
import java.util.List;

/**
 * User: alexeydushenin
 * Date: 11/14/13
 * Time: 6:26 PM
 */
public enum TestCaseDAOSQLite implements TestCaseDAO {

    INSTANCE;

    @Override
    public TestBlock getTestBlock(Level level) {
        TestBlock result = new TestBlock();

        SQLiteDatabase db = DBHolder.getDBHelper().getReadableDatabase();
        String[] projection = {TestCaseDAO.ID, TestCaseDAO.WORD, TestCaseDAO.RESULT, TestCaseDAO.LEVEL};
        String selection = TestCaseDAO.LEVEL + "= ?";
        String[] selectionArgs = {String.valueOf(level.toString())};

        List<SingleTest> tests = new ArrayList<SingleTest>();

        Cursor cursor = null;
        try {
            cursor = db.query(TestCaseDAO.TABLE, projection, selection, selectionArgs, null, null, null);
            int i = 0;
            if (cursor.moveToFirst()) {
                do {
                    SingleTest singleTest = new SingleTest();
                    singleTest.setLevel(level);
                    singleTest.setWord(cursor.getString(cursor.getColumnIndex(TestCaseDAO.WORD)));
                    singleTest.setAnswer(cursor.getInt(cursor.getColumnIndex(TestCaseDAO.RESULT)));
                    tests.add(singleTest);
                    i++;
                    if (i == 10) {
                        break;
                    }
                } while (cursor.moveToNext());
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }

        result.setLevel(level);
        result.setSingleTests(tests);
        return result;
    }
}
