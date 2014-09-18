package io.github.kazarp.blockrestore;

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
		if(equalsCmdName(cmd, "blocksave")){
			if(!(sender instanceof Player) && args.length != 7){ // Tests if the command format is /blocksave [name] [x1] [y1] [z1] [x2] [y2] [z2]
				sender.sendMessage("From console, use:\n" +
			"/blocksave [name] [x1] [y1] [z1] [x2] [y2] [z2]");
				return true;
			}
			sender.sendMessage("You tried to use blocksave cmd!");
			return true;
		}
		else if(equalsCmdName(cmd, "blockrestore")){
			sender.sendMessage("You tried to use blockrestore cmd!");
			return true;
		}
		else if(equalsCmdName(cmd, "blockremove")){
			sender.sendMessage("You tried to use blockremove cmd!");
			return true;
		}
		else if(equalsCmdName(cmd, "blocklist")){
			sender.sendMessage("You tried to use blocklist cmd!");
			return true;
		}
		return false;
	}
	private boolean equalsCmdName(Command cmd, String name){
		return cmd.getName().equalsIgnoreCase(name);
	}

}
