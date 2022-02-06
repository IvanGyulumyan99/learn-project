package mappings.heroku;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateBooking {
    public String firstname;
    public String lastname;
    @JsonProperty("totalprice")
    public int totalPrice;
    @JsonProperty("depositpaid")
    public boolean depositPaid;
    @JsonProperty("bookingdates")
    public BookingDates bookingDates;
    @JsonProperty("additionalneeds")
    public String additionalNeeds;

    public CreateBooking(String firstname, String lastname, int totalPrice, boolean depositPaid, BookingDates bookingDates, String additionalNeeds) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalPrice = totalPrice;
        this.depositPaid = depositPaid;
        this.bookingDates = bookingDates;
        this.additionalNeeds = additionalNeeds;
    }

    public CreateBooking() {
    }

    @Override
    public String toString() {
        return "CreateBooking{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", totalPrice=" + totalPrice +
                ", depositPaid=" + depositPaid +
                ", bookingDates=" + bookingDates +
                ", additionalNeeds='" + additionalNeeds + '\'' +
                '}';
    }
}
