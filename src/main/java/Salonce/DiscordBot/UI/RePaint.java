package Salonce.DiscordBot.UI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import Salonce.DiscordBot.Entities.User;
import Salonce.DiscordBot.Services.GameObjects;
import Salonce.DiscordBot.Dtos.Painting;
import Salonce.DiscordBot.Services.Selector;
import Salonce.DiscordBot.Services.Message;
import Salonce.DiscordBot.Services.MessageCreator;
import Salonce.DiscordBot.Services.UserService;

@Component
public class RePaint implements Response {

    @Autowired
    private UserService userService;

    @Autowired
    private Selector selector;

    @Autowired
    private GameObjects gameObjects;

    @Transactional
    public void run(Message message, MessageCreator messageCreator){
        if (message.getContent().equals(".paint")) {
            User user = userService.getUser(message.getId());

            user.getAttributes().increaseDexterity(1L);
            Painting painting = selector.selectRandomFromAList(gameObjects.getPaintingList());
            messageCreator.sendMessage(painting.getText() + "\n\n You sold your painting for 5 coins.");

            user.getResources().addCoins(5L);

        }
    }
}