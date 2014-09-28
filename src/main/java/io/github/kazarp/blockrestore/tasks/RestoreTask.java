package io.github.kazarp.blockrestore.tasks;

import io.github.kazarp.blockrestore.Message;

import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class RestoreTask extends BukkitRunnable {

	String name;
	CommandSender sender;
	Plugin plugin;
	public RestoreTask(String name, CommandSender sender, Plugin plugin) {
		this.name = name;
		this.sender = sender;
		this.plugin = plugin;
	}

	@Override
	public void run() {
		plugin.reloadConfig();
		String basePath = "saves." + name;
		if(!plugin.getConfig().isSet(basePath)){
			Message.sendWarn("Save with this name doesn't exist! Use /blocklist to show all available saves.", sender);
		}
		World w = plugin.getServer().getWorld(UUID.fromString(plugin.getConfig().getString(basePath + ".W")));
		Message.send("Starting restore process...", sender);
		int success = 0;
		int fail = 0;
		for(String s : plugin.getConfig().getConfigurationSection(basePath).getKeys(false)){
			if(s == basePath + ".W")
				continue;
			int X = plugin.getConfig().getInt(basePath+".X");
			int Y = plugin.getConfig().getInt(basePath+".Y");
			int Z = plugin.getConfig().getInt(basePath+".Z");
			Material type = Material.getMaterial(plugin.getConfig().getString(basePath+".T"));
			if(type == null)
			{
				// TODO: BUG: Shows always
				Message.sendWarn("Bad type format \"" + plugin.getConfig().getString(basePath+".T") + "\"", sender);
				fail++;
				continue;
			}
			w.getBlockAt(X, Y, Z).setType(type);
			success++;
		}
		Message.send("Restore finished. Successfuly restored " + success + " blocks. Failed to restore "+fail+" blocks.", sender);
	}

}
