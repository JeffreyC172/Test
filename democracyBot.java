package com.apcsa.democracybot;

import com.apcsa.democracybot.listeners.EventListener;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;

import javax.security.auth.login.LoginException;

public class democracyBot {

    public BanList test = new BanList(); //Banlist
    char commandIdentifier='!';
    private final Dotenv config;
    private final ShardManager shardManager;

    public democracyBot() throws LoginException {
        config=Dotenv.configure().load();
        String token=config.get("TOKEN");
        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(token);
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setActivity(Activity.playing("Testing"));
        shardManager = builder.build();
        //register listeners
        shardManager.addEventListener(new EventListener());

    }

    public ShardManager getShardManager(){
        return shardManager;
    }

    public Dotenv getConfig(){
        return config;
    }
    public static void main(String[] args){
        try {
            democracyBot bot = new democracyBot();
        } catch (LoginException e) {
            System.out.println("ERROR: BOT TOKEN");
        }
    }

    public BanList getBanList(){
        return test;
    }
}

