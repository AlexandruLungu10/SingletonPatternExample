import java.util.Date;

public class Reservation {
    private Room room;
    private Date date;
    private int reservationLength;

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getReservationLength() {
        return reservationLength;
    }

    public void setReservationLength(int reservationLength) {
        this.reservationLength = reservationLength;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "room=" + room +
                ", reservationLength=" + reservationLength +
                '}';
    }
}
