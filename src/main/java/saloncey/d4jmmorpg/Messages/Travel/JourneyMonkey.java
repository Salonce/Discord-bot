package saloncey.d4jmmorpg.Messages.Travel;

import org.springframework.stereotype.Component;

@Component
public class JourneyMonkey implements Journey{
    @Override
    public String travel() {
        return ("You decided to gown down the street and suddenly felt something hitting your head. It was a monkey! It threw at you a banana!");
    }
}
