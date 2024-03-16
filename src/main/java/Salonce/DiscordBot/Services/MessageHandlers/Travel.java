package Salonce.DiscordBot.Services.MessageHandlers;

import Salonce.DiscordBot.Dtos.Journey;
import Salonce.DiscordBot.Entities.User;
import Salonce.DiscordBot.Services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class Travel implements MessageHandler {

    private final Sender sender;
    private final UserService userService;
    private final Selector selector;
    private final GameObjects gameObjects;

    @Transactional
    public boolean handle(Message message){
        if (message.getContent().equals(".travel")) {
            User user = userService.getUser(message.getId());
            if (userService.useAp(user, 1)) {
                user.getAttributes().increaseEndurance(1L);
                Journey journey = selector.selectRandomFromAList(gameObjects.getJourneyList());
                sender.sendMessage(message, journey.getText());
            }
            else
                sender.sendMessage(message, "Not enough action points");

            return true;
        }
        return false;
    }
}
