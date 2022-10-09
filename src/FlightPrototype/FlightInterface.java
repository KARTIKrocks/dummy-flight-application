package FlightPrototype;

import CustomExceptionHandling.NotAvailableSeatException;
import CustomExceptionHandling.SelectValidSeatException;

public interface FlightInterface {
    void bookSeat(int seatNumber) throws SelectValidSeatException, NotAvailableSeatException, InterruptedException;
    void cancelSeat(int seatNumber) throws InterruptedException;
}
