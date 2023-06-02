package saloncey.d4jmmorpg.Messages.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import saloncey.d4jmmorpg.Messages.Message;
import saloncey.d4jmmorpg.Messages.MessageCreator;
import saloncey.d4jmmorpg.Services.AttributesService;
import saloncey.d4jmmorpg.Services.InventoryService;

@Component
public class ResponseTravel implements Response {

    @Autowired
    InventoryService inventoryService;

    @Autowired
    AttributesService attributesService;

    @Transactional
    public void run(Message message, MessageCreator messageCreator){
        if (message.getContent().equals(".travel")) {
            attributesService.getAttributes(message.getId()).increaseEndurance(1L);
            messageCreator.sendMessage("You've decided to travel to another city. The journey is long as you walk down the path, cross a bridge untill you're finally there.");
        }
    }
}
