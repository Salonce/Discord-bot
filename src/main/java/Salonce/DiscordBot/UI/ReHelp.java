package Salonce.DiscordBot.UI;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import Salonce.DiscordBot.Services.Message;
import Salonce.DiscordBot.Services.MessageCreator;

@Component
public class ReHelp implements Response {

    @Transactional
    public void run(Message message, MessageCreator messageCreator){
        if (message.getContent().equals(".help")) {
            messageCreator.sendMessage("List of available commands: " +
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
        }
    }
}