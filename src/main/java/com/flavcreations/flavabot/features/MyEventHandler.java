package com.flavcreations.flavabot.features;

import com.github.philippheuer.events4j.simple.domain.EventSubscriber;
import com.github.twitch4j.chat.events.channel.ChannelMessageEvent;

public class MyEventHandler
{
	@EventSubscriber
	public void printChannelMessage(ChannelMessageEvent event)
	{
		System.out.println("[" + event.getChannel().getName() + "]["
				+ event.getPermissions().toString() + "] "
				+ event.getUser().getName() + ": " + event.getMessage());
		
	}
}
