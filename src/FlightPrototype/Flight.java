package FlightPrototype;

import CustomExceptionHandling.AvailableSeatException;
import CustomExceptionHandling.NotAvailableSeatException;
import CustomExceptionHandling.SelectValidSeatException;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Flight extends Thread implements FlightInterface{


    public int flightNo;
    public int seatNo;
    public int totalSeats;


    ArrayList<Integer> availableSeats = new ArrayList<Integer>(10);
    ArrayList<Integer> bookedSeats = new ArrayList<Integer>(10);

    public Flight(int flightNo, int totalSeats) {
        this.flightNo = flightNo;
        this.totalSeats = totalSeats;
        for (int i = 0; i < totalSeats; i++) {
            this.availableSeats.add(i+1);
            this.bookedSeats.add(i+1);
        }

    }
    public synchronized void bookSeat(int seatNumber) throws SelectValidSeatException, NotAvailableSeatException, InterruptedException {
//        Thread.sleep(1000);
        if (seatNumber>this.totalSeats || seatNumber<=0 ){
            throw new SelectValidSeatException("please select valid seat !");
        } else if (!availableSeats.contains(seatNumber)) {
            throw new NotAvailableSeatException("this seat is not available, kindly choose another seat !");
        } else{
            this.seatNo=seatNumber;
            availableSeats.remove(availableSeats.indexOf(seatNumber));
            bookedSeats.set(seatNumber-1, 0);
        }
    }

    public synchronized void cancelSeat(int seatNumber) throws InterruptedException {
//        Thread.sleep(1000);
        if (availableSeats.contains(seatNumber)){
            try {
                throw new AvailableSeatException("this seat is already available !");
            } catch (AvailableSeatException e) {
                throw new RuntimeException(e);
            }
        } else if (seatNumber > this.totalSeats || seatNumber <= 0) {
            try {
                throw new SelectValidSeatException("please select valid seat to delete");
            } catch (SelectValidSeatException e) {
                throw new RuntimeException(e);
            }
        }else {
            availableSeats.add(seatNumber);
            Collections.sort(availableSeats);
            bookedSeats.set(seatNumber-1,seatNumber);

        }
    }

    public void showAvailableSeats() {
        System.out.println(availableSeats);
    }

    public void showBookedSeats() {
        System.out.println(bookedSeats);
    }






}
