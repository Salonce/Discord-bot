package Salonce.DiscordBot.UI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import Salonce.DiscordBot.Entities.User;
import Salonce.DiscordBot.Services.Message;
import Salonce.DiscordBot.Services.MessageCreator;
import Salonce.DiscordBot.Services.UserService;

@Component
public class ReMe implements Response {

    @Autowired
    private UserService userService;

    @Transactional
    public void run(Message message, MessageCreator messageCreator){

        if (message.getContent().equals(".me")) {
            User user = userService.getUser(message.getId());
            messageCreator.sendMessage("Coins: " + user.getResources().getCoins() +
                    "\nPaintings: " + user.getResources().getPaintings() +
                    "\nAP: " + userService.getAp(user) + "/" + userService.MAX_AP +
                    "\nNext AP in: " + userService.getNextApInSec(user) + "s" +
                    "\nAll AP in: " + userService.getApInSec(user) + "s");
        }

    }
}