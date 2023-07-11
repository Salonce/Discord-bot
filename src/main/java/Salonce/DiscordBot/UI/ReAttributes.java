package Salonce.DiscordBot.UI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import Salonce.DiscordBot.Entities.Attributes;
import Salonce.DiscordBot.Entities.User;
import Salonce.DiscordBot.Services.Message;
import Salonce.DiscordBot.Services.MessageCreator;
import Salonce.DiscordBot.Services.UserService;

@Component
public class ReAttributes implements Response {
    @Autowired
    private UserService userService;

    @Transactional
    public void run(Message message, MessageCreator messageCreator){
        if (message.getContent().equals(".attributes")) {
            User user = userService.getUser(message.getId());
            Attributes attributes = user.getAttributes();
            messageCreator.sendMessage("Endurance: " + attributes.getEndurance()
                    + "\nCharisma: " + attributes.getCharisma()
                    + "\nIntelligence: " + attributes.getIntelligence()
                    + "\nWisdom: " + attributes.getWisdom()
                    + "\nDexterity: " + attributes.getDexterity()
                    + "\nStrength: " + attributes.getStrength());
        }
    }
}
