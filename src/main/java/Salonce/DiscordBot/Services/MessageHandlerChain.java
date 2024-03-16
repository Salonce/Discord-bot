package Salonce.DiscordBot.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MessageHandlerChain {

    public void handle(Message message){
        for (int i = 0; i < messageHandlers.size(); i++){
            if (messageHandlers.get(i).handle(message))
                break;
        }
    }

    @Autowired
    private List<MessageHandler> messageHandlers = new ArrayList<>();

    /*public MessageHandlerChain(){};
    protected MessageHandlerChain(List<MessageHandler> messageHandlers){
        this.messageHandlers = messageHandlers;
    }*/
    /*public static class Builder{
        private List<MessageHandler> messageHandlers;

        public Builder(){
            this.messageHandlers = new ArrayList<>();
        }

        public Builder addLink(MessageHandler chainLink){
            messageHandlers.add(chainLink);
            return this;
        }

        public MessageHandlerChain build(){
            return new MessageHandlerChain(this.messageHandlers);
        }
    }*/
}
