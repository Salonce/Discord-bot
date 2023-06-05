package saloncey.d4jmmorpg.Messages.GameObjects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import saloncey.d4jmmorpg.Messages.GameObjects.Json.JsonConverter;
import saloncey.d4jmmorpg.Messages.GameObjects.Json.JsonReader;

import java.io.IOException;
import java.util.List;

@Component
public class GameObjects {

    @Autowired
    public GameObjects(JsonReader jsonReader, JsonConverter jsonConverter) throws IOException {
        String jsonBooks = jsonReader.readJsonFile("/GameObjects/books.json");
        String jsonTravel = jsonReader.readJsonFile("/GameObjects/travel.json");
        String jsonPaintings = jsonReader.readJsonFile("/GameObjects/paintings.json");
        try {
            this.bookList = jsonConverter.convert(jsonTravel, Book.class);
            this.journeyList = jsonConverter.convert(jsonTravel, Journey.class);
            this.paintingList = jsonConverter.convert(jsonTravel, Painting.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Journey> journeyList;
    private List<Book> bookList;
    private List<Painting> paintingList;

    public List<Journey> getJourneyList() {
        return journeyList;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public List<Painting> getPaintingList() {
        return paintingList;
    }
}
