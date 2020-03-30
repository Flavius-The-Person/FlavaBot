package com.flavcreations.flavabot.features;


import com.github.philippheuer.events4j.core.EventManager;
import com.github.twitch4j.chat.events.channel.ChannelMessageEvent;
import com.github.twitch4j.chat.events.channel.SubscriptionEvent;

public class WriteChannelChatToConsole {
	
	/**
	 * Register events of this class with the EventManager
	 *
	 * @param eventManager EventManager
	 */
	public WriteChannelChatToConsole(EventManager eventManager) {
		String user = eventManager.getEventHandler(ChannelMessageEvent.class).getUser().getName();
		String message = eventManager.getEventHandler(ChannelMessageEvent.class).getMessage();
		
		
		//String other = eventManager.getEventHandler(C);
		
		/*.subscribe(event -> {
			System.out.println("[" + event.getChannel().getName() + "] " + event.getUser().getName() + ": " + event.getMessage());
		});
		eventManager.getEventHandler(ChannelMessageEvent.class).subscribe(event -> onChannelMessage(event));
		
		eventManager.getEventHandler(ChannelMessageEvent.class).subscribe(event -> onChannelMessage(event));
	*/}
	
	/**
	 * Subscribe to the ChannelMessage Event and write the output to the console
	 */
	public void onChannelMessage(ChannelMessageEvent event) {
		System.out.printf(
				"Channel [%s] - User[%s] - Message [%s]%n",
				event.getChannel().getName(),
				event.getUser().getName(),
				event.getMessage()
		);
	}
	
}