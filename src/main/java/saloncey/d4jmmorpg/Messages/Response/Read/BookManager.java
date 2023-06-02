package saloncey.d4jmmorpg.Messages.Response.Read;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class BookManager {

    Random random = new Random();

    @Autowired(required = false)
    List<Book> bookList;

    public Book getRandom(){
        int number = random.nextInt(bookList.size());
        return bookList.get(number);
    }
}
