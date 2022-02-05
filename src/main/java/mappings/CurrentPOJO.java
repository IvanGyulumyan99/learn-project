package mappings;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentPOJO {
    public int temperature;
    @JsonProperty("wind_speed")
    public int windSpeed;
    @JsonProperty("wind_dir")
    public String windDirection;
    public int pressure;
    @JsonProperty("feelslike")
    public int feelsLike;
    @JsonProperty("uv_index")
    public int uvIndex;
    public int visibility;

    @Override
    public String toString() {
        return "\n temperature = " + temperature +
                "\n wind speed = " + windSpeed +
                "\n wind direction = " + windDirection +
                "\n pressure = " + pressure +
                "\n feels like = " + feelsLike +
                "\n UV index = " + uvIndex +
                "\n visibility = " + visibility;

    }
}