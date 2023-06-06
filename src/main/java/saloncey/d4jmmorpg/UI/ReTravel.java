package saloncey.d4jmmorpg.UI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import saloncey.d4jmmorpg.Entities.User;
import saloncey.d4jmmorpg.Services.GameObjects;
import saloncey.d4jmmorpg.dtos.Journey;
import saloncey.d4jmmorpg.Services.Selector;
import saloncey.d4jmmorpg.Services.Message;
import saloncey.d4jmmorpg.Services.MessageCreator;
import saloncey.d4jmmorpg.Services.UserService;

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
