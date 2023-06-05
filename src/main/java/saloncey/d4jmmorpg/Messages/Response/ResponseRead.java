package saloncey.d4jmmorpg.Messages.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import saloncey.d4jmmorpg.Messages.GameObjects.GameObjects;
import saloncey.d4jmmorpg.Messages.GameObjects.Selector;
import saloncey.d4jmmorpg.Messages.Message;
import saloncey.d4jmmorpg.Messages.MessageCreator;
import saloncey.d4jmmorpg.Messages.GameObjects.Book;
import saloncey.d4jmmorpg.Services.AttributesService;

@Component
public class ResponseRead implements Response {

    @Autowired
    private Selector selector;

    @Autowired
    private GameObjects gameObjects;


    @Autowired
    private AttributesService attributesService;

    @Transactional
    public void run(Message message, MessageCreator messageCreator){
        if (message.getContent().equals(".library")) {
            attributesService.getAttributes(message.getId()).increaseWisdom(1L);
            Book book = selector.selectRandomFromAList(gameObjects.getBookList());
            messageCreator.sendMessage(book.getText());

        }
    }
}