package saloncey.d4jmmorpg.Messages;

import discord4j.core.spec.EmbedCreateSpec;
import org.springframework.stereotype.Component;

@Component
public class MessageCreator{

    public Message getMessageReceived() {
        return message;
    }

    public void setMessageReceived(Message message) {
        this.message = message;
    }

    private Message message;


    public void sendMessage(EmbedCreateSpec embedMessage) {
        message.getChannel().createMessage(embedMessage).block();
    }

    public void sendMessage(String message) {
        EmbedCreateSpec embed = EmbedCreateSpec.builder()
                .author(this.message.getUserName(), null, this.message.getUserAvatarUrl())
                .title(message)
                .build();
        sendMessage(embed);
    }

    public void sendPlainMessage(String message) {
        EmbedCreateSpec embed = EmbedCreateSpec.builder()
                .addField("\u2800", message, false)
                .build();
        sendMessage(embed);
    }

    public String addSpaces(String string, int maxWidth) {
        StringBuilder stringBuilder = new StringBuilder(string);
        while (stringBuilder.length() < maxWidth) {
            stringBuilder.append("\u2800");
        }
        return stringBuilder.toString();
    }

    public String emptySpaces(int number) {
        StringBuilder stringBuilder = new StringBuilder();
        while (stringBuilder.length() < number) {
            stringBuilder.append("\u2800");
        }
        return stringBuilder.toString();
    }

}
