package saloncey.d4jmmorpg.Messages.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import saloncey.d4jmmorpg.Messages.GameObjects.Book;
import saloncey.d4jmmorpg.Messages.GameObjects.GameObjects;
import saloncey.d4jmmorpg.Messages.GameObjects.Painting;
import saloncey.d4jmmorpg.Messages.GameObjects.Selector;
import saloncey.d4jmmorpg.Messages.Message;
import saloncey.d4jmmorpg.Messages.MessageCreator;
import saloncey.d4jmmorpg.Services.AttributesService;

import java.util.List;

@Component
public class ResponsePaint implements Response {

    @Autowired
    private AttributesService attributesService;

    @Autowired
    private Selector selector;

    @Autowired
    private GameObjects gameObjects;

    @Transactional
    public void run(Message message, MessageCreator messageCreator){
        if (message.getContent().equals(".paint")) {
            attributesService.getAttributes(message.getId()).increaseDexterity(1L);
            Painting painting = selector.selectRandomFromAList(gameObjects.getPaintingList());
            messageCreator.sendMessage(painting.getText());
        }
    }
}