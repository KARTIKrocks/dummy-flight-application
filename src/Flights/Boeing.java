package Flights;

import CustomExceptionHandling.NotAvailableSeatException;
import CustomExceptionHandling.SelectValidSeatException;
import FlightPrototype.Flight;

public class Boeing extends Flight {
    public Boeing(int flightNo, int totalSeats) {
        super(flightNo, totalSeats);
    }

    @Override
    public void bookSeat(int seatNumber) throws SelectValidSeatException, NotAvailableSeatException, InterruptedException {
        super.bookSeat(seatNumber);
        System.out.println("flight is booked by Boeing on Thread - "+ this.getName());
    }

    @Override
    public void cancelSeat(int seatNumber) throws InterruptedException {
        super.cancelSeat(seatNumber);
        System.out.println("canceled by Boeing on thread - " + this.getName());
    }
}
