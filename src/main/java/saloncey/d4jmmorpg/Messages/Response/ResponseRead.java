package saloncey.d4jmmorpg.Messages.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import saloncey.d4jmmorpg.Entity.Attributes;
import saloncey.d4jmmorpg.Messages.Message;
import saloncey.d4jmmorpg.Messages.MessageCreator;
import saloncey.d4jmmorpg.Messages.Response.Read.Book;
import saloncey.d4jmmorpg.Messages.Response.Read.BookManager;
import saloncey.d4jmmorpg.Services.AttributesService;

@Component
public class ResponseRead implements Response {

    @Autowired
    BookManager bookManager;

    @Autowired
    AttributesService attributesService;

    @Transactional
    public void run(Message message, MessageCreator messageCreator){
        if (message.getContent().equals(".read")) {
            Book book = bookManager.getRandom();
            messageCreator.sendMessage(book.read());
            attributesService.getAttributes(message.getId()).increaseWisdom(1L);
        }
    }
}