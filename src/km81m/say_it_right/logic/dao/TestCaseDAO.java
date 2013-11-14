package km81m.say_it_right.logic.dao;

import km81m.say_it_right.logic.Level;
import km81m.say_it_right.logic.TestBlock;

/**
 * User: alexeydushenin
 * Date: 11/2/13
 * Time: 9:45 PM
 */
public interface TestCaseDAO {

    String TABLE = "test_tb";
    String ID = "_id";
    String WORD = "test_word";
    String LEVEL = "test_level";
    String RESULT = "test_result";

    /**
     * Get random n tests from storage
     * @param level test level
     * @return test case
     */
    public TestBlock getTestBlock(Level level);

}
