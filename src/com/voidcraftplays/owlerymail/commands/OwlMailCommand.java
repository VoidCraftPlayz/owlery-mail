package com.voidcraftplays.owlerymail.commands;

import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.voidcraftplays.owlerymail.Main;

public class OwlMailCommand implements CommandExecutor {
	
	private Main main;
	
	public OwlMailCommand(Main main) {
		this.main = main;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (sender instanceof Player) {
			
			Player player = (Player) sender;
			UUID uuid = player.getUniqueId();
			
			if (args.length == 0) {
				
				player.sendMessage(main.prefix + ChatColor.translateAlternateColorCodes('&', "&7Commands:"));
				player.sendMessage(main.prefix + ChatColor.translateAlternateColorCodes('&', "&a/owl help &7| Prints this message"));
				player.sendMessage(main.prefix + ChatColor.translateAlternateColorCodes('&', "&a/owl messages &7| Shows your messages"));
				player.sendMessage(main.prefix + ChatColor.translateAlternateColorCodes('&', "&a/owl send (player) (message) &7| Sends a message to a player"));
				player.sendMessage(main.prefix + ChatColor.translateAlternateColorCodes('&', "&a/owl clear &7| Clears your message feed"));
				
			} else if (args.length > 0) {
				
				switch (args[0]) {
				case "help":
					
					player.sendMessage(main.prefix + ChatColor.translateAlternateColorCodes('&', "&7Commands:"));
					player.sendMessage(main.prefix + ChatColor.translateAlternateColorCodes('&', "&a/owl help &7| Prints this message"));
					player.sendMessage(main.prefix + ChatColor.translateAlternateColorCodes('&', "&a/owl messages &7| Shows your messages"));
					player.sendMessage(main.prefix + ChatColor.translateAlternateColorCodes('&', "&a/owl send (player) (message) &7| Sends a message to a player"));
					player.sendMessage(main.prefix + ChatColor.translateAlternateColorCodes('&', "&a/owl clear &7| Clears your message feed"));
					
					break;
				case "messages":
					
					player.sendMessage(main.prefix + ChatColor.translateAlternateColorCodes('&', "&7Messages:"));
					
					List<String> message = main.getConfig().getStringList("messages." + uuid + ".message");
					List<String> msgsenders = main.getConfig().getStringList("messages." + uuid + ".sender");
					
					for (int i = 0; i < message.size(); i++) {
						
						System.out.println("Working...");
						player.sendMessage(main.prefix + ChatColor.translateAlternateColorCodes('&', "&7- Message: '" + message.get(i) + "' &aFrom: " + msgsenders.get(i)));
						
					}
					
					break;
				case "send":
					
					if (args.length > 2) {
						
						@SuppressWarnings("deprecation")
						OfflinePlayer pl = Bukkit.getOfflinePlayer(args[1]);
						Player pla = Bukkit.getPlayer(args[1]);
						
						UUID playerUUID = pl.getUniqueId();
						
						if (pl.hasPlayedBefore() == true) {
							
							List<String> messages = main.getConfig().getStringList("messages." + playerUUID + ".message");
							List<String> senders = main.getConfig().getStringList("messages." + playerUUID + ".sender");
							
							switch (args.length) {
							case 2:
								
								break;
							case 3:
								messages.add(args[2]);
								break;
							case 4:
								messages.add(args[2] + " " + args[3]);
								break;
							case 5:
								messages.add(args[2] + " " + args[3] + " " + args[4]);
								break;
							case 6:
								messages.add(args[2] + " " + args[3] + " " + args[4] + " " + args[5]);
								break;
							case 7:
								messages.add(args[2] + " " + args[3] + " " + args[4] + " " + args[5] + " " + args[6]);
								break;
							case 8:
								messages.add(args[2] + " " + args[3] + " " + args[4] + " " + args[5] + " " + args[6] + " " + args[7]);
								break;
							case 9:
								messages.add(args[2] + " " + args[3] + " " + args[4] + " " + args[5] + " " + args[6] + " " + args[7] + " " + args[8]);
								break;
							case 10:
								messages.add(args[2] + " " + args[3] + " " + args[4] + " " + args[5] + " " + args[6] + " " + args[7] + " " + args[8] + " " + args[9]);
								break;
							case 11:
								messages.add(args[2] + " " + args[3] + " " + args[4] + " " + args[5] + " " + args[6] + " " + args[7] + " " + args[8] + " " + args[9] + " " + args[10]);
								break;
							case 12:
								messages.add(args[2] + " " + args[3] + " " + args[4] + " " + args[5] + " " + args[6] + " " + args[7] + " " + args[8] + " " + args[9] + " " + args[10] + " " + args[11]);
								break;
							case 13:
								messages.add(args[2] + " " + args[3] + " " + args[4] + " " + args[5] + " " + args[6] + " " + args[7] + " " + args[8] + " " + args[9] + " " + args[10] + " " + args[11] + " " + args[12]);
								break;
							case 14:
								messages.add(args[2] + " " + args[3] + " " + args[4] + " " + args[5] + " " + args[6] + " " + args[7] + " " + args[8] + " " + args[9] + " " + args[10] + " " + args[11] + " " + args[12] + " " + args[13]);
								break;
							case 15:
								messages.add(args[2] + " " + args[3] + " " + args[4] + " " + args[5] + " " + args[6] + " " + args[7] + " " + args[8] + " " + args[9] + " " + args[10] + " " + args[11] + " " + args[12] + " " + args[13] + " " + args[14]);
								break;
							case 16:
								messages.add(args[2] + " " + args[3] + " " + args[4] + " " + args[5] + " " + args[6] + " " + args[7] + " " + args[8] + " " + args[9] + " " + args[10] + " " + args[11] + " " + args[12] + " " + args[13] + " " + args[14] + " " + args[15]);
								break;
							case 17:
								messages.add(args[2] + " " + args[3] + " " + args[4] + " " + args[5] + " " + args[6] + " " + args[7] + " " + args[8] + " " + args[9] + " " + args[10] + " " + args[11] + " " + args[12] + " " + args[13] + " " + args[14] + " " + args[15] + " " + args[16]);
								break;
							case 18:
								messages.add(args[2] + " " + args[3] + " " + args[4] + " " + args[5] + " " + args[6] + " " + args[7] + " " + args[8] + " " + args[9] + " " + args[10] + " " + args[11] + " " + args[12] + " " + args[13] + " " + args[14] + " " + args[15] + " " + args[16] + " " + args[17]);
								break;
							case 19:
								messages.add(args[2] + " " + args[3] + " " + args[4] + " " + args[5] + " " + args[6] + " " + args[7] + " " + args[8] + " " + args[9] + " " + args[10] + " " + args[11] + " " + args[12] + " " + args[13] + " " + args[14] + " " + args[15] + " " + args[16] + " " + args[17] + " " + args[18]);
								break;
							case 20:
								messages.add(args[2] + " " + args[3] + " " + args[4] + " " + args[5] + " " + args[6] + " " + args[7] + " " + args[8] + " " + args[9] + " " + args[10] + " " + args[11] + " " + args[12] + " " + args[13] + " " + args[14] + " " + args[15] + " " + args[16] + " " + args[17] + " " + args[18] + " " + args[19]);
								break;
							case 21:
								messages.add(args[2] + " " + args[3] + " " + args[4] + " " + args[5] + " " + args[6] + " " + args[7] + " " + args[8] + " " + args[9] + " " + args[10] + " " + args[11] + " " + args[12] + " " + args[13] + " " + args[14] + " " + args[15] + " " + args[16] + " " + args[17] + " " + args[18] + " " + args[19] + " " + args[20]);
								break;
							}
							senders.add(player.getName());
							
							pla.sendMessage(main.prefix + ChatColor.translateAlternateColorCodes('&', "&7A player has sent you a message. View it with &a/owl messages"));
							player.sendMessage(main.prefix + ChatColor.translateAlternateColorCodes('&', "&7You have sent a player a message. They can view it with &a/owl messages"));
							
							main.getConfig().set("messages." + playerUUID + ".message", messages);
							main.getConfig().set("messages." + playerUUID + ".sender", senders);
							main.saveConfig();
							
						} else {
							
							player.sendMessage(main.prefix + ChatColor.translateAlternateColorCodes('&', "&7Player has not joined this server."));
							
						}
						
					} else {
						
						player.sendMessage(main.prefix + ChatColor.translateAlternateColorCodes('&', "&7Incorrect usage: &a/owl send (player) (message)"));
						
					}
					
					break;
				case "clear":
					
					break;
				}
				
			}
			
		}
		
		return false;
	}
	
}
