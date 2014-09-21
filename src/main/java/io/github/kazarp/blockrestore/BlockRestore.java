package io.github.kazarp.blockrestore;

import io.github.kazarp.blockrestore.commands.BRCommandExecutor;

import org.bukkit.Material;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class BlockRestore extends JavaPlugin {
	String[] commands = new String[] { "blocksave", "blockrestore",
			"blockremove", "blocklist" };

	@Override
	public void onEnable() {
		Message.load(this);
		for (int i = 0; i < commands.length; i++) {
			PluginCommand cmd = this.getCommand(commands[i]);
			if (cmd != null) {
				cmd.setExecutor(new BRCommandExecutor(this));
			}
		}
		getServer().getPluginManager().registerEvents(
				new BlockRestoreListener(this), this);
		getConfig().addDefault("selection-tool", Material.BONE.toString());
		this.saveDefaultConfig();
	}

	@Override
	public void onDisable() {

	}
}
