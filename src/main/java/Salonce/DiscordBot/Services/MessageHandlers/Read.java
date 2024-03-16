package Salonce.DiscordBot.Services.MessageHandlers;

import Salonce.DiscordBot.Dtos.Book;
import Salonce.DiscordBot.Services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class Read implements MessageHandler {

    private final Sender sender;
    private final Selector selector;
    private final GameObjects gameObjects;
    private final UserService userService;

    @Transactional
    public boolean handle(Message message){
        if (message.getContent().equals(".library")) {
            userService.getUser(message.getId()).getAttributes().increaseWisdom(1L);
            Book book = selector.selectRandomFromAList(gameObjects.getBookList());
            sender.sendMessage(message, book.getText());

            return true;
        }
        return false;
    }
}