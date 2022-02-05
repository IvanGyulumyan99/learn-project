package mappings;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestPOJO {
    public String type;
    public String query;

    @Override
    public String toString() {
        return "\n type = " + type + "\n query = " + query;
    }
}