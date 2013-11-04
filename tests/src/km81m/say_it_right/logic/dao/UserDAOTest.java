package km81m.say_it_right.logic.dao;

import junit.framework.TestCase;
import km81m.say_it_right.logic.entities.User;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.Set;

import static org.mockito.Mockito.when;

/**
 * User: alexeydushenin
 * Date: 11/4/13
 * Time: 8:26 PM
 */
public class UserDAOTest extends TestCase {

    @Mock
    private UserDAO userDAO;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        //todo remove when implemented
        MockitoAnnotations.initMocks(this);

    }

    public void testSaveUser() {
        System.out.println("testSaveUser");

        //todo remove when implemented
        User mockUser = new User("Taras");
        when(userDAO.getAllUsers()).thenReturn(Collections.singleton(mockUser));

        userDAO.clear();

        User user = new User();
        user.setName("Taras");
        userDAO.save(user);

        Set<User> users = userDAO.getAllUsers();
        assertNotNull(users);
        assertEquals(1, users.size());

        User realUser = users.iterator().next();
        assertNotNull(realUser);
        assertEquals(user.getName(), realUser.getName());
    }

    public void testDeleteUser() {
        System.out.println("testDeleteUser");

        //todo remove when implemented
        User mockUser = new User("Taras");
        when(userDAO.getAllUsers()).thenReturn(Collections.singleton(mockUser)).thenReturn(Collections.<User>emptySet());

        userDAO.clear();

        User user = new User();
        user.setName("Taras");
        userDAO.save(user);

        Set<User> users = userDAO.getAllUsers();
        assertNotNull(users);
        assertEquals(1, users.size());

        userDAO.delete(user);
        users = userDAO.getAllUsers();
        assertNotNull(users);
        assertEquals(0, users.size());
    }

}
