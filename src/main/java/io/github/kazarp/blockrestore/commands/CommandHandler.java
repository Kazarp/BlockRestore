package io.github.kazarp.blockrestore.commands;

import org.bukkit.command.CommandSender;

interface CommandHandler {
	public void run(CommandSender sender, String[] args);
}
