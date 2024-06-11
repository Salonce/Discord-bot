# Discord bot

Discord bot processes users' messages and responds
to them. Its internal structure leverages generics and
the chain of responsibility pattern to provide convenient extensibility.
Modifiable to fit one's needs.

### Uses:
- Java 17
- Spring Boot
- Discord4j API
- Hibernate + MySQL

## How to run?

### 1. Create your own discord bot. 

- Using your discord account, go to https://discord.com/developers/applications and create a new application.
- Go to the BOT tab and activate all privileged gateway intents
- Reset discord bot token and save it.
- Go to OAuth2 tab, URL generator subtab, mark the scope 'bot', then as bot permissions select <i>read messages/view channels</i> and <i>send messages</i>.
- Use the generated URL in your browser. Select one of your servers and add the bot.

After you obtained bot and the token, you can run it. Using docker is most straightforward.

### 2a.  Run via Docker:
1. Create file ' <b><i>.env</i></b> ' in the root folder of the project. Its path is by default included in <b><i>.gitignore</i></b>.
2. Open the **.env** file (e.g. in notepad) and fill it with environment variables like in the example below. Set any database and port settings you find suitable.

```dotenv
#DATABASE
MYSQL_DB_NAME=your_db_name
MYSQL_DB_PASSWORD=your_db_password
MYSQL_DB_USERNAME=your_db_username

#DISCORD BOT TOKEN (For testing the bot, it's only necessary to modify this value with a valid token)
DISCORD_BOT_TOKEN=your_discord_bot_token

#ACCESS PORT
ACCESS_PORT=8080

```


3. Use "docker compose up" in the root folder of the project.

### 2b. (Alternatively) Run via CLI/IDE
1. Have MySQL installed with an available database and user.
2. Provide all necessary configuration data in the <i>src/main/resources/application.properties</i> file either directly or place it in your system environment variables (set by default).
3. Compile and run.


|                                  Travel                                   |                                      Attributes                                      |
|:-------------------------------------------------------------------------:|:------------------------------------------------------------------------------------:|
| ![travel](src/main/resources/images/readme/travel.png?raw=true "travel")  | ![attributes](src/main/resources/images/readme/attributes.png?raw=true "attributes") |
