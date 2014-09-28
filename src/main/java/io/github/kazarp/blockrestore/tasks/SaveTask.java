package io.github.kazarp.blockrestore.tasks;

import java.util.ArrayList;

import io.github.kazarp.blockrestore.Message;

import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class SaveTask extends BukkitRunnable {
	String name;
	Block b1, b2;
	World world;
	CommandSender sender;
	Plugin plugin;

	public SaveTask(String name, Block b1, Block b2, CommandSender sender, Plugin plugin) {
		this.name = name;
		this.b1 = b1;
		this.b2 = b2;
		this.sender = sender;
		this.plugin = plugin;
		world = b1.getWorld();
	}

	@Override
	public void run() {
		plugin.reloadConfig();
		if (plugin.getConfig().isSet("saves." + name)) {
			Message.sendWarn(
					"A save with this name already exists! You can remove it with the /blockremove command.",
					this.sender);
			return;
		}
		Message.send("Getting all blocks...", sender);
		Block[] blocks = getAllBlocks(b1, b2);
		Message.send("Got blocks! Now saving...", sender);
		// TODO change to SLAPI (Block is not serializable!)
		try{
		for(int i = 0; i < blocks.length; i++){
			String pathToCurrentBlock = "saves." + name + "." + Integer.toString(i);
			plugin.getConfig().set(pathToCurrentBlock + ".X", blocks[i].getX());
			plugin.getConfig().set(pathToCurrentBlock + ".Y", blocks[i].getY());
			plugin.getConfig().set(pathToCurrentBlock + ".Z", blocks[i].getZ());
			plugin.getConfig().set(pathToCurrentBlock + ".T", blocks[i].getType().toString());
		}
		plugin.saveConfig();
		}
		catch(Exception e){
			Message.sendWarn("Error while saving: " + e.toString(), sender);
		}
		Message.send("Saved " + blocks.length + " blocks as " + name, sender);
	}

	private Block[] getAllBlocks(Block b1, Block b2) {
		ArrayList<Block> blocks = new ArrayList<Block>();
		for (int x = getMin(b1.getX(), b2.getX()); x < getMax(b1.getX() + 1,
				b2.getX() + 1); x++) {
			for (int y = getMin(b1.getY(), b2.getY()); y < getMax(
					b1.getY() + 1, b2.getY() + 1); y++) {
				for (int z = getMin(b1.getZ(), b2.getZ()); z < getMax(
						b1.getZ() + 1, b2.getZ() + 1); z++) {
					blocks.add(world.getBlockAt(x, y, z));
				}
			}
		}
		Block[] blocksArray = new Block[blocks.size()];
		return blocks.toArray(blocksArray);
	}

	private int getMin(int a, int b) {
		if (b < a) {
			return b;
		}
		return a; // If a equals b or a < b, return a
	}

	private int getMax(int a, int b) {
		if (b > a) {
			return b;
		}
		return a; // If a equals b or a > b, return a
	}
}
