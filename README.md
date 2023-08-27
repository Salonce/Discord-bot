# Discord bot

Discord bot to process users' messages and respond
to them. Its internal structure leverages generics and
the observer pattern to provide convenient extensibility.
Modifiable to fit one's needs.

### Project involves the use of:
- Java 17
- Discord4j API
- Spring, Spring Boot
- JPQL, Hibernate, MySQL

## How to run?
To run you will need a discord bot with a token.

1. Using your discord account, go to https://discord.com/developers/applications and create a new application.
2. Go to the BOT tab and activate all privileged gateway intents
3. Reset discord bot token and save it.
4. Go to OAuth2 tab, URL generator subtab, mark the scope 'bot', then as bot permissions select <i>read messages/view channels</i> and <i>send messages</i>.
5. Use the generated URL in your browser. Select one of your servers and add the bot.


After all of the above, you can run the bot in IDE or via Docker.
### Run in IDE
1. Have MySQL installed with an available database and user.
2. Provide all necessary configuration data in the <i>src/main/resources/application.properties</i> file either directly or place it in your system environment variables (by default).


### Run in Docker:
1. Create file ' <b><i>.env</i></b> ' in the root folder of the project. Its path is included in <b><i>.gitignore</i></b>.
2. Open it (e.g. in notepad) and fill with environment variables like in the example below:

```dotenv
#DATABASE
MYSQL_DB_NAME=db_name_of_your_choice
MYSQL_DB_PASSWORD=password_of_your_choice
MYSQL_DB_USERNAME=username_of_your_choice

#DISCORD BOT TOKEN
DISCORD_BOT_TOKEN=your_discord_bot_token
```

|                                  Travel                                   |                                      Attributes                                      |
|:-------------------------------------------------------------------------:|:------------------------------------------------------------------------------------:|
| ![travel](src/main/resources/images/readme/travel.png?raw=true "travel")  | ![attributes](src/main/resources/images/readme/attributes.png?raw=true "attributes") |
