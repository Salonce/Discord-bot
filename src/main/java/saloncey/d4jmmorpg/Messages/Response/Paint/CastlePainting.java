package saloncey.d4jmmorpg.Messages.Response.Paint;

import org.springframework.stereotype.Component;

@Component
public class CastlePainting implements Painting{
    @Override
    public String getString() {
        return "You've painted an old castle in a valley. You feel like a real painter now.";
    }
}