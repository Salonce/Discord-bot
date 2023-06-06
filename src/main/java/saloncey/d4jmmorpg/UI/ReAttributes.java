package saloncey.d4jmmorpg.UI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import saloncey.d4jmmorpg.Entities.Attributes;
import saloncey.d4jmmorpg.Entities.User;
import saloncey.d4jmmorpg.Services.Message;
import saloncey.d4jmmorpg.Services.MessageCreator;
import saloncey.d4jmmorpg.Services.UserService;

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
