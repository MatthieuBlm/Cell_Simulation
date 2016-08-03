package model;

import java.util.Random;

public class Cell {
	private int x;
	private int y;
	private Random rand;
	
	public Cell(int x, int y){
		this.x = x;
		this.y = y;
		rand = new Random();
	}
}
