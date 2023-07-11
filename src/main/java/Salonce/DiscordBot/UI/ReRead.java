package Salonce.DiscordBot.UI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import Salonce.DiscordBot.Services.GameObjects;
import Salonce.DiscordBot.Services.Selector;
import Salonce.DiscordBot.Services.Message;
import Salonce.DiscordBot.Services.MessageCreator;
import Salonce.DiscordBot.Services.UserService;
import Salonce.DiscordBot.Dtos.Book;

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