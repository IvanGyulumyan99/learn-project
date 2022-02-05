package mappings;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherInfo {
    public RequestPOJO request;
    public LocationPOJO location;
    public CurrentPOJO current;

    @Override
    public String toString() {
        return "Location \n" + location +
                "\n Current weather \n" + current;
    }
}



