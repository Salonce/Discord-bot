package Salonce.DiscordBot.Services;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class Selector {
    private Random random = new Random();

    public <T> T selectRandomFromAList(List<T> list){
        int number = random.nextInt(list.size());
        return list.get(number);
    }
}
