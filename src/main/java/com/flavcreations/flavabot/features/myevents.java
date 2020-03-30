package com.flavcreations.flavabot.features;

import com.github.philippheuer.events4j.core.EventManager;
import com.github.twitch4j.chat.events.channel.ChannelMessageEvent;
import com.github.twitch4j.chat.events.channel.DonationEvent;
import com.github.twitch4j.helix.domain.User;

import java.awt.*;

public class myevents
{
	public myevents(EventManager eventManager)
	{
		
		//if(eventManager.getEventHandler(ChannelMessageEvent.class).getMessageEvent().
		{
		}
		//eventManager.onEvent(ChannelMessageEvent.class).subscribe(event -> {
		//	System.out.println("[" + event.getChannel().getName() + "] " + event.getUser().getName() + ": " + event.getMessage());
		//});
		//eventManager.getEventHandler(ChannelMessageEvent.class).getUser();
		//eventManager.getEventHandler(ChannelMessageEvent.class).getUser().getId();
	}
	
	/**
	 * Subscribe to the Donation Event
	 */
	public void onDonation(DonationEvent event) {
		String message = String.format(
				"%s just donated %s using %s!",
				event.getUser().getName(),
				event.getAmount(),
				event.getSource()
		);
		
		event.getTwitchChat().sendMessage(event.getChannel().getName(), message);
	}
		//if(eventManager.getEventHandler(DonationEvent.class).equals(!null)
		
	{
	
	}
}

