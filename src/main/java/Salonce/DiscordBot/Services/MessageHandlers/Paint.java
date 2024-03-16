package Salonce.DiscordBot.Services.MessageHandlers;

import Salonce.DiscordBot.Dtos.Painting;
import Salonce.DiscordBot.Entities.User;
import Salonce.DiscordBot.Services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class Paint implements MessageHandler {

    private final Sender sender;
    private final UserService userService;
    private final Selector selector;
    private final GameObjects gameObjects;

    @Transactional
    public boolean handle(Message message){
        if (message.getContent().equals(".paint")) {
            User user = userService.getUser(message.getId());

            user.getAttributes().increaseDexterity(1L);
            Painting painting = selector.selectRandomFromAList(gameObjects.getPaintingList());
            sender.sendMessage(message, painting.getText() + "\n\n You sold your painting for 5 coins.");

            user.getResources().addCoins(5L);

            return true;
        }
        return false;
    }
}