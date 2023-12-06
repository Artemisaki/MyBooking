import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RoomTest {
    Room room;
    Date date1,date2,date3;

    @Before
    public void setUp(){
        room = new Room(2,40.5,"Sea",2);
        date1 = new Date(1,1,2022,10,1,2022);
        date2 = new Date(15,2,2022,19,2,2022);
        date3 = new Date(5,1,2022,10,1,2022);
    }

    @Test
    public void getCapacityTest(){
        assertEquals(2,room.getCapacity());
    }

    @Test
    public void getPriceTest(){
        assertEquals(40.5,room.getPricePerNight(),0.1);
    }

    @Test
    public void getViewTest(){
        assertEquals("Sea",room.getView());
    }

    @Test
    public void getBedsTest(){
        assertEquals(2,room.getTotalBeds());
    }

    @Test
    public void testSetCapacity(){
        room.setCapacity(1);
        assertEquals(1,room.getCapacity());
    }

    @Test
    public void testSetTotalBeds(){
        room.setTotalBeds(1);
        assertEquals(1,room.getTotalBeds());
    }

    @Test
    public void testSetPrice(){
        room.setPricePerNight(30.1);
        assertEquals(30.1,room.getPricePerNight(),0.1);
    }

    @Test
    public void testAddDates(){
        room.addReservedDates(date1);
        room.addReservedDates(date2);
        assertEquals(false,room.availableDate(date3));
    }


}
