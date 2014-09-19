package io.github.kazarp.blockrestore.commands;

import io.github.kazarp.blockrestore.Message;

import org.bukkit.command.CommandSender;

public class BlockListCMD implements CommandHandler {

	@Override
	public void run(CommandSender sender, String[] args) {
		Message.send("You tried to use blocklist cmd!", sender);
	}

}
