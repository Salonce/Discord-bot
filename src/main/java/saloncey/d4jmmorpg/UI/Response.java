package saloncey.d4jmmorpg.UI;

import saloncey.d4jmmorpg.Services.Message;
import saloncey.d4jmmorpg.Services.MessageCreator;

public interface Response {
    public abstract void run(Message message, MessageCreator messageCreator);
}
