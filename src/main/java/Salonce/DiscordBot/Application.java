package Salonce.DiscordBot;

import Salonce.DiscordBot.Services.Message;
import Salonce.DiscordBot.Services.MessageHandlerChain;
import discord4j.core.DiscordClient;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.message.MessageCreateEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	MessageHandlerChain messageHandlerChain;

	@Value("${discord.bot.token}")
	private String discordBotToken;

	@Override
	public void run(String... args) throws Exception{

		final DiscordClient client = DiscordClient.create(discordBotToken);
		final GatewayDiscordClient gateway = client.login().block();


		gateway.on(MessageCreateEvent.class).subscribe(event -> {
			Message message = new Message();
			message.setMessage(event.getMessage());

			messageHandlerChain.handle(message);
		});
		gateway.onDisconnect().block();
	}

}
