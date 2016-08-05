package model;

import java.util.Random;

import main.Settings;

public class Universe {
	private Object [][] map;
	private Object [][] bufferedMap;
	
	public Universe(){
		map = new Object[Settings.NB_CELL_WIDTH][Settings.NB_CELL_HEIGH];
		bufferedMap = new Object[Settings.NB_CELL_WIDTH][Settings.NB_CELL_HEIGH];
	}
	
	public void randomlyBuildUnivers(){
		Random rand = new Random();
		
		for (int i = 0; i < Settings.NB_CELL_WIDTH; i++) {
			for (int j = 0; j < Settings.NB_CELL_HEIGH; j++) {
				bufferedMap[i][j] = (rand.nextDouble() <= Settings.CELL_RATE ? new Cell() : null);
			}
		}
		
		validateBuffer();
	}
	
	public void buildOscillator(){
		bufferedMap[3][3] = new Cell();
		bufferedMap[3][4] = new Cell();
		bufferedMap[3][5] = new Cell();
		
		validateBuffer();
	}
	
	public void validateBuffer(){
		for (int i = 0; i < Settings.NB_CELL_WIDTH; i++) {
			for (int j = 0; j < Settings.NB_CELL_HEIGH; j++) {
				map[i][j] = bufferedMap[i][j];
			}
		}
	}
	
	public void addCell(int x, int y){
		bufferedMap[x][y] = new Cell();
	}
	
	public void kill(int x, int y){
		bufferedMap[x][y] = null;
	}
	
	public Cell getCell(int x, int y){
		return  (map[x][y] instanceof Cell ? (Cell) map[x][y] : null);
	}
	
	public Object getObject(int x, int y){
		return map[x][y];
	}
	
	public boolean isCell(int x, int y){
		return map[x][y] instanceof Cell;
	}
}
