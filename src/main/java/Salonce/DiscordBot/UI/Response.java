package Salonce.DiscordBot.UI;

import Salonce.DiscordBot.Services.Message;
import Salonce.DiscordBot.Services.MessageCreator;

public interface Response {
    public abstract void run(Message message, MessageCreator messageCreator);
}
