package universe;

import java.awt.Graphics;

import cell.Cell;
import main.Settings;

public abstract class Universe {
	protected Object [][] map;

	public Universe(){
		map = new Object[Settings.NB_CELL_WIDTH][Settings.NB_CELL_HEIGH];
		this.initUniverse();
	}
	
	public Universe(int width, int heigh){
		if(width != Settings.NB_CELL_WIDTH || heigh != Settings.NB_CELL_HEIGH)
			System.out.println("[WARN] The universe dimentions are different from the settings.");
		
		map = new Object[width][heigh];
	}
	
	public abstract void initUniverse();
	public abstract void drawSpecialCell(Graphics g);
	public abstract void addSimpleCell(int x, int y);
	public abstract void addObject(Object object, int x, int y);
	public abstract void removeCell(int x, int y);
	public abstract void addCell(Cell cell, int x, int y);
	
	public Object getObject(int x, int y){
		return map[x][y];
	}
	
	public boolean isCell(int x, int y){
		return map[x][y] instanceof Cell;
	}
	
	public Cell getCell(int x, int y){
		return  (map[x][y] instanceof Cell ? (Cell) map[x][y] : null);
	}
	
}
