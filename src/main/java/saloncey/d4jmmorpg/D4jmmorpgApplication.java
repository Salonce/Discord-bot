package saloncey.d4jmmorpg;

import discord4j.core.DiscordClient;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.message.MessageCreateEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import saloncey.d4jmmorpg.Services.MessageObserver;


@SpringBootApplication
public class D4jmmorpgApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(D4jmmorpgApplication.class, args);
	}

	@Autowired
	private MessageObserver messageObserver;

	@Value("${discord.bot.token}")
	private String discordBotToken;

	@Override
	public void run(String... args) throws Exception{
		//log the bot in

		final DiscordClient client = DiscordClient.create(discordBotToken);
		final GatewayDiscordClient gateway = client.login().block();


		gateway.on(MessageCreateEvent.class).subscribe(event -> {
			messageObserver.setNewMessage(event.getMessage());
		});
		gateway.onDisconnect().block();
	}

}
