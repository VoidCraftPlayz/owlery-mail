package com.voidcraftplays.owlerymail.listeners;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.voidcraftplays.owlerymail.Main;

public class PlayerJoinListener implements Listener {
	
	private Main main;
	
	public PlayerJoinListener(Main main) {
		this.main = main;
	}
	
	@EventHandler (priority = EventPriority.HIGH)
	public void onJoin(PlayerJoinEvent e) {
		
		Player player = e.getPlayer();
		List<String> messages = new ArrayList<>();
		messages.add("Welcome to Rowling's Realms!");
		List<String> senders = new ArrayList<>();
		senders.add("Headmaster");
		
		if (!main.getConfig().contains("messages." + player.getUniqueId())) {
		
			main.getConfig().set("messages." + player.getUniqueId() + ".message", messages);
			main.getConfig().set("messages." + player.getUniqueId() + ".sender", senders);
			main.saveConfig();
		
		}
		
	}
	
}
