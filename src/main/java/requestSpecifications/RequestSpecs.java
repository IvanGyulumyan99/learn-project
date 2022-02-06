package requestSpecifications;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RequestSpecs {
    private static final String API_KEY = "2211532a55532b337f02b6559e0c63e4";

    public static RequestSpecification createRequestSpecForCurrentWeatherByCity(String city) {
        return new RequestSpecBuilder()
                .setBaseUri("http://api.weatherstack.com/")
                .setBasePath("/current")
                .addQueryParam("access_key", API_KEY)
                .addQueryParam("query", city)
                .build();
    }
}
