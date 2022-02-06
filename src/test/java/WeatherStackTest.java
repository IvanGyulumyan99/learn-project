import io.restassured.specification.RequestSpecification;
import mappings.weatherstack.WeatherInfo;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static requestSpecifications.RequestSpecs.createRequestSpecForCurrentWeatherByCity;

public class WeatherStackTest {

    @Test
    public void getWeatherInfoByLocation() {
        RequestSpecification REQ_SPEC_CURRENT_WEATHER_MOSCOW = createRequestSpecForCurrentWeatherByCity("Moscow");
        RequestSpecification REQ_SPEC_CURRENT_WEATHER_KRASNODAR = createRequestSpecForCurrentWeatherByCity("Krasnodar");
        RequestSpecification REQ_SPEC_CURRENT_WEATHER_LA = createRequestSpecForCurrentWeatherByCity("Los Angeles");

        WeatherInfo moscowWeather = given()
                .spec(REQ_SPEC_CURRENT_WEATHER_MOSCOW)
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract().body().as(WeatherInfo.class);

        String response = given()
                .spec(REQ_SPEC_CURRENT_WEATHER_KRASNODAR)
                .when()
                .get()
                .then()
                .assertThat().statusCode(200)
                .extract().body().asPrettyString();

        given()
                .spec(REQ_SPEC_CURRENT_WEATHER_LA)
                .when()
                .get()
                .then()
                .body("location.name", equalTo("Los Angeles"));


        System.out.println(moscowWeather);
        System.out.println(response);
    }
}
