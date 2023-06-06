package saloncey.d4jmmorpg.UI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import saloncey.d4jmmorpg.Entities.User;
import saloncey.d4jmmorpg.Services.GameObjects;
import saloncey.d4jmmorpg.dtos.Painting;
import saloncey.d4jmmorpg.Services.Selector;
import saloncey.d4jmmorpg.Services.Message;
import saloncey.d4jmmorpg.Services.MessageCreator;
import saloncey.d4jmmorpg.Services.UserService;

@Component
public class RePaint implements Response {

    @Autowired
    private UserService userService;

    @Autowired
    private Selector selector;

    @Autowired
    private GameObjects gameObjects;

    @Transactional
    public void run(Message message, MessageCreator messageCreator){
        if (message.getContent().equals(".paint")) {
            User user = userService.getUser(message.getId());

            user.getAttributes().increaseDexterity(1L);
            Painting painting = selector.selectRandomFromAList(gameObjects.getPaintingList());
            messageCreator.sendMessage(painting.getText() + "\n\n You sold your painting for 5 coins.");

            user.getResources().addCoins(5L);

        }
    }
}