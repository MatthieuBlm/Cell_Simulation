package main;

import java.util.ArrayList;
import java.util.List;

public class CellAround {
	private int x;
	private int y;
	
	public CellAround(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Useful to get a List of location of all cell around (x, y).
	 * @return A list of Couple that describe all cell around (x, y).
	 */
	public List<Couple<Integer, Integer>> getAllCellLocationAroundThis(){
		List<Couple<Integer, Integer>> list = new ArrayList<>();
		list.add(new Couple<Integer, Integer> (x, y - 1));
		list.add(new Couple<Integer, Integer> (x, y + 1));
		list.add(new Couple<Integer, Integer> (x - 1, y - 1));
		list.add(new Couple<Integer, Integer> (x - 1, y));
		list.add(new Couple<Integer, Integer> (x - 1, y + 1));
		list.add(new Couple<Integer, Integer> (x + 1, y - 1));
		list.add(new Couple<Integer, Integer> (x + 1, y));
		list.add(new Couple<Integer, Integer> (x + 1, y + 1));
		return list;
	}
}
