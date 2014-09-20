package io.github.kazarp.blockrestore;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public final class Message {
	private static Plugin plugin;
	private static String prefix;

	public static void load(Plugin p) {
		plugin = p;
		prefix = ChatColor.GOLD + "[" + plugin.getName() + "] "
				+ ChatColor.GREEN;
	}

	public static void send(String msg, CommandSender sender) {
		sender.sendMessage(format(msg));
	}

	public static void send(String msg, Player p) {
		p.sendMessage(format(msg));
	}

	private static String format(String msg) {
		return prefix + msg;
	}
}
