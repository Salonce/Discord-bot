package saloncey.d4jmmorpg.Messages.Response.Paint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class PaintingManager {

    Random random = new Random();

    @Autowired(required = false)
    private List<Painting> paintingList;

    public Painting getRandom(){
        int number = random.nextInt(paintingList.size());
        return paintingList.get(number);
    }
}
