import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class LocationTest {
    Location location,location2;

    @Before
    public void setUp() {
        location = new Location("Greece","Kastoria","Leoforos Gounaradon","12");
        location2 = new Location("Greece","Thessaloniki","Konstantinou Karamanli","86");
    }

    @Test
    public void getCountry(){
        assertEquals("Greece",location.getCountry());
        assertEquals("Greece",location2.getCountry());
    }

    @Test
    public void getCity(){
        assertEquals("Kastoria",location.getTown());
        assertEquals("Thessaloniki",location2.getTown());
    }

    @Test
    public void getStreet(){
        assertEquals("Leoforos Gounaradon",location.getStreet());
        assertEquals("Konstantinou Karamanli",location2.getStreet());
    }

    @Test
    public void getStreetNumber(){
        assertEquals("12",location.getStreetNumber());
        assertEquals("86",location2.getStreetNumber());
    }

    @Test
    public void setCountry(){
        location.setCountry("Spain");
        assertEquals("Spain",location.getCountry());
        location2.setCountry("Japan");
        assertEquals("Japan",location2.getCountry());
    }

    @Test
    public void setCity(){
        location.setTown("Barcelona");
        assertEquals("Barcelona",location.getTown());
        location2.setTown("Osaka");
        assertEquals("Osaka",location2.getTown());
    }

    @Test
    public void setStreet(){
        location.setStreet("barcelona avenue");
        assertEquals("barcelona avenue",location.getStreet());
        location2.setStreet("osaka avenue");
        assertEquals("osaka avenue",location2.getStreet());
    }

    @Test
    public void setStreetNumber(){
        location.setNumber("14");
        assertEquals("14",location.getStreetNumber());
        location2.setNumber("19");
        assertEquals("19",location2.getStreetNumber());
    }
}
