package saloncey.d4jmmorpg.Messages.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import saloncey.d4jmmorpg.Messages.Message;
import saloncey.d4jmmorpg.Messages.MessageCreator;
import saloncey.d4jmmorpg.Messages.Response.Paint.Painting;
import saloncey.d4jmmorpg.Messages.Response.Paint.PaintingManager;
import saloncey.d4jmmorpg.Services.AttributesService;

@Component
public class ResponsePaint implements Response {

    @Autowired
    AttributesService attributesService;

    @Autowired
    private PaintingManager paintingManager;

    @Transactional
    public void run(Message message, MessageCreator messageCreator){
        if (message.getContent().equals(".paint")) {
            messageCreator.sendMessage(paintingManager.getRandom().getString());
            //attributesService.increaseDexterity(message.getId(), 1L);
            //messageCreator.sendMessage("You've painted an old castle in a valley. You feel like a real painter now.");
        }
    }
}