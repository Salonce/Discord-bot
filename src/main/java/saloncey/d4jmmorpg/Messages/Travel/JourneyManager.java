package saloncey.d4jmmorpg.Messages.Travel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import saloncey.d4jmmorpg.Messages.Read.Book;

import java.util.List;
import java.util.Random;

@Component
public class JourneyManager {

    private Random random = new Random();

    @Autowired(required = false)
    private List<Journey> journeyList;

    public Journey getRandom(){
        int number = random.nextInt(journeyList.size());
        return journeyList.get(number);
    }
}