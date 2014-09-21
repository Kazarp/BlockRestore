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
		//TODO implement
	}

}
