package Colors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ColorsData {
    public Integer id;
    public String name;
    public Integer year;
    public String color;
    public String pantone_value;
    @JsonCreator
    public ColorsData(@JsonProperty("id")Integer id,
                      @JsonProperty("name")String name,
                      @JsonProperty("year")Integer year,
                      @JsonProperty("color")String color,
                      @JsonProperty("pantone_value")String pantone_value) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.color = color;
        this.pantone_value = pantone_value;
    }
    @JsonGetter
    public Integer getId() {
        return id;
    }
    @JsonGetter
    public String getName() {
        return name;
    }
    @JsonGetter
    public Integer getYear() {
        return year;
    }
    @JsonGetter
    public String getColor() {
        return color;
    }
    @JsonGetter
    public String getPantone_value() {
        return pantone_value;
    }
}
