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
public class Attributes implements MessageHandler {

    private final Sender sender;
    private final UserService userService;

    @Override
    @Transactional
    public boolean handle(Message message){
        if (message.getContent().equals(".attributes")) {
            User user = userService.getUser(message.getId());
            Salonce.DiscordBot.Entities.Attributes attributes = user.getAttributes();
            sender.sendMessage(message, "Endurance: " + attributes.getEndurance()
                    + "\nCharisma: " + attributes.getCharisma()
                    + "\nIntelligence: " + attributes.getIntelligence()
                    + "\nWisdom: " + attributes.getWisdom()
                    + "\nDexterity: " + attributes.getDexterity()
                    + "\nStrength: " + attributes.getStrength());
            return true;
        }
        return false;
    }
}
