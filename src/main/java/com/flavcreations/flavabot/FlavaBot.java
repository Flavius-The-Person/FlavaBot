package com.flavcreations.flavabot;

import com.flavcreations.flavabot.secrets.botsecrets;
import com.github.philippheuer.credentialmanager.domain.OAuth2Credential;
import com.github.philippheuer.events4j.core.EventManager;
import com.github.twitch4j.TwitchClient;
import com.github.twitch4j.TwitchClientBuilder;
import com.github.twitch4j.chat.TwitchChat;
import com.github.twitch4j.chat.events.channel.ChannelMessageEvent;

import java.util.Scanner;

public class FlavaBot {
	
	//private static botsecrets botSecrets = new botsecrets();
	private static TwitchChat twitchChat;
	//private static final String CREDENTIAL_FILE = "credentials.yaml";
//	private static final Random RANDOM = new Random();
	
	public static void main(String[] args)
	{
		Bot bot = new Bot();
		bot.registerFeatures();
		bot.registerHandlers();
		bot.start();
		
	}
}