import java.util.Scanner;

class TicketBooking {
    int availableSeats;

    TicketBooking(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    synchronized void bookSeat(int seats) {
        if (seats <= availableSeats) {
            System.out.println(
                Thread.currentThread().getName() +
                " booked " + seats + " seat(s) successfully"
            );
            availableSeats -= seats;
        } else {
            System.out.println(
                Thread.currentThread().getName() +
                " booking failed. Not enough seats"
            );
        }
    }
}

class User1 extends Thread {
    TicketBooking booking;
    int seats;

    User1(TicketBooking booking, int seats) {
        this.booking = booking;
        this.seats = seats;
    }

    public void run() {
        booking.bookSeat(seats);
    }
}

class User2 extends Thread {
    TicketBooking booking;
    int seats;

    User2(TicketBooking booking, int seats) {
        this.booking = booking;
        this.seats = seats;
    }

    public void run() {
        booking.bookSeat(seats);
    }
}

public class Q7TicketBooking {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Available Seats: ");
        int availableSeats = sc.nextInt();

        System.out.print("User1 wants to book: ");
        int seats1 = sc.nextInt();

        System.out.print("User2 wants to book: ");
        int seats2 = sc.nextInt();

        TicketBooking booking = new TicketBooking(availableSeats);

        User1 user1 = new User1(booking, seats1);
        User2 user2 = new User2(booking, seats2);

        user1.setName("User1");
        user2.setName("User2");

        user1.start();
        user1.join();

        user2.start();
        user2.join();

        sc.close();
    }
}