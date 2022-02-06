import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.http.ContentType;
import mappings.heroku.*;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static helpers.JsonGenerator.generateJsonFromObject;
import static io.restassured.RestAssured.given;

public class RestfulBookerTest {
    String token;

    @Test
    public void auth() throws JsonProcessingException {
        UserPOJO ivan = UserPOJO.builder()
                .username("admin")
                .password("password123")
                .build();

        CreateBooking ivanBooking = new CreateBooking("Ivan", "Gyulumyan", 123, true, new BookingDates("2021-02-01", "2021-02-02"), "no needs");


        token = given()
                .contentType(ContentType.JSON)
                .body(generateJsonFromObject(ivan))
                .when()
                .post("https://restful-booker.herokuapp.com/auth")
                .then()
                .extract().jsonPath().getString("token");

        CreatedBooking createdIvanBooking = given()
                .contentType(ContentType.JSON)
                .body(generateJsonFromObject(ivanBooking))
                .when()
                .post("https://restful-booker.herokuapp.com/booking")
                .then()
                .extract().body().as(CreatedBooking.class);

        CreateBooking ivanChangedBooking = new CreateBooking("Ivan", "Gyulumyan", 0, true, new BookingDates("2021-02-01", "2021-02-02"), "no needs");

//        CreateBooking changedIvanBooking = given()
//                .contentType(ContentType.JSON)
//                .accept(ContentType.JSON)
//                .auth().basic("admin", "password123")
//                .queryParam("id", createdIvanBooking.bookingId)
//                .body(generateJsonFromObject(ivanBooking))
//                .when()
//                .patch("https://restful-booker.herokuapp.com/booking")
//                .then()
//                .extract().body().as(CreateBooking.class);

        given()
                .cookie("token", token)
                .queryParam("id", createdIvanBooking.bookingId)
                .when()
                .delete("https://restful-booker.herokuapp.com/booking")
                .then()
                .statusCode(404);

                String getDeletedIvanBooking = given()
                .contentType(ContentType.JSON)
                .queryParam("id", createdIvanBooking.bookingId)
                .when()
                .get("https://restful-booker.herokuapp.com/booking")
                .then()
                .extract().body().asString();



//
//        List<Bookings> bookingsList = Arrays.asList(given()
//                .contentType(ContentType.JSON)
//                .get("https://restful-booker.herokuapp.com/booking")
//                .then()
//                .extract().body().as(Bookings[].class));


        System.out.println(token);
//        System.out.println(bookingsList);
        System.out.println(createdIvanBooking);
//        System.out.println(changedIvanBooking);
        System.out.println(getDeletedIvanBooking);

    }
}
