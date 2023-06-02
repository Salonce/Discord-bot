package saloncey.d4jmmorpg.Messages.Response.Paint;

import org.springframework.stereotype.Component;

@Component
public class SkeletonPainting implements Painting{
    @Override
    public String getString() {
        return "You've painted a human skeleton. Why? You don't know yourself, but you felt like it. Its bones look shaky.";
    }
}