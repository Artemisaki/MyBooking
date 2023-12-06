import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;
public class AccommodationTest {

    Location location;
    Provider provider;
    Accommodation accommodation;
    Room room1,room2,room3;

    @Before
    public void setUp(){
        location = new Location("Greece","Kastoria","Leoforos Gounaradon","10");
        provider = new Provider("myrto","123","myrto@domain.com","Greece","Myrto Gkogkou");
        accommodation = new Accommodation(provider,"Calma","Hotel",true,true,true,true,true,location);
        room1 = new Room(2,100,"City",2);
        room2 = new Room(5,300,"Sea",5);
        room3 = new Room(3,150,"Mountain",2);
        accommodation.addRoom(room1);
    }

    @Test
    public void getFacilitiesTest(){
        assertTrue(accommodation.getHasParking());
        assertTrue(accommodation.getHasPool());
        assertTrue(accommodation.getHasRestaurant());
        assertTrue(accommodation.getHasWifi());
        assertTrue(accommodation.getPetsAllowed());
    }

    @Test
    public void getInfo(){
        assertEquals("Calma",accommodation.getName());
        assertEquals("Greece",accommodation.getLocation().getCountry());
        assertEquals("Hotel",accommodation.getType());
    }

    @Test
    public void addRoomsTest(){
        accommodation.addRoom(room2);
        accommodation.addRoom(room3);
        assertEquals(3,accommodation.getNumberOfRooms());
    }

    @Test
    public void getSpecificRoomTest(){
        assertEquals(2,accommodation.getSpecificRoom(0).getCapacity());
    }

    @Test
    public void removeRoomTest(){
        assertEquals(1,accommodation.getNumberOfRooms());
        accommodation.removeRoom(0);
        assertEquals(0,accommodation.getNumberOfRooms());
    }

    @Test
    public void getProvider(){
        assertEquals("Myrto Gkogkou",accommodation.getProvider().getFullName());
    }
}
