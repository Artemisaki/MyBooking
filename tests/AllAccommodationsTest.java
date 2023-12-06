import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AllAccommodationsTest {

    AccommodationsCreated list = new AccommodationsCreated();
    Date date;

    @Before
    public void setUp(){
        date = new Date(15,10,2022,23,10,2022);
    }
    @Test
    public void testingTheSearchMethod(){
        assertEquals(0,list.searchForAccommodations(true,true,true,false,false,15,200,"Greece","Kastoria",date).size());
        assertEquals(0,list.searchForAccommodations(true,true,true,false,false,3,10,"Greece","Kastoria",date).size());
    }

    @Test
    public void testingGettingAccommodationsOfAProvider(){
        assertEquals(3,list.getAccommodationsOfAProvider("kygoMusic@email.com").size());
        assertEquals(2,list.getAccommodationsOfAProvider("itsRick@email.com").size());
        assertEquals(0,list.getAccommodationsOfAProvider("itsMyrto@email.com").size());
    }

    @Test
    public void getSpecificAccommodationTest(){
        assertEquals("Chloe",list.getSpecificAccommodation("Chloe","LEOFOROS GOUNARADON").getName());
        assertEquals("Limneon",list.getSpecificAccommodation("Limneon","ETHNIKIS ANTISTASIS").getName());
        assertEquals(null,list.getSpecificAccommodation("Macedonia Palace","LEOFOROS NIKIS"));
    }

}



