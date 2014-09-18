package io.github.kazarp.blockrestore;

import org.bukkit.ChatColor;
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
				answer(sender, "From console use:\n" +
			"/blocksave [name] [x1] [y1] [z1] [x2] [y2] [z2]");
				return true;
			}
			answer(sender, "You tried to use blocksave cmd!");
			return true;
		}
		else if(equalsCmdName(cmd, "blockrestore") && sender.hasPermission("blockrestore.restore")){
			answer(sender, "You tried to use blockrestore cmd!");
			return true;
		}
		else if(equalsCmdName(cmd, "blockremove") && sender.hasPermission("blockrestore.remove")){
			answer(sender, "You tried to use blockremove cmd!");
			return true;
		}
		else if(equalsCmdName(cmd, "blocklist") && sender.hasPermission("blockrestore.list")){
			answer(sender, "You tried to use blocklist cmd!");
			return true;
		}
		return false;
	}
	private boolean equalsCmdName(Command cmd, String name){
		return cmd.getName().equalsIgnoreCase(name);
	}
	private void answer(CommandSender sender, String message){
		sender.sendMessage(ChatColor.GOLD +"[" + plugin.getName() + "] " + ChatColor.GREEN +message);
	}
}
