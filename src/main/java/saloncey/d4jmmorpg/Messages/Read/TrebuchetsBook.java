package saloncey.d4jmmorpg.Messages.Read;

import org.springframework.stereotype.Component;

@Component
public class TrebuchetsBook implements Book{
    @Override
    public String read(){
        return "You read about a trebuchet that has been used years ago to knock stone walls. You feel more knowledgeable.";
    }
}
