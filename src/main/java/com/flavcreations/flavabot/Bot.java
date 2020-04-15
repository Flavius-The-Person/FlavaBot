package com.flavcreations.flavabot;


import com.flavcreations.flavabot.features.*;
import com.flavcreations.flavabot.secrets.botsecrets;
import com.github.philippheuer.credentialmanager.domain.OAuth2Credential;
import com.github.philippheuer.events4j.simple.SimpleEventHandler;
import com.github.twitch4j.TwitchClient;
import com.github.twitch4j.TwitchClientBuilder;

import com.github.twitch4j.chat.events.channel.ChannelMessageEvent;

import java.awt.*;
import java.io.InputStream;

import java.util.Scanner;

public class Bot {
	
	/**
	 * Holds the Bot Configuration
	 */
	private Configuration configuration;
	
	/**
	 * Twitch4J API
	 */
	private TwitchClient twitchClient;
	
	/**
	 * Constructor
	 */
	public Bot() {
		
		botsecrets botSecrets = new botsecrets();
		
		TwitchClientBuilder clientBuilder = TwitchClientBuilder.builder();
		
		OAuth2Credential credential = new OAuth2Credential(
				"twitch", botSecrets.clientSecret);
		
		//region TwitchClient
		twitchClient = clientBuilder
				.withClientId(botSecrets.clientID)
				.withClientSecret(botSecrets.clientSecret)
				.withEnableHelix(true)
				/*
				 * Chat Module
				 * Joins irc and triggers all chat based events (viewer join/leave/sub/bits/gifted subs/...)
				 */
				.withChatAccount(credential)
				.withEnableChat(true)
				
				/*
				 * GraphQL has a limited support
				 * Don't expect a bunch of features enabling it
				 */
				.withEnableGraphQL(true)
				/*
				 * Kraken is going to be deprecated
				 * see : https://dev.twitch.tv/docs/v5/#which-api-version-can-you-use
				 * It is only here so you can call methods that are not (yet)
				 * implemented in Helix
				 */
				.withEnableKraken(true)
				/*
				 * Build the TwitchClient Instance
				 */
				.build();
		//endregion
		
	}
	
	/**
	 * Method to register all features
	 */
	public void registerFeatures() {
		// Register Event-based features
		/*ChannelNotificationOnDonation channelNotificationOnDonation = new ChannelNotificationOnDonation(twitchClient.getEventManager());
		ChannelNotificationOnFollow channelNotificationOnFollow = new ChannelNotificationOnFollow(twitchClient.getEventManager());
		ChannelNotificationOnSubscription channelNotificationOnSubscription = new ChannelNotificationOnSubscription(twitchClient.getEventManager());
		ChannelNotificationOnDonation channelNotificationOnDonation1 = new ChannelNotificationOnDonation(twitchClient.getEventManager());
	*/
	}
	
	
	public void registerHandlers()
	{
		// register your handler class
		
		
		
		twitchClient.getEventManager().getEventHandler(SimpleEventHandler.class).registerListener(new MyEventHandler());//myEventHandler);
		
	}
	
	public void start() {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("What is the channel you want to connect to?");
		String channel = scan.nextLine();
		twitchClient.getChat().joinChannel(channel);
		System.out.println("connected to: " + channel);
		String input = scan.nextLine();
		//twitchClient.getChat().sendMessage(channel, input);
		
		while(input != "exitBot")
		{
			twitchClient.getChat().sendMessage(channel, input);
			input = scan.nextLine();
		}
		
		/*if(twitchClient.getChat().getEventManager().getEventHandler(ChannelMessageEvent evemt))
		{
		
		
		}*/
		
	}
	
}