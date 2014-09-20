package io.github.kazarp.blockrestore;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class BlockRestoreListener implements Listener {
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event){
		if(event.getMaterial() != Material.BONE)
			return;
		if(!(event.getPlayer().hasPermission("blockrestore.save")))
			return;
		if(!(event.getAction() == Action.LEFT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_BLOCK))
			return;
		event.setCancelled(true);
		if(event.getAction() == Action.LEFT_CLICK_BLOCK){
			SelectionCollection.setBlock1(event.getPlayer(), event.getClickedBlock());
		}
		else if(event.getAction() == Action.RIGHT_CLICK_BLOCK){
			SelectionCollection.setBlock2(event.getPlayer(), event.getClickedBlock());
		}
	}
}
