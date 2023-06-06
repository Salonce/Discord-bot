package saloncey.d4jmmorpg.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Painting {
    private int id;
    private String title;
    private String text;

    public Painting() {
        // Default constructor required for Jackson deserialization
    }

    public Painting(int id, String title, String text) {
        this.id = id;
        this.title = title;
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

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
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