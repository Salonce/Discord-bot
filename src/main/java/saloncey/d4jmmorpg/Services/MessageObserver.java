package saloncey.d4jmmorpg.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import saloncey.d4jmmorpg.UI.Response;

import java.util.List;

@Service
public class MessageObserver {

    @Autowired
    private Message message;

    @Autowired
    private MessageCreator messageCreator;

    @Autowired(required = false)
    private List<Response> responses;

    public void setNewMessage(discord4j.core.object.entity.Message message){
        if (this.message.setMessage(message)) {
            messageCreator.setMessageReceived(this.message);
            run();
        }
    }

    private void run(){
        for (Response response : responses)
            response.run(message, messageCreator);
    }

}
