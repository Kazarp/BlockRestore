package io.github.kazarp.blockrestore;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class SelectionCollection {
	static List<Selection> selections = new ArrayList<Selection>();
	
	public static Selection getSelectionByPlayer(Player p){
		for(int i = 0; i < selections.size(); i++){
			if(Selection.comparePlayers(selections.get(i).getPlayer(), p)){
				return selections.get(i);
			}
		}
		return null;
	}
	
	public static void setBlock1(Player p, Block b1){
		//TODO implement
		// If is the Player in the collection, set his b1, else add new record
	}
	public static void setBlock2(Player p, Block b2){
		//TODO implement
	}
	
	public static void add(Selection s){
		Selection testS = getSelectionByPlayer(s.getPlayer());
		if(testS != null){
			selections.set(selections.indexOf(testS), s);
		}
		else{
			selections.add(s);
		}
	}
	public static void add(Player p, Block b1, Block b2){
		add(new Selection(p, b1, b2));
	}
	public static void add(Player p, int x1, int y1, int z1, int x2, int y2, int z2){
		add(new Selection(p, x1, y1, z1, x2 ,y2, z2));
	}
	
	
	public static boolean containsPlayer(Player p){
		return getSelectionByPlayer(p) != null;
	}
	public static void clear(){
		selections.clear();
	}
}
