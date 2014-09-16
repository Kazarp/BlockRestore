package io.github.kazarp.blockrestore;

import org.bukkit.plugin.java.JavaPlugin;

public class BlockRestore extends JavaPlugin {
	@Override
	public void onEnable() {
		getLogger().info("Plugin enabled");
	}
	
	@Override
	public void onDisable() {
		getLogger().info("Plugin disabled");
	}
}
