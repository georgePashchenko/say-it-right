package km81m.say_it_right.logic;

import km81m.say_it_right.logic.entities.SingleTest;

import java.util.ArrayList;
import java.util.List;

/**
 * User: alexeydushenin
 * Date: 11/2/13
 * Time: 9:45 PM
 * Case for 10 specific level singleTests
 */
public class TestBlock {

    private List<SingleTest> singleTests = new ArrayList<SingleTest>();
    private int level;

    public List<SingleTest> getSingleTests() {
        return singleTests;
    }

    public void setSingleTests(List<SingleTest> singleTests) {
        this.singleTests = singleTests;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
