package saloncey.d4jmmorpg.Messages.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import saloncey.d4jmmorpg.Messages.Message;
import saloncey.d4jmmorpg.Messages.MessageCreator;
import saloncey.d4jmmorpg.Messages.Paint.PaintingManager;
import saloncey.d4jmmorpg.Services.AttributesService;

@Component
public class ResponsePaint implements Response {

    @Autowired
    private AttributesService attributesService;

    @Autowired
    private PaintingManager paintingManager;

    @Transactional
    public void run(Message message, MessageCreator messageCreator){
        if (message.getContent().equals(".paint")) {
            attributesService.getAttributes(message.getId()).increaseDexterity(1L);;
            messageCreator.sendMessage(paintingManager.getRandom().getString());
        }
    }
}