package km81m.say_it_right.logic;

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
    public TestBlock getTestBlock(int level);

}
