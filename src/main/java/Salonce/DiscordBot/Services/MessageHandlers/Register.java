package Salonce.DiscordBot.Services.MessageHandlers;

import Salonce.DiscordBot.Services.Message;
import Salonce.DiscordBot.Services.Sender;
import Salonce.DiscordBot.Services.MessageHandler;
import Salonce.DiscordBot.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Register implements MessageHandler {

    private final Sender sender;
    private final UserService userService;

    public boolean handle(Message message){
            if (message.getContent().equals(".register")) {
                if (!userService.userExists(message.getId())) {
                    userService.addUser(message.getId());
                    sender.sendMessage(message, "User registered!");
                }
                else
                    sender.sendMessage(message, "You are already registered!");
                return true;
            }
        return false;
        }
}