package io.github.kazarp.blockrestore;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class Selection {
	private Player player;
	private Block block1, block2;
	public Selection(Player p, Block b1, Block b2){
		player = p;
		block1 = b1;
		block2 = b2;
	}
	public Selection(Player p, int x1, int y1, int z1, int x2, int y2, int z2){
		player = p;
		block1 = new Location(p.getWorld(), x1, y1, z1).getBlock();
		block2 = new Location(p.getWorld(), x2, y2, z2).getBlock();
	}
	
	
	public Player getPlayer(){
		return player;
	}
	public String getPlayerID(){
		return player.getUniqueId().toString();
	}
	
	
	public Block getBlock1(){
		return block1;
	}
	public Block getBlock2(){
		return block2;
	}
	public void setBlock1(Block b1){
		block1 = b1;
	}
	public void setBlock2(Block b2){
		block2 = b2;
	}
	
	
	public boolean areBlockInTheSameWorld(){
		return areBlocksInTheSameWorld(block1, block2);
	}
	public static boolean comparePlayers(Player p1, Player p2){
		return p1.getUniqueId().compareTo(p2.getUniqueId()) == 0;
	}
	public static boolean areBlocksInTheSameWorld(Block b1, Block b2){
		return b1.getWorld().getUID().toString() == b2.getWorld().getUID().toString();
	}
}
