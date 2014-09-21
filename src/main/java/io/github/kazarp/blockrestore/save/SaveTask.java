package io.github.kazarp.blockrestore.save;

import org.bukkit.block.Block;
import org.bukkit.scheduler.BukkitRunnable;

public class SaveTask extends BukkitRunnable {

	Block b1, b2;
	public SaveTask(Block b1, Block b2) {
		this.b1 = b1;
		this.b2 = b2;
	}

	@Override
	public void run() {
		// TODO save blocks
		
	}
	
	private Block[] getAllBlocks(Block b1, Block b2){
		Block[] blocks = new Block[getCount(b1, b2)];
		//TODO cycle through blocks
	}
	
	private int getCount(Block b1, Block b2){
		int xDiff = b1.getX() - b2.getX();
		int yDiff = b1.getY() - b2.getY();
		int zDiff = b1.getZ() - b2.getZ();
		xDiff = Math.abs(xDiff);
		yDiff = Math.abs(yDiff);
		zDiff = Math.abs(zDiff);
		return xDiff * yDiff * zDiff;
	}
}
