package Registration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SuccessReg     {
    private Integer id;
    private String token;
    @JsonCreator
    public SuccessReg(@JsonProperty("id")Integer id,
                      @JsonProperty("token")String token) {
        this.id = id;
        this.token = token;
    }
    @JsonGetter
    public Integer getId() {
        return id;
    }
    @JsonGetter
    public String getToken() {
        return token;
    }
}
