package io.github.kazarp.blockrestore.commands;

import io.github.kazarp.blockrestore.Message;
import io.github.kazarp.blockrestore.SelectionCollection;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class BlockSaveCMD implements CommandHandler {

	Plugin plugin;
	
	public BlockSaveCMD(Plugin p){
		plugin = p;
	}
	
	@Override
	public void run(CommandSender sender, String[] args) {
		if (args.length == 1){
			SaveBlocks(args[0], (Player)sender);
		}
		else if (args.length == 7){
			SaveBlocks(args[0], args[1], args[2], args[3], args[4], args[5],
					args[6], (Player)sender);
		}
		else if(args.length == 8){
			SaveBlocks(args[0], args[1], args[2], args[3], args[4], args[5],
					args[6], args[7], (Player)sender);
		}
		else
			return;
	}
	
	private void SaveBlocks(String name, Block b1, Block b2){
		//TODO cycle through blocks
		Message.send(name + " " + b1.getType().toString().toLowerCase().replace('_', ' ') + " " + b2.getType().toString().toLowerCase().replace('_', ' '), plugin.getServer().getPlayerExact("mrbigd151"));
	}
	
	private void SaveBlocks(String name, Player sender) {
		Block b1 = SelectionCollection.getBlock1(sender);
		Block b2 = SelectionCollection.getBlock2(sender);
		if (b1 == null && b2 == null) {
			Message.send("You didn't select any block. Use a bone and left/right click a block.", sender); return;
		}
		if (b1 == null) {
			Message.send("You didn't select the first block. Use a bone and left click a block.", sender); return;
		}
		if (b2 == null) {
			Message.send("You didn't select the second block. Use a bone and right click a block.", sender); return;
		}
		SaveBlocks(name, b1, b2);
	}
	
	private void SaveBlocks(String name, World w, String x1, String y1, String z1,
			String x2, String y2, String z2, Player sender) {
		int x1i, y1i, z1i, x2i, y2i, z2i;
		try{
		x1i = Integer.parseInt(x1);
		y1i = Integer.parseInt(y1);
		z1i = Integer.parseInt(z1);
		x2i = Integer.parseInt(x2);
		y2i = Integer.parseInt(y2);
		z2i = Integer.parseInt(z2);
		}catch(NumberFormatException e){
			Message.send("Bad syntax! Use /<command> [name] (world) [x1] [y1] [z1] [x2] [y2] [z2]", sender);
			return;
		}
		Block b1 = new Location(sender.getWorld(), x1i, y1i, z1i).getBlock();
		Block b2 = new Location(sender.getWorld(), x2i, y2i, z2i).getBlock();
		SaveBlocks(name, b1, b2);
	}
	
	private void SaveBlocks(String name, String x1, String y1, String z1,
			String x2, String y2, String z2, Player sender) {
		SaveBlocks(name, sender.getWorld(), x1, y1, z1, x2, y2, z2, sender);
	}
	
	private void SaveBlocks(String name, String worldName, String x1, String y1, String z1,
			String x2, String y2, String z2, Player sender){
		World w = plugin.getServer().getWorld(worldName);
		if(w == null){
			Message.send("The given world doesn't exist!", sender);
			return;
		}
		SaveBlocks(name, w, x1, y1, z1, x2, y2, z2, sender);
	}

}
