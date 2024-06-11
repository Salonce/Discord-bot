package Salonce.DiscordBot.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import Salonce.DiscordBot.Dtos.Book;
import Salonce.DiscordBot.Dtos.Food;
import Salonce.DiscordBot.Dtos.Journey;
import Salonce.DiscordBot.Dtos.Painting;

import java.io.IOException;
import java.util.List;

@Component
public class GameObjects {

    @Autowired
    public GameObjects(JsonHandler jsonHandler) throws IOException {
        String jsonBooks = jsonHandler.readJsonFile("/GameObjects/books.json");
        String jsonTravel = jsonHandler.readJsonFile("/GameObjects/travel.json");
        String jsonPaintings = jsonHandler.readJsonFile("/GameObjects/paintings.json");
        String jsonFood = jsonHandler.readJsonFile("/GameObjects/food.json");
        try {
            this.bookList = jsonHandler.deserialize(jsonBooks, Book.class);
            this.journeyList = jsonHandler.deserialize(jsonTravel, Journey.class);
            this.paintingList = jsonHandler.deserialize(jsonPaintings, Painting.class);
            this.foodList = jsonHandler.deserialize(jsonFood, Food.class);

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
