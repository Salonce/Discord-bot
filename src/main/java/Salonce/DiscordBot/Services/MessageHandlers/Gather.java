package Salonce.DiscordBot.Services.MessageHandlers;

import Salonce.DiscordBot.Dtos.Food;
import Salonce.DiscordBot.Entities.User;
import Salonce.DiscordBot.Services.*;
import Salonce.DiscordBot.Services.MessageHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Component
public class Gather implements MessageHandler {

    private final Sender sender;
    private final UserService userService;
    private final Selector selector;
    private final GameObjects gameObjects;

    @Transactional
    public boolean handle(Message message){
        if (message.getContent().equals(".gather")) {
            User user = userService.getUser(message.getId());

            Food food = selector.selectRandomFromAList(gameObjects.getFoodList());
            sender.sendMessage(message, food.getText() + "\n\n +5 coins.");

            user.getResources().addCoins(5L);
            return true;
        }
        return false;
    }
}