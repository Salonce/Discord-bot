package Salonce.DiscordBot.Services;

import discord4j.core.spec.EmbedCreateSpec;
import org.springframework.stereotype.Component;

@Component
public class Sender {

    public void sendMessage(Message message, EmbedCreateSpec embedMessage) {
        message.getChannel().createMessage(embedMessage).block();
    }

    public void sendMessage(Message message, String text) {
        EmbedCreateSpec embed = EmbedCreateSpec.builder()
                .author(message.getUserName(), null, message.getUserAvatarUrl())
                .title(text)
                .build();
        sendMessage(message, embed);
    }
/*
    public void sendPlainMessage(Message message, String text) {
        EmbedCreateSpec embed = EmbedCreateSpec.builder()
                .addField("\u2800", text, false)
                .build();
        sendMessage(message, embed);
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
    }*/

}
