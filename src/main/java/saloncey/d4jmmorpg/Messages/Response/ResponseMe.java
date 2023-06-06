package saloncey.d4jmmorpg.Messages.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import saloncey.d4jmmorpg.Entity.User;
import saloncey.d4jmmorpg.Messages.Message;
import saloncey.d4jmmorpg.Messages.MessageCreator;
import saloncey.d4jmmorpg.Services.UserService;

@Component
public class ResponseMe implements Response {



    @Autowired
    private UserService userService;


    @Transactional
    public void run(Message message, MessageCreator messageCreator){

        if (message.getContent().equals(".me")) {
            User user = userService.getUser(message.getId());
            messageCreator.sendMessage("Coins: " + user.getResources().getCoins() +
                    "\nAP: " + userService.getAp(user) + "/" + userService.MAX_AP +
                    "\nNext AP in: " + userService.getNextApInSec(user) + "s" +
                    "\nAll AP in: " + userService.getApInSec(user) + "s");
        }

    }
}