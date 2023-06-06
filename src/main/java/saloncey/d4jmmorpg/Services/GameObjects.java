package saloncey.d4jmmorpg.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import saloncey.d4jmmorpg.dtos.Book;
import saloncey.d4jmmorpg.dtos.Food;
import saloncey.d4jmmorpg.dtos.Journey;
import saloncey.d4jmmorpg.dtos.Painting;
import saloncey.d4jmmorpg.Services.JsonManipulator;

import java.io.IOException;
import java.util.List;

@Component
public class GameObjects {

    @Autowired
    public GameObjects(JsonManipulator jsonManipulator) throws IOException {
        String jsonBooks = jsonManipulator.readJsonFile("/GameObjects/books.json");
        String jsonTravel = jsonManipulator.readJsonFile("/GameObjects/travel.json");
        String jsonPaintings = jsonManipulator.readJsonFile("/GameObjects/paintings.json");
        String jsonFood = jsonManipulator.readJsonFile("/GameObjects/food.json");
        try {
            this.bookList = jsonManipulator.convert(jsonBooks, Book.class);
            this.journeyList = jsonManipulator.convert(jsonTravel, Journey.class);
            this.paintingList = jsonManipulator.convert(jsonPaintings, Painting.class);
            this.foodList = jsonManipulator.convert(jsonFood, Food.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Food> foodList;
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

    public List<Food> getFoodList() {
        return foodList;
    }

}
