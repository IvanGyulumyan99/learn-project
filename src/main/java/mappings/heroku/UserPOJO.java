package mappings.heroku;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserPOJO {
    public String username;
    public String password;
}
