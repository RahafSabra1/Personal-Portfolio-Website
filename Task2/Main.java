package Task2;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		HotelSystem hotel = new HotelSystem();

        // Add rooms
        hotel.addRoom(new Room(101, "Single", 100));
        hotel.addRoom(new Room(102, "Double", 150));
        hotel.addRoom(new Room(201, "Suite", 300));

        // Simulate user searching and booking
        ArrayList<Room> availableRooms = hotel.searchAvailableRooms("Double");
        if (!availableRooms.isEmpty()) {
            Room selectedRoom = availableRooms.get(0);
            Calendar cal = Calendar.getInstance();
            Date today = cal.getTime();
            cal.add(Calendar.DATE, 2);
            Date twoDaysLater = cal.getTime();

            Reservation res = hotel.makeReservation("John Doe", "Double", today, twoDaysLater);
            if (res != null) {
                hotel.makePayment(res);
                hotel.viewReservationDetails(res.getReservationId());
            } else {
                System.out.println("No available rooms.");
            }
        } else {
            System.out.println("No rooms of this type available.");
        }
	}

}
