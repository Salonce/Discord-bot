package saloncey.d4jmmorpg.Messages.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import saloncey.d4jmmorpg.Entity.User;
import saloncey.d4jmmorpg.Messages.GameObjects.Food;
import saloncey.d4jmmorpg.Messages.GameObjects.GameObjects;
import saloncey.d4jmmorpg.Messages.GameObjects.Selector;
import saloncey.d4jmmorpg.Messages.Message;
import saloncey.d4jmmorpg.Messages.MessageCreator;
import saloncey.d4jmmorpg.Services.UserService;

@Component
public class ResponseGather implements Response {

    @Autowired
    private UserService userService;

    @Autowired
    private Selector selector;

    @Autowired
    private GameObjects gameObjects;

    @Transactional
    public void run(Message message, MessageCreator messageCreator){
        if (message.getContent().equals(".gather")) {
            User user = userService.getUser(message.getId());

            Food food = selector.selectRandomFromAList(gameObjects.getFoodList());
            messageCreator.sendMessage(food.getText() + "\n\n +5 coins.");

            user.getResources().addCoins(5L);

        }
    }
}