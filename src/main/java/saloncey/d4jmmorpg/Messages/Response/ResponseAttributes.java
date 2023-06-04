package saloncey.d4jmmorpg.Messages.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import saloncey.d4jmmorpg.Entity.Attributes;
import saloncey.d4jmmorpg.Messages.Message;
import saloncey.d4jmmorpg.Messages.MessageCreator;
import saloncey.d4jmmorpg.Services.UserService;

@Component
public class ResponseAttributes implements Response {
    @Autowired
    UserService userService;

    @Transactional
    public void run(Message message, MessageCreator messageCreator){
        if (message.getContent().equals(".attributes")) {

            Attributes attributes = userService.getUser(message.getId()).getAttributes();

            messageCreator.sendMessage("Endurance: " + attributes.getEndurance()
                    + "\nCharisma: " + attributes.getCharisma()
                    + "\nIntelligence: " + attributes.getIntelligence()
                    + "\nWisdom: " + attributes.getWisdom()
                    + "\nDexterity: " + attributes.getDexterity()
                    + "\nStrength: " + attributes.getStrength());
        }
    }
}
