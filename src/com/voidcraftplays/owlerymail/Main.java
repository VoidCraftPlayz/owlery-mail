package com.voidcraftplays.owlerymail;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import com.voidcraftplays.owlerymail.commands.OwlMailCommand;
import com.voidcraftplays.owlerymail.listeners.PlayerJoinListener;

public class Main extends JavaPlugin {
	
	public String prefix = ChatColor.translateAlternateColorCodes('&', getConfig().getString("prefix") + " &7» ");
	
	public void onEnable() {
		
		System.out.println("Owlery Mail has been enabled.");
		
		getConfig().options().copyDefaults(true);
		saveConfig();
		
		getCommand("owl").setExecutor(new OwlMailCommand(this));
		
		Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(this), this);
		
	}
	
}
