import org.junit.Test;
import static org.junit.Assert.*;


public class AllReservationsTest {

    ReservationsCreated list = new ReservationsCreated();
    Location location = new Location("France","Paris","Louvre Avenue","123");
    Provider provider = new Provider("mbappe","123456789","kylianFootball@email.com","France","Kylian Mbappe");
    Accommodation accommodation = new Accommodation(provider,"Macedonia Palace","Hotel",true,false,true,true,false,location);
    Customer customer = new Customer("Jordi","1029384756","jordiFCB@email.com","Spain","Jordi Alba");
    Customer customer2 = new Customer("robin","000","robinS@email.com","Germany","Robin Schulz");

    @Test
    public void getNumberOfReservations(){
        assertEquals(0,list.getTheNumberOfReservationsOfAnAccommodation(accommodation));
    }

    @Test
    public void reservationsOfASpecificCustomer(){
        assertEquals(0,list.reservationsOfASpecificCustomer(customer).size());
        assertEquals(3,list.reservationsOfASpecificCustomer(customer2).size());
    }

    @Test
    public void testTheCancelledReservations(){
        assertEquals(0,list.cancelledReservationsOfACustomer(customer).size());
        assertEquals(0,list.cancelledReservationsOfACustomer(customer2).size());
    }

    @Test
    public void testTheCancelledReservationsOfAProvider(){
        assertEquals(0,list.cancelledReservationsForASpecificProvider(provider).size());
    }
}





