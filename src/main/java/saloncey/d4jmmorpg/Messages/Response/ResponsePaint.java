package saloncey.d4jmmorpg.Messages.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import saloncey.d4jmmorpg.Entity.User;
import saloncey.d4jmmorpg.Messages.GameObjects.GameObjects;
import saloncey.d4jmmorpg.Messages.GameObjects.Painting;
import saloncey.d4jmmorpg.Messages.GameObjects.Selector;
import saloncey.d4jmmorpg.Messages.Message;
import saloncey.d4jmmorpg.Messages.MessageCreator;
import saloncey.d4jmmorpg.Services.UserService;

@Component
public class ResponsePaint implements Response {

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

            user.addCoins(5L);

        }
    }
}