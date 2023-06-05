package saloncey.d4jmmorpg.Messages.Read;

import org.springframework.stereotype.Component;

@Component
public class CastleBook implements Book{
    @Override
    public String read(){
        return "You've read a beautiful book about building castles in rainy weather. You feel more knowledgeable now.";
    }
}
