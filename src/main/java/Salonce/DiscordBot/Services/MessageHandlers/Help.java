package Salonce.DiscordBot.Services.MessageHandlers;

import Salonce.DiscordBot.Services.Message;
import Salonce.DiscordBot.Services.Sender;
import Salonce.DiscordBot.Services.MessageHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Component
public class Help implements MessageHandler {

    private final Sender sender;

    @Transactional
    public boolean handle(Message message){
        if (message.getContent().equals(".help")) {
            sender.sendMessage(message, "List of available commands: " +
                    "\n\nGeneral:" +
                    "\n.add" +
                    "\n.help" +
                    "\n\nCharacter management:" +
                    "\n.attributes" +
                    "\n\nInteraction with the world:" +
                    "\n.library" +
                    "\n.paint" +
                    "\n.travel"
                    );
            return true;
        }
        return false;
    }
}