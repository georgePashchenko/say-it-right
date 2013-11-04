package km81m.say_it_right.logic.dao;

import junit.framework.TestCase;
import km81m.say_it_right.logic.Level;
import km81m.say_it_right.logic.entities.History;
import km81m.say_it_right.logic.entities.User;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * User: alexeydushenin
 * Date: 11/4/13
 * Time: 8:26 PM
 */
public class HistoryDAOTest extends TestCase {

    @Mock
    private HistoryDAO historyDAO;

    @Mock
    private UserDAO userDAO;

    @Override
    public void setUp() throws Exception {
        super.setUp();

        //todo remove when implemented
        MockitoAnnotations.initMocks(this);
    }

    public void testSaveHistory() {
        System.out.println("testSaveHistory");

        List<History> expectedHistory = new ArrayList<History>();

        //todo remove when implemented
        when(historyDAO.getHistoryByUser(any(User.class))).thenReturn(Collections.EMPTY_LIST).thenReturn(expectedHistory);

        userDAO.clear();

        User user = new User("Taras");
        userDAO.save(user);

        historyDAO.clear(user);

        List<History> history = historyDAO.getHistoryByUser(user);
        assertNotNull(history);
        assertEquals(0, history.size());

        History historyRecord = new History(Level.LOW, 5, user);
        historyDAO.save(historyRecord);
        expectedHistory.add(0, historyRecord);

        historyRecord = new History(Level.HARD, 6, user);
        historyDAO.save(historyRecord);
        expectedHistory.add(0, historyRecord);

        historyRecord = new History(Level.MEDIUM, 7, user);
        historyDAO.save(historyRecord);
        expectedHistory.add(0, historyRecord);

        //todo remove when implemented
        long ts = Long.MAX_VALUE - 1;
        for (History hist : expectedHistory) {
            hist.setDate(new Date(ts--));
        }

        history = historyDAO.getHistoryByUser(user);
        assertNotNull(history);
        assertEquals(3, history.size());

        ts = Long.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            History expected = expectedHistory.get(i);
            History real = history.get(i);
            assertEquals(expected.getUser().getId(), real.getUser().getId());
            assertEquals(expected.getLevel(), real.getLevel());
            assertEquals(expected.getResult(), real.getResult());

            assertTrue("must be sorted by time desc", ts > real.getDate().getTime());
            ts = real.getDate().getTime();
        }

    }

    public void testTwoUsers() {
        System.out.println("testTwoUsers");

        userDAO.clear();

        User user1 = new User("Taras");
        User user2 = new User("Ivan");

        userDAO.save(user1);
        userDAO.save(user2);

        historyDAO.clear(user1);
        historyDAO.clear(user2);

        History historyRec1 = new History(Level.LOW, 6, user1);
        historyDAO.save(historyRec1);

        History historyRec2 = new History(Level.MEDIUM, 7, user2);
        historyDAO.save(historyRec2);

        //todo remove when implemented
        when(historyDAO.getHistoryByUser(any(User.class))).thenReturn(Collections.singletonList(historyRec1)).
                                                           thenReturn(Collections.singletonList(historyRec2));

        List<History> historyReal = historyDAO.getHistoryByUser(user1);
        assertNotNull(historyReal);
        assertEquals(1, historyReal.size());
        assertEquals(historyRec1.getUser().getId(), historyReal.get(0).getUser().getId());

        historyReal = historyDAO.getHistoryByUser(user2);
        assertNotNull(historyReal);
        assertEquals(1, historyReal.size());
        assertEquals(historyRec2.getUser().getId(), historyReal.get(0).getUser().getId());
    }

    public void testGetHistory() {
        System.out.println("testGetHistory");

        //todo remove when implemented
        when(historyDAO.getHistoryByUser(any(User.class))).thenReturn(Collections.singletonList(new History()))
                                                          .thenReturn(Collections.<History>emptyList());

        userDAO.clear();
        User user = new User("Taras");
        userDAO.save(user);

        historyDAO.clear(user);

        History history = new History(Level.MEDIUM, 9, user);
        historyDAO.save(history);
        List<History> historyReal = historyDAO.getHistoryByUser(user);
        assertNotNull(historyReal);
        assertEquals(1, historyReal.size());

        historyDAO.clear(user);
        historyReal = historyDAO.getHistoryByUser(user);
        assertNotNull(historyReal);
        assertEquals(0, historyReal.size());
    }

}
