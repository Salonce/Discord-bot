package Salonce.DiscordBot.Services.MessageHandlers;

import Salonce.DiscordBot.Services.Message;
import Salonce.DiscordBot.Services.MessageHandler;
import Salonce.DiscordBot.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Order(Ordered.HIGHEST_PRECEDENCE)
@Component
public class FilterBot implements MessageHandler {
    private final Long BOT_ID = 772821811707904022L;

    @Autowired
    private UserService userService;

    @Override
    @Transactional
    public boolean handle(Message message){
        if (message.getId() == BOT_ID) {
            return true;
        }
        return false;
    }
}

