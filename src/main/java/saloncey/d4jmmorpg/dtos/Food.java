package saloncey.d4jmmorpg.dtos;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Food {
    private int id;
    private String text;

    public Food() {
        // Default constructor required for Jackson deserialization
    }

    public Food(int id, String text) {
        this.id = id;
        this.text = text;
    }

    @JsonProperty("id")
    public int getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }
}
