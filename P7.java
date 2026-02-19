package MultiThreading;

class TicketBooking {
    private int seatsAvailable = 5;
    public synchronized void bookSeat(String user, int seatsRequested) {

        System.out.println(user + " trying to book " + seatsRequested + " seat(s)");

        if (seatsAvailable >= seatsRequested) {

            System.out.println("Seats available. Booking for " + user+"......");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            seatsAvailable = seatsAvailable - seatsRequested;

            System.out.println("Booking successful for " + user);
            System.out.println("Seats left: " + seatsAvailable);

        } else {
            System.out.println("Not enough seats for " + user);
        }

        System.out.println("-------------------------");
    }
}

class UserThread extends Thread {

    TicketBooking booking;
    String user;
    int seats;

    UserThread(TicketBooking booking, String user, int seats) {
        this.booking = booking;
        this.user = user;
        this.seats = seats;
    }

    public void run() {
        booking.bookSeat(user, seats);
    }
}

public class P7 {
    public static void main(String[] args) {

        TicketBooking booking = new TicketBooking();

        UserThread u1 = new UserThread(booking, "Hitesh", 2);
        UserThread u2 = new UserThread(booking, "Aman", 4);
        UserThread u3 = new UserThread(booking, "Rahul", 2);

        u1.start();
        u2.start();
        u3.start();
    }
}
