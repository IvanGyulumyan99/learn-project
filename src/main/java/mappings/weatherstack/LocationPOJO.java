package mappings.weatherstack;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import lombok.Getter;
import helpers.DateDeserializer;

import java.time.LocalDateTime;

@Data
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationPOJO {
    public String name;
    public String country;
    public String region;
    @JsonProperty("lat")
    public String latitude;
    @JsonProperty("lon")
    public String longitude;
    @JsonProperty("timezone_id")
    public String timezoneId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    @JsonDeserialize(using = DateDeserializer.class)
    public LocalDateTime localtime;

    @Override
    public String toString() {
        return "Name " + name +
                "\n country = " + country +
                "\n region = " + region +
                "\n latitude = " + latitude +
                "\n longitude = " + longitude +
                "\n timezone = " + timezoneId +
                "\n local time = " + localtime;
    }
}