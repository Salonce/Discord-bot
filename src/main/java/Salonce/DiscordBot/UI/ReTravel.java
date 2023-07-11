package Salonce.DiscordBot.UI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import Salonce.DiscordBot.Entities.User;
import Salonce.DiscordBot.Services.GameObjects;
import Salonce.DiscordBot.Dtos.Journey;
import Salonce.DiscordBot.Services.Selector;
import Salonce.DiscordBot.Services.Message;
import Salonce.DiscordBot.Services.MessageCreator;
import Salonce.DiscordBot.Services.UserService;

@Component
public class ReTravel implements Response {

    @Autowired
    private UserService userService;

    @Autowired
    private Selector selector;

    @Autowired
    private GameObjects gameObjects;

    @Transactional
    public void run(Message message, MessageCreator messageCreator){
        if (message.getContent().equals(".travel")) {
            User user = userService.getUser(message.getId());
            if (userService.useAp(user, 1)) {
                user.getAttributes().increaseEndurance(1L);
                Journey journey = selector.selectRandomFromAList(gameObjects.getJourneyList());
                messageCreator.sendMessage(journey.getText());
            }
            else
                messageCreator.sendMessage("Not enough action points");

        }
    }
}
