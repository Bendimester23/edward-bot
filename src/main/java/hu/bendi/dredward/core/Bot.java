package hu.bendi.dredward.core;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

import javax.annotation.Nonnull;
import javax.security.auth.login.LoginException;

public class Bot extends ListenerAdapter {

    private JDA bot;

    public void start() {
        try {
            bot = JDABuilder.createDefault(System.getenv("TOKEN"))
                    .enableCache(CacheFlag.VOICE_STATE, CacheFlag.MEMBER_OVERRIDES)
                    .enableIntents(GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_INVITES)
                    .build();
        } catch (LoginException e) {
            e.printStackTrace();
        }
        bot.addEventListener(this);
    }

    public void stop() {

    }

    @Override
    public void onReady(@Nonnull ReadyEvent event) {
        bot.getPresence().setPresence(OnlineStatus.ONLINE, Activity.playing(bot.getGuilds().size() + " szerveren | edwardbot.tk"));
    }
}
