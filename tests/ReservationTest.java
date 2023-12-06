import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReservationTest {
    Reservation reservation;
    Customer customer;
    Accommodation accommodation;
    Provider provider;
    Date date;
    Location location;
    Room room;

    @Before
    public void setUp(){
        provider = new Provider("myrto","123","myrto@domain.com","Greece","Myrto Gkogkou");
        customer = new Customer("myrto","123","myrto@email.com","Greece","Myrto Gkogkou");
        location = new Location("Greece","Kastoria","Leoforos Gounaradon","10");
        accommodation = new Accommodation(provider,"Calma","Hotel",true,true,true,true,true,location);
        room = new Room(2,100,"City",2);
        date = new Date(23,10,2022,26,10,2022);
        accommodation.addRoom(room);
        reservation = new Reservation(accommodation,customer,date,1);
    }

    @Test
    public void getDetailsTest(){
        assertEquals("Myrto Gkogkou",reservation.getCustomer().getFullName());
        assertEquals(1,reservation.getRoomNumber());
        assertFalse(reservation.getCancelled());
        assertEquals("Calma",reservation.getAccommodation().getName());
        assertEquals(23,reservation.getDate().getStartDay());
    }

    @Test
    public void changeDetailsTest(){
        reservation.setCancelled(true);
        assertTrue(reservation.getCancelled());
    }
}
