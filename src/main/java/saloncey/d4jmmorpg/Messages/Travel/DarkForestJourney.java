package saloncey.d4jmmorpg.Messages.Travel;

import org.springframework.stereotype.Component;

@Component
public class DarkForestJourney implements Journey{
    @Override
    public String travel() {
        return "You've decided to visit a very dark forest nearby. As you go through the dense trees and bushes, you find a small wooden shack in it where you take a nap.";
    }
}
