package saloncey.d4jmmorpg.Messages.Travel;

import org.springframework.stereotype.Component;

@Component
public class AnotherCityJourney implements Journey{
    @Override
    public String travel() {
        return "You've decided to travel to another city. The journey is long as you walk down the path, cross a bridge until you're finally there.";
    }
}
