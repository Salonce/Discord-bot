package Salonce.DiscordBot.Services;

import discord4j.core.object.entity.channel.MessageChannel;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class Message {
    private final Long BOT_ID = 772821811707904022L;

    public boolean setMessage(discord4j.core.object.entity.Message message) {
        boolean validMessage = false;

        try {
            this.id = message.getAuthor().get().getId().asLong();
            this.content = message.getContent();
            this.channel = message.getChannel().block();
            this.userName = message.getAuthor().get().getUsername();
            this.userNameId = "<@" + message.getAuthor().get().getId().asString() + ">";
            this.userAvatarUrl = message.getAuthor().get().getAvatarUrl();

            if (!id.equals(BOT_ID)) {
                validMessage = true;
            }

        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("invalid message");
        }
        finally {
            return validMessage;}
    }

    private Long id;
    private String content;
    private MessageChannel channel;
    private String userName;
    private String userNameId;
    private String userAvatarUrl;

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public MessageChannel getChannel() {
        return channel;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserNameId() {
        return userNameId;
    }

    public String getUserAvatarUrl() {
        return userAvatarUrl;
    }
}
