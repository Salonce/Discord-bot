package Salonce.DiscordBot.UI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import Salonce.DiscordBot.Services.Message;
import Salonce.DiscordBot.Services.MessageCreator;
import Salonce.DiscordBot.Services.UserService;

@Component
public class ReRegister implements Response {

    @Autowired
    private UserService userService;

    public void run(Message message, MessageCreator messageCreator){
            if (message.getContent().equals(".register")) {
                if (!userService.userExists(message.getId())) {
                    userService.addUser(message.getId());
                    messageCreator.sendMessage("User registered!");
                }
                else
                    messageCreator.sendMessage("You are already registered!");
            }
        }
}