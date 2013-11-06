package km81m.say_it_right.logic.dao;

import junit.framework.TestCase;
import km81m.say_it_right.logic.Level;
import km81m.say_it_right.logic.TestBlock;
import km81m.say_it_right.logic.entities.SingleTest;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

/**
 * User: alexeydushenin
 * Date: 11/3/13
 * Time: 2:41 PM
 */
public class TestCaseDAOTest extends TestCase {

    private final Level LEVEL = Level.MEDIUM;

    @Mock
    private TestCaseDAO testCaseDAO;

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        //todo remove when real class will be implemented
        MockitoAnnotations.initMocks(this);
        TestBlock testBlock = new TestBlock();

        List<SingleTest> tests = new ArrayList<SingleTest>();
        for (int i = 1; i <= 10; i++) {
            SingleTest singleTest = new SingleTest();
            singleTest.setWord("WORD");
            singleTest.setAnswer(1);
            singleTest.setLevel(LEVEL);
            tests.add(singleTest);
        }

        //Some unnoticed, not important change
        testBlock.setLevel(LEVEL);
        testBlock.setSingleTests(tests);

        when(testCaseDAO.getTestBlock(LEVEL)).thenReturn(testBlock);
    }

    public void testGetTestBlock() {
        System.out.println("testGetTestBlock");

        TestBlock testCase = testCaseDAO.getTestBlock(LEVEL);
        assertNotNull(testCase);
        assertEquals(LEVEL, testCase.getLevel());

        List<SingleTest> singleTests = testCase.getSingleTests();
        assertNotNull(singleTests);
        assertEquals(10, singleTests.size());

        for (SingleTest singleTest : singleTests) {
            assertEquals(LEVEL, singleTest.getLevel());
            assertNotNull(singleTest.getWord());

            StringBuilder positionMessage = new StringBuilder();
            positionMessage.append("word : ").append(singleTest.getWord()).append(";");
            positionMessage.append("position: ").append(singleTest.getAnswer());

            assertTrue(positionMessage.toString(), singleTest.getWord().length() > singleTest.getAnswer());
            assertTrue("position must be >= 0", singleTest.getAnswer() >= 0);
        }

    }

}
