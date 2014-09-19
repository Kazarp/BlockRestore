package io.github.kazarp.blockrestore.commands;

import io.github.kazarp.blockrestore.BlockRestore;
import io.github.kazarp.blockrestore.Message;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BRCommandExecutor implements CommandExecutor {
	private final BlockRestore plugin;
	
	public BRCommandExecutor(BlockRestore plugin){
		this.plugin = plugin;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if(equalsCmdName(cmd, "blocksave") && sender.hasPermission("blockrestore.save")){
			if(!(sender instanceof Player) && args.length != 7){ // Tests if the command format is /blocksave [name] [x1] [y1] [z1] [x2] [y2] [z2]
				Message.send("From console use:\n" +
			"/blocksave [name] [x1] [y1] [z1] [x2] [y2] [z2]", sender, plugin);
				return true;
			}
			Message.send("You tried to use blocksave cmd!", sender, plugin);
			return true;
		}
		else if(equalsCmdName(cmd, "blockrestore") && sender.hasPermission("blockrestore.restore")){
			Message.send("You tried to use blockrestore cmd!", sender, plugin);
			return true;
		}
		else if(equalsCmdName(cmd, "blockremove") && sender.hasPermission("blockrestore.remove")){
			Message.send("You tried to use blockremove cmd!", sender, plugin);
			return true;
		}
		else if(equalsCmdName(cmd, "blocklist") && sender.hasPermission("blockrestore.list")){
			Message.send("You tried to use blocklist cmd!", sender, plugin);
			return true;
		}
		return false;
	}
	private boolean equalsCmdName(Command cmd, String name){
		return cmd.getName().equalsIgnoreCase(name);
	}
}
