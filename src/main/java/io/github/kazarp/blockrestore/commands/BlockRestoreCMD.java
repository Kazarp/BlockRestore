package io.github.kazarp.blockrestore.commands;

import io.github.kazarp.blockrestore.tasks.RestoreTask;

import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

public class BlockRestoreCMD implements CommandHandler {

	Plugin plugin;

	public BlockRestoreCMD(Plugin p) {
		plugin = p;
	}
	
	@Override
	public void run(CommandSender sender, String[] args) {
		new RestoreTask(args[0], sender, plugin).runTaskAsynchronously(plugin);
	}

}
