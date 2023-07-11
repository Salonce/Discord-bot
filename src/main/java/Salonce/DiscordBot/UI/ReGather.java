package Salonce.DiscordBot.UI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import Salonce.DiscordBot.Entities.User;
import Salonce.DiscordBot.Services.GameObjects;
import Salonce.DiscordBot.Services.Selector;
import Salonce.DiscordBot.Services.Message;
import Salonce.DiscordBot.Services.MessageCreator;
import Salonce.DiscordBot.Services.UserService;
import Salonce.DiscordBot.Dtos.Food;

@Component
public class ReGather implements Response {

    @Autowired
    private UserService userService;

    @Autowired
    private Selector selector;

    @Autowired
    private GameObjects gameObjects;

    @Transactional
    public void run(Message message, MessageCreator messageCreator){
        if (message.getContent().equals(".gather")) {
            User user = userService.getUser(message.getId());

            Food food = selector.selectRandomFromAList(gameObjects.getFoodList());
            messageCreator.sendMessage(food.getText() + "\n\n +5 coins.");

            user.getResources().addCoins(5L);

        }
    }
}