import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {
    User user;
    User user2;
    Message message;
    @Before
    public void setUp(){
        user = new User("myrto","123","myrto@email.com","Greece","Myrto Gkogkou");
        user2 = new User("robin","456","robin@email.com","Germany","Robin Schulz");
        Message message = new Message("Hello",user2);
    }

    @Test
    public void getUserDetails(){
        assertEquals("myrto",user.getUsername());
        assertEquals("123",user.getPassword());
        assertEquals("myrto@email.com",user.getEmail());
        assertEquals("Greece",user.getCountry());
        assertEquals("Myrto Gkogkou",user.getFullName());
        assertFalse(user.getApproved());
    }


    @Test
    public void changeSetApprove(){
        user.setApproved(true);
        assertTrue(user.getApproved());
    }

    @Test
    public void addMessageTest(){
        user.addMessage(message);
        assertEquals(1,user.getMessages().size());
    }
}
