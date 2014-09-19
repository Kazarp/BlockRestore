package io.github.kazarp.blockrestore;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

public final class Message {
	public static Plugin plugin;
	public static void send(String message, CommandSender sender){
		sender.sendMessage(ChatColor.GOLD +"[" + plugin.getName() + "] " + ChatColor.GREEN + message);
	}
}
