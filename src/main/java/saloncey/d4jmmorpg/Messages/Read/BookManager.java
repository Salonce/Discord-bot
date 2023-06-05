package saloncey.d4jmmorpg.Messages.Read;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class BookManager {

    private Random random = new Random();

    @Autowired(required = false)
    private List<Book> bookList;

    public Book getRandom(){
        int number = random.nextInt(bookList.size());
        return bookList.get(number);
    }
}
