package mappings.heroku;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreatedBooking {
    @JsonProperty("bookingid")
    public int bookingId;
    public CreateBooking booking;


    public CreatedBooking(int bookingId, CreateBooking booking) {
        this.bookingId = bookingId;
        this.booking = booking;
    }

    public CreatedBooking() {

    }

    @Override
    public String toString() {
        return "CreatedBooking{" +
                "bookingId=" + bookingId +
                ", booking=" + booking +
                '}';
    }
}
