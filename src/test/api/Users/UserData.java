package Users;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;


public class UserData {
    private Integer id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;
    @JsonCreator
    public UserData(@JsonProperty("avatar") String avatar,
                    @JsonProperty("last_name") String last_name,
                    @JsonProperty("first_name")String first_name,
                    @JsonProperty("email")String email,
                    @JsonProperty("id")Integer id)
    {
        this.avatar = avatar;
        this.last_name = last_name;
        this.first_name = first_name;
        this.email = email;
        this.id = id;
    }
    @JsonGetter
    public Integer getId() {
        return id;
    }
    @JsonGetter
    public String getEmail() {
        return email;
    }
    @JsonGetter
    public String getFirst_name() {
        return first_name;
    }
    @JsonGetter
    public String getLast_name() {
        return last_name;
    }
    @JsonGetter
    public String getAvatar() {
        return avatar;
    }
}
