package saloncey.d4jmmorpg.Messages.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import saloncey.d4jmmorpg.Messages.Message;
import saloncey.d4jmmorpg.Messages.MessageCreator;
import saloncey.d4jmmorpg.Messages.Read.Book;
import saloncey.d4jmmorpg.Messages.Read.BookManager;
import saloncey.d4jmmorpg.Services.AttributesService;

@Component
public class ResponseRead implements Response {

    @Autowired
    private BookManager bookManager;

    @Autowired
    private AttributesService attributesService;

    @Transactional
    public void run(Message message, MessageCreator messageCreator){
        if (message.getContent().equals(".library")) {
            Book book = bookManager.getRandom();
            messageCreator.sendMessage(book.read());
            attributesService.getAttributes(message.getId()).increaseWisdom(1L);
        }
    }
}