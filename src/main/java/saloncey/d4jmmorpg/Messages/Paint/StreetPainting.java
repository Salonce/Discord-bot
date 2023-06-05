package saloncey.d4jmmorpg.Messages.Paint;

import org.springframework.stereotype.Component;

@Component
public class StreetPainting implements Painting{
    @Override
    public String getString() {
        return "You've made a painting of a long and curvy street. The trees reside just next to it. It's simple and yet captivating.";
    }
}
