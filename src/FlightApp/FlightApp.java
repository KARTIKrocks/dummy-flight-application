package FlightApp;
import CustomExceptionHandling.NotAvailableSeatException;
import CustomExceptionHandling.SelectValidSeatException;
import Flights.AirBus;
import Flights.Boeing;

// DRY
// Do not copy
// proper fn name
// orthogonal code
// avoid similar fn

public class FlightApp {
    public static void main(String[] args) throws SelectValidSeatException, NotAvailableSeatException {

        Boeing f1 = new Boeing(1,10);


        Thread t1 = new Thread(() -> {
            try {
                f1.bookSeat(10);
                f1.cancelSeat(10);
            } catch (SelectValidSeatException | NotAvailableSeatException | InterruptedException e) {
                System.out.println("Exception raised in "+Thread.currentThread().getName());
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                f1.bookSeat(10);
                f1.cancelSeat(10);
            } catch (SelectValidSeatException | NotAvailableSeatException | InterruptedException e) {
                System.out.println("Exception raised in "+Thread.currentThread().getName());
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                f1.bookSeat(10);
                f1.cancelSeat(10);
            } catch (SelectValidSeatException | NotAvailableSeatException | InterruptedException e) {
                System.out.println("Exception raised in "+Thread.currentThread().getName());
            }
        });

        Thread t4 = new Thread(() -> {
            try {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                f1.bookSeat(10);
                f1.cancelSeat(10);
            } catch (SelectValidSeatException | NotAvailableSeatException | InterruptedException e) {
                System.out.println("Exception raised in "+Thread.currentThread().getName());
            }
        });

        t1.setName("Thred1");
        t2.setName("Thred2");
        t3.setName("Thred3");
        t4.setName("Thred4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();










    }
}
