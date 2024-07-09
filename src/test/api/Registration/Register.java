package Registration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Register {
    private String email;
    private String password;
    @JsonCreator
    public Register(@JsonProperty("email")String email,
                    @JsonProperty("password")String password) {
        this.email = email;
        this.password = password;
    }
    @JsonGetter
    public String getEmail() {
        return email;
    }
    @JsonGetter
    public String getPassword() {
        return password;
    }
}
