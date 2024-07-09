package Users;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserTimeResponse extends UserTime{
    private String createdAt;
    private Integer id;
    @JsonCreator
    public UserTimeResponse(@JsonProperty("name") String name,
                            @JsonProperty("job")String job,
                            @JsonProperty("createdAt") String createdAt,
                            @JsonProperty("id") Integer id){
        super(name, job);
        this.createdAt = createdAt;
        this.id= id;
    }
    @JsonGetter
    public String getcreatedAt() {
        return createdAt;
    }
    @JsonGetter
    public Integer getId()  {
        return id;
    }
}
