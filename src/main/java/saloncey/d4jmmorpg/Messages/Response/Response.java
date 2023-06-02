package saloncey.d4jmmorpg.Messages.Response;

import saloncey.d4jmmorpg.Messages.Message;
import saloncey.d4jmmorpg.Messages.MessageCreator;

public interface Response {
    public abstract void run(Message message, MessageCreator messageCreator);
}
