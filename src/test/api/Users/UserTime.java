package Users;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserTime {
    private String name;
    private String job;
    @JsonCreator
    public UserTime(@JsonProperty("name")String name,
                    @JsonProperty("job")String job) {
        this.name = name;
        this.job = job;
    }
    @JsonGetter
    public String getName() {
        return name;
    }
    @JsonGetter
    public String getJob() {
        return job;
    }
}
