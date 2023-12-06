import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DateTest {
    Date date,date1,date2;

    @Before
    public void setUp(){
        date = new Date(15,10,2022,19,10,2022);
        date1 = new Date(18,5,2022,19,5,2022);
        date2 = new Date(31,12,2022,30,10,2022);
    }

    @Test
    public void getDates(){
        assertEquals(15,date.getStartDay());
        assertEquals(10,date.getStartMonth());
        assertEquals(2022,date.getStartYear());
    }

    @Test
    public void nightsBetweenTest(){
        assertEquals(4,date.nightsBetweenDates());
        assertEquals(1,date1.nightsBetweenDates());
    }

    @Test
    public void checkDatesTest(){
        assertTrue(date.checkingTheDates());
        assertTrue(date1.checkingTheDates());
        assertFalse(date2.checkingTheDates());
    }

    @Test
    public void isEqualTest(){
        assertFalse(date.equalDates(date1));
    }
}
