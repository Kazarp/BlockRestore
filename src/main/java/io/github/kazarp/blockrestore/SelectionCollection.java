package io.github.kazarp.blockrestore;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class SelectionCollection {
	static List<Selection> selections = new ArrayList<Selection>();
	
	public static void setBlock1(Player p, Block b1){
		for(int i = 0; i < selections.size(); i++){
			if(selections.get(i).getBlock2().getLocation() == b1.getLocation()){
				return;
			}
			if(Selection.comparePlayers(p, selections.get(i).getPlayer())){
				selections.get(i).setBlock1(b1);
				Message.send("You selected the first block", p);
				return;
			}
		}
		add(p, b1, null);
		Message.send("You selected the first block", p);
	}
	
	public static void setBlock2(Player p, Block b2){
		for(int i = 0; i < selections.size(); i++){
			if(Selection.comparePlayers(p, selections.get(i).getPlayer())){
				if(selections.get(i).getBlock2().getLocation() == b2.getLocation()){
					return;
				}
				selections.get(i).setBlock1(b2);
				Message.send("You selected the second block", p);
				return;
			}
		}
		add(p, null, b2);
		Message.send("You selected the second block", p);
	}
	
	// "add" Methods' overloads
	public static void add(Selection s){
		selections.add(s);
	}
	public static void add(Player p, Block b1, Block b2){
		add(new Selection(p, b1, b2));
	}
	public static void add(Player p, int x1, int y1, int z1, int x2, int y2, int z2){
		add(new Selection(p, x1, y1, z1, x2 ,y2, z2));
	}
	
	public static void clear(){
		selections.clear();
	}
}
