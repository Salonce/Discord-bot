package saloncey.d4jmmorpg.UI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import saloncey.d4jmmorpg.Entities.User;
import saloncey.d4jmmorpg.Services.GameObjects;
import saloncey.d4jmmorpg.Services.Selector;
import saloncey.d4jmmorpg.Services.Message;
import saloncey.d4jmmorpg.Services.MessageCreator;
import saloncey.d4jmmorpg.Services.UserService;
import saloncey.d4jmmorpg.dtos.Food;

@Component
public class ReGather implements Response {

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