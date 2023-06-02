package saloncey.d4jmmorpg.Messages.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import saloncey.d4jmmorpg.Messages.Message;
import saloncey.d4jmmorpg.Messages.MessageCreator;
import saloncey.d4jmmorpg.Services.UserService;

@Component
public class ResponseAdd implements Response {

    @Autowired
    UserService userService;

    public void run(Message message, MessageCreator messageCreator){
            if (message.getContent().equals(".add")) {
                //if (!userService.userExists(message.getId())) {
                    userService.addUser(message.getId());

                    messageCreator.sendMessage("User added!");
                    System.out.println("User added!");
                //}
            }

        }
}