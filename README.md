# Discord bot

Discord bot to process users' messages and respond
to them. Its internal structure leverages generics and
the observer pattern to provide convenient extensibility.
Modifiable to fit one's needs.

<br><b> Project involves the use of: </b>
<br>- Java 17
<br>- Discord4j API
<br>- Spring, Spring Boot
<br>- JPQL, Hibernate, MySQL

<b>How to run?</b> <br>
1. Using your discord account, go to https://discord.com/developers/applications and create a new application.
2. Create a bot, generate and save the discord bot token for your application, like in this tutorial: https://www.writebots.com/discord-bot-token/. Activate all bot intents.
3. Mark <i>read messages/view channels</i> and <i>send messages</i> as bot permissions.  Invite the bot to your discord server.
4. Provide all necessary configuration data in the <i>src/main/resources/application.properties</i> file either directly or place it in your system environment variables (by default).


![travel](src/main/resources/images/readme/travel.png?raw=true "travel")
![travel](src/main/resources/images/readme/attributes.png?raw=true "attributes")