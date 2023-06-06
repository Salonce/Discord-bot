package saloncey.d4jmmorpg.UI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import saloncey.d4jmmorpg.Services.GameObjects;
import saloncey.d4jmmorpg.Services.Selector;
import saloncey.d4jmmorpg.Services.Message;
import saloncey.d4jmmorpg.Services.MessageCreator;
import saloncey.d4jmmorpg.Services.UserService;
import saloncey.d4jmmorpg.dtos.Book;

@Component
public class ReRead implements Response {

    @Autowired
    private Selector selector;

    @Autowired
    private GameObjects gameObjects;

    @Autowired
    private UserService userService;

    @Transactional
    public void run(Message message, MessageCreator messageCreator){
        if (message.getContent().equals(".library")) {
            userService.getUser(message.getId()).getAttributes().increaseWisdom(1L);
            Book book = selector.selectRandomFromAList(gameObjects.getBookList());
            messageCreator.sendMessage(book.getText());

        }
    }
}