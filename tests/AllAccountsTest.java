import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class AllAccountsTest {
    Customer customer,customer2;
    Provider provider1,provider2;
    Admin admin1,admin2;
    AccountsCreated list;
    @Before
    public void setUp(){
        customer = new Customer("myrto","123","myrto@email.com","Greece","Myrto Gkogkou");
        customer2 = new Customer("robin","456","robin@email.com","Germany","Robin Schulz");
        admin1 = new Admin("gregtsoum","123","gregTsoumakas@email.com","Greece","Gregory Tsoumakas");
        admin2 = new Admin("gmeditsk","456","georgeMeditsk@email.com","Greece","Georgios Meditskos");
        provider1 = new Provider("antoine","griezmann","anto@email.com","France","Antoine Griezmann");
        provider2 = new Provider("lio","messi","lio10@email.com","Argentina","Lionel Messi");
        list = new AccountsCreated();
    }

    @Test
    public void emailIsTakenTest(){

        Admin admin = new Admin("jj","jj","jj","jj","jj");
        assertFalse(list.emailIsTaken(admin));
    }

    @Test
    public void usernameIsTakenTest(){
        Admin admin = new Admin("jj","jj","jj","jj","jj");
        assertFalse(list.usernameIsTaken(admin));
    }


    @Test
    public void accountIsUnapprovedTest(){
        assertTrue(list.accountIsUnapproved(provider1));
        assertTrue(list.accountIsUnapproved(provider2));
        assertTrue(list.accountIsUnapproved(customer));
        assertTrue(list.accountIsUnapproved(customer2));
        assertFalse(list.accountIsUnapproved(admin1));
        assertFalse(list.accountIsUnapproved(admin2));
    }

    @Test
    public void logIntoAccountTest(){
        assertEquals(null,list.logInAccount("myrto","fcb"));
        assertEquals("Myrto Gkogkou",list.logInAccount("itsMyrto","football").getFullName());
        assertEquals("gmeditsk",list.logInAccount("gmeditsk","456").getUsername());
    }

    @Test
    public void getSpecificAccountTest(){
        assertEquals("gregtsoum",list.getSpecificAccount("gregTsoumakas@email.com").getUsername());
    }

}





