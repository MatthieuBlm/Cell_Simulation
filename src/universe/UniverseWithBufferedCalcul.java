package universe;

import cell.Cell;
import cell.SimpleCell;
import main.Settings;

public abstract class UniverseWithBufferedCalcul extends Universe {
	protected Object [][] bufferedMap;

	public UniverseWithBufferedCalcul() {
		super();
		bufferedMap = new Object[Settings.NB_CELL_WIDTH][Settings.NB_CELL_HEIGH];
	}
	
	public void validateBuffer(){
		for (int i = 0; i < Settings.NB_CELL_WIDTH; i++) {
			for (int j = 0; j < Settings.NB_CELL_HEIGH; j++) {
				map[i][j] = bufferedMap[i][j];
			}
		}
	}
	
	@Override
	public void addSimpleCell(int x, int y){
		bufferedMap[x][y] = new SimpleCell();
	}
	
	@Override
	public void addObject(Object object, int x, int y){
		bufferedMap[x][y] = object;
	}
	
	@Override
	public void removeCell(int x, int y){
		bufferedMap[x][y] = null;
	}

	@Override
	public void addCell(Cell cell, int	x, int y) {
		bufferedMap[x][y] = cell;
	}

}
