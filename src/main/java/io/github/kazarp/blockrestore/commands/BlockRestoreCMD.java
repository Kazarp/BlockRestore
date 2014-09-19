package io.github.kazarp.blockrestore.commands;

import io.github.kazarp.blockrestore.Message;

import org.bukkit.command.CommandSender;

public class BlockRestoreCMD implements CommandHandler {

	@Override
	public void run(CommandSender sender, String[] args) {
		Message.send("You tried to use blockrestore cmd!", sender);
	}

}
