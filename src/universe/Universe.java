package universe;

import java.awt.Graphics;

import cell.Cell;
import main.Settings;

public abstract class Universe {
	protected Object [][] map;
	protected Object [][] bufferedMap;

	public Universe(){
		map = new Object[Settings.NB_CELL_WIDTH][Settings.NB_CELL_HEIGH];
		bufferedMap = new Object[Settings.NB_CELL_WIDTH][Settings.NB_CELL_HEIGH];
	}
	
	public void validateBuffer(){
		for (int i = 0; i < Settings.NB_CELL_WIDTH; i++) {
			for (int j = 0; j < Settings.NB_CELL_HEIGH; j++) {
				map[i][j] = bufferedMap[i][j];
			}
		}
	}
	
	public abstract void initUniverse();
	public abstract void drawSpecialCell(Graphics g);
	
	public Object getObject(int x, int y){
		return map[x][y];
	}
	
	public boolean isCell(int x, int y){
		return map[x][y] instanceof Cell;
	}
	
	public Cell getCell(int x, int y){
		return  (map[x][y] instanceof Cell ? (Cell) map[x][y] : null);
	}
	
	public void addCell(int x, int y){
		bufferedMap[x][y] = new Cell();
	}
	
	public void removeCell(int x, int y){
		bufferedMap[x][y] = null;
	}

}
