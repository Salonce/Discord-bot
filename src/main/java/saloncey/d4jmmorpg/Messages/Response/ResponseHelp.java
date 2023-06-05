package saloncey.d4jmmorpg.Messages.Response;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import saloncey.d4jmmorpg.Messages.Message;
import saloncey.d4jmmorpg.Messages.MessageCreator;

@Component
public class ResponseHelp implements Response {

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