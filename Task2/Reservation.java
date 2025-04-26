package Task2;

import java.util.Date;
import java.util.Objects;

public class Reservation {
	private int reservationId;
	private String guestName;
	private Room room;
	private Date checkIn;
	private Date checkOut;
	private double totalAmount;
	private boolean paymentDone;

    Reservation(int reservationId, String guestName, Room room, Date checkIn, Date checkOut, double totalAmount) {
        this.reservationId = reservationId;
        this.guestName = guestName;
        this.room = room;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.totalAmount = totalAmount;
        this.paymentDone = false;
    }

	public int getReservationId() {
		return reservationId;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public boolean isPaymentDone() {
		return paymentDone;
	}

	public void setPaymentDone(boolean paymentDone) {
		this.paymentDone = paymentDone;
	}

	@Override
	public int hashCode() {
		return Objects.hash(reservationId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reservation other = (Reservation) obj;
		return reservationId == other.reservationId;
	}

	@Override
	public String toString() {
		return "Reservation [reservationId=" + reservationId + ", guestName=" + guestName + ", room=" + room
				+ ", checkIn=" + checkIn + ", checkOut=" + checkOut + ", totalAmount=" + totalAmount + ", paymentDone="
				+ paymentDone + "]";
	}
    
}
