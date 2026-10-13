class TicketBooking {
String passengerName;
String bookingStatus;
TicketBooking(String name) {
passengerName = name;
bookingStatus = "Pending";
}
void displayBookingDetails() {
System.out.println("Passenger Name: " + passengerName);
System.out.println("Booking Status: " + bookingStatus);
System.out.println("Thread Name: "+ Thread.currentThread().getName());
System.out.println("---------------------------");
}
}
class BookingThread extends Thread {
    TicketBooking booking;
    BookingThread(TicketBooking booking, String name) {
        super(name);
        this.booking = booking;
    }
    @Override
    public void run() {
        booking.bookingStatus = "Booked/Confirmed";
        booking.displayBookingDetails();
    }
}
class BookingRunnable implements Runnable {
    TicketBooking booking;

    BookingRunnable(TicketBooking booking) {
        this.booking = booking;
    }

    @Override
    public void run() {
        booking.bookingStatus = "Booked/Confirmed";
        booking.displayBookingDetails();
    }
}
public class RailwayReservation {
    public static void main(String[] args) {
        TicketBooking b1 = new TicketBooking("Rahul");
        TicketBooking b2 = new TicketBooking("Priya");
        TicketBooking b3 = new TicketBooking("Aman");
        TicketBooking b4 = new TicketBooking("Neha");
        BookingThread t1 =
                new BookingThread(b1, "Booking-1");
        BookingThread t2 =
                new BookingThread(b2, "Booking-2");
        BookingRunnable r1 = new BookingRunnable(b3);
        BookingRunnable r2 = new BookingRunnable(b4);
        Thread t3 = new Thread(r1, "Booking-3");
        Thread t4 = new Thread(r2, "Booking-4");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
            Thread.currentThread().interrupt();
            return;
        }
        System.out.println(
            "All passenger booking requests have been processed successfully."
        );
    }
}
