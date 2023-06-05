package saloncey.d4jmmorpg.Messages.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import saloncey.d4jmmorpg.Entity.Attributes;
import saloncey.d4jmmorpg.Entity.User;
import saloncey.d4jmmorpg.Messages.Message;
import saloncey.d4jmmorpg.Messages.MessageCreator;
import saloncey.d4jmmorpg.Messages.Travel.JourneyManager;
import saloncey.d4jmmorpg.Services.AttributesService;
import saloncey.d4jmmorpg.Services.BelongingService;
import saloncey.d4jmmorpg.Services.UserService;

@Component
public class ResponseTravel implements Response {

    @Autowired
    private UserService userService;

    @Autowired
    private JourneyManager journeyManager;

    @Transactional
    public void run(Message message, MessageCreator messageCreator){
        if (message.getContent().equals(".travel")) {
            User user = userService.getUser(message.getId());
            user.getAttributes().increaseEndurance(1L);
            if (userService.useAp(user, 1))
                messageCreator.sendMessage(journeyManager.getRandom().travel());
            else
                messageCreator.sendMessage("Not enough action points");

        }
    }
}
