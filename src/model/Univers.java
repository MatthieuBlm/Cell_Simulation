package model;

import java.util.Random;

import main.Ressources;

public class Univers {
	private Object [][] map;
	
	public Univers(int width, int heigh){
		map = new Object[width][heigh];
	}
	
	public void randomlyBuildUnivers(){
		Random rand = new Random();
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				map[i][j] = (rand.nextDouble() <= Ressources.CELL_RATE ? new Cell(i, j) : null);
			}
		}
	}
	
	public boolean isCell(int x, int y){
		return map[x][y] instanceof Cell;
	}
	
	public int getWidth(){
		return map.length;
	}

	public int getHeigh(){
		return map[0].length;
	}
}
