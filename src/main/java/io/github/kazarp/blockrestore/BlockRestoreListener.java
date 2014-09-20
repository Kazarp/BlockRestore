package io.github.kazarp.blockrestore;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;

public class BlockRestoreListener implements Listener {
	Plugin plugin;

	public BlockRestoreListener(Plugin p) {
		plugin = p;
	}

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		if (event.getMaterial() != Material.BONE)
			return;
		if (!(event.getPlayer().hasPermission("blockrestore.save")))
			return;
		if (!(event.getAction() == Action.LEFT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_BLOCK))
			return;
		event.setCancelled(true);
		if (event.getAction() == Action.LEFT_CLICK_BLOCK) {
			event.getPlayer().setMetadata("blockrestore-block1",
					new FixedMetadataValue(plugin, event.getClickedBlock()));
			Message.send("You selected the first block", event.getPlayer());
		} else if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			event.getPlayer().setMetadata("blockrestore-block2",
					new FixedMetadataValue(plugin, event.getClickedBlock()));
			Message.send("You selected the second block", event.getPlayer());
		}
	}
}
