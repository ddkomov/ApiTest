package Registration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UnSuccessReg {
    private String error;

    @JsonCreator
    public UnSuccessReg(@JsonProperty("error")String error) {
        this.error = error;
    }
    @JsonGetter
    public String getError() {
        return error;
    }
}
