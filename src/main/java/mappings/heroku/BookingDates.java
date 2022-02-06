package mappings.heroku;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public
class BookingDates {
    @JsonProperty("checkin")
    public String checkIn;
    public String checkout;

    public BookingDates() {
    }

    public BookingDates(String checkIn, String checkout) {
        this.checkIn = checkIn;
        this.checkout = checkout;
    }
}