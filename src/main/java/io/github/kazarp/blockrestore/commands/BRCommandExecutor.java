package io.github.kazarp.blockrestore.commands;

import io.github.kazarp.blockrestore.BlockRestore;
import io.github.kazarp.blockrestore.Message;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BRCommandExecutor implements CommandExecutor {
	private final BlockRestore plugin;

	public BRCommandExecutor(BlockRestore plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (equalsCmdName(cmd, "blocksave")
				&& sender.hasPermission("blockrestore.save")) {
			if (!(sender instanceof Player) && args.length != 8) {
				Message.send(
						"From console use:\n"
								+ "/blocksave [name] [worldName] [x1] [y1] [z1] [x2] [y2] [z2]",
						sender);
				return true;
			}
			if (args.length == 1 || args.length == 7 || args.length == 8) {
				new BlockSaveCMD(plugin).run(sender, args);
				return true;
			}
		} else if (equalsCmdName(cmd, "blockrestore")
				&& sender.hasPermission("blockrestore.restore")) {
			if (args.length == 1) {
				new BlockRestoreCMD(plugin).run(sender, args);
				return true;
			}
		} else if (equalsCmdName(cmd, "blockremove")
				&& sender.hasPermission("blockrestore.remove")) {
			if (args.length == 1) {
				new BlockRemoveCMD().run(sender, args);
				return true;
			}
		} else if (equalsCmdName(cmd, "blocklist")
				&& sender.hasPermission("blockrestore.list")) {
			new BlockListCMD().run(sender, args);
			return true;
		}
		return false;
	}

	private boolean equalsCmdName(Command cmd, String name) {
		return cmd.getName().equalsIgnoreCase(name);
	}
}
