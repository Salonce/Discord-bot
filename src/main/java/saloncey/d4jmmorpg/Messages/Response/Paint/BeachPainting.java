package saloncey.d4jmmorpg.Messages.Response.Paint;

import org.springframework.stereotype.Component;

@Component
public class BeachPainting implements Painting{
    @Override
    public String getString() {
        return "You've made a painting of a cozy, sandy beach. The sand looks hot and there's a lot of pebbles. You have tried your best";
    }
}
