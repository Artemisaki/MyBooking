import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class MessageTest {
    Admin admin;
    Admin admin2;
    Message message1;
    Message message2;

    @Before
    public void setUp() {
        admin = new Admin("gregtsoum","123","gregTsoumakas@email.com","Greece","Gregory Tsoumakas");
        admin2 = new Admin("gmeditsk","456","georgeMeditsk@email.com","Greece","Georgios Meditskos");
        message1 = new Message("Hello",admin2);
        message2 = new Message("Hi",admin2);
    }

    @Test
    public void addMessageTest(){
        admin.addMessage(message1);
        admin.addMessage(message2);
        assertEquals(2,admin.getMessages().size());
        assertEquals(0,admin2.getMessages().size());

    }

    @Test
    public void getMessageTest(){
        assertEquals("Hello",message1.getMessage());
        assertEquals("Hi",message2.getMessage());
    }

    @Test
    public void getSenderTest(){
        admin.addMessage(message1);
        admin.addMessage(message2);
        assertEquals("gmeditsk",message1.getSender().getUsername());
        assertEquals("gmeditsk",message2.getSender().getUsername());
    }
}
