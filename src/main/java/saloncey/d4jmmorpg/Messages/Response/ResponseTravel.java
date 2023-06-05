package saloncey.d4jmmorpg.Messages.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import saloncey.d4jmmorpg.Entity.User;
import saloncey.d4jmmorpg.Messages.GameObjects.GameObjects;
import saloncey.d4jmmorpg.Messages.GameObjects.Journey;
import saloncey.d4jmmorpg.Messages.GameObjects.Selector;
import saloncey.d4jmmorpg.Messages.Message;
import saloncey.d4jmmorpg.Messages.MessageCreator;
import saloncey.d4jmmorpg.Services.UserService;

@Component
public class ResponseTravel implements Response {

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
            user.getAttributes().increaseEndurance(1L);
            if (userService.useAp(user, 1)) {
                Journey journey = selector.selectRandomFromAList(gameObjects.getJourneyList());
                messageCreator.sendMessage(journey.getText());
            }
            else
                messageCreator.sendMessage("Not enough action points");

        }
    }
}
