package saloncey.d4jmmorpg.Messages.Response.Read;

import org.springframework.stereotype.Component;

@Component
public class WizardBook implements Book{
    @Override
    public String read(){
        return "You read a book about a mighty wizard living lonely in a tower in the mountains. You're inspired by his ability to invoke lightnings from the sky.";
    }
}
