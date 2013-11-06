package km81m.say_it_right.logic.dao;

import km81m.say_it_right.logic.Level;
import km81m.say_it_right.logic.TestBlock;

/**
 * User: alexeydushenin
 * Date: 11/2/13
 * Time: 9:45 PM
 */
public interface TestCaseDAO {

    /**
     * Get random n tests from storage
     * @param level test level
     * @return test case
     */
    public TestBlock getTestBlock(Level level);

}
