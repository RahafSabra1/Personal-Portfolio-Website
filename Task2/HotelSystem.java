package Task2;

import java.util.Date;
import java.util.ArrayList;

public class HotelSystem {
	ArrayList<Room> rooms = new ArrayList<>();
    ArrayList<Reservation> reservations = new ArrayList<>();
    int nextReservationId = 1;

    void addRoom(Room room) {
        rooms.add(room);
    }

    ArrayList<Room> searchAvailableRooms(String type) {
        ArrayList<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (room.isAvailable() && room.getType().equalsIgnoreCase(type)) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    Reservation makeReservation(String guestName, String type, Date checkIn, Date checkOut) {
        for (Room room : rooms) {
            if (room.isAvailable() && room.getType().equalsIgnoreCase(type)) {
                room.setAvailable(false);
                double totalAmount = room.getPrice() * calculateDays(checkIn, checkOut);
                Reservation reservation = new Reservation(nextReservationId++, guestName, room, checkIn, checkOut, totalAmount);
                reservations.add(reservation);
                return reservation;
            }
        }
        return null;
    }

    void makePayment(Reservation reservation) {
        reservation.setPaymentDone(true);
        System.out.println("Payment successful for reservation ID: " + reservation.getReservationId());
    }

    void viewReservationDetails(int reservationId) {
        for (Reservation res : reservations) {
            if (res.getReservationId() == reservationId) {
                System.out.println("Guest: " + res.getGuestName());
                System.out.println("Room: " + res.getRoom().getType());
                System.out.println("Check-in: " + res.getCheckIn());
                System.out.println("Check-out: " + res.getCheckOut());
                System.out.println("Total Amount: $" + res.getTotalAmount());
                System.out.println("Payment Status: " + (res.isPaymentDone() ? "Paid" : "Pending"));
                return;
            }
        }
        System.out.println("Reservation not found.");
    }

    long calculateDays(Date checkIn, Date checkOut) {
        long diff = checkOut.getTime() - checkIn.getTime();
        return (diff / (1000 * 60 * 60 * 24));
    }
}
