package saloncey.d4jmmorpg.Messages.Read;

import org.springframework.stereotype.Component;

@Component
public class CandyBook implements Book{
    @Override
    public String read(){
        return "You read a magazine about different types of candies. You never knew there were so many!";
    }
}
