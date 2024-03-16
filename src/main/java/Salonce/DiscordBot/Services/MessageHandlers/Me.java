package Salonce.DiscordBot.Services.MessageHandlers;

import Salonce.DiscordBot.Entities.User;
import Salonce.DiscordBot.Services.Message;
import Salonce.DiscordBot.Services.Sender;
import Salonce.DiscordBot.Services.MessageHandler;
import Salonce.DiscordBot.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Component
public class Me implements MessageHandler {

    private final Sender sender;
    private final UserService userService;

    @Transactional
    public boolean handle(Message message){

        if (message.getContent().equals(".me")) {
            User user = userService.getUser(message.getId());
            sender.sendMessage(message, "Coins: " + user.getResources().getCoins() +
                    "\nPaintings: " + user.getResources().getPaintings() +
                    "\nAP: " + userService.getAp(user) + "/" + userService.MAX_AP +
                    "\nNext AP in: " + userService.getNextApInSec(user) + "s" +
                    "\nAll AP in: " + userService.getApInSec(user) + "s");
            return true;
        }
        return false;

    }
}