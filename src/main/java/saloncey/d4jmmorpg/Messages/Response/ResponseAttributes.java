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
            Long charisma = userService.getUser(message.getId()).getAttributes().getCharisma();
            Long endurance = userService.getUser(message.getId()).getAttributes().getEndurance();
            Long userId = userService.getUser(message.getId()).getId();

            messageCreator.sendMessage("Endurance: " + attributes.getEndurance()
                    + "\nCharisma: " + attributes.getCharisma()
                    + "\nIntelligence: " + attributes.getIntelligence()
                    + "\nWisdom: " + attributes.getWisdom()
                    + "\nDexterity: " + attributes.getDexterity()
                    + "\nStrength: " + attributes.getStrength());
        }
        /*
                this.endurance = 1L;
        this.intelligence = 1L;
        this.wisdom = 1L;
        this.strength = 1L;
        this.dexterity = 1L;
        this.charisma = 1L;
         */
    }
}
