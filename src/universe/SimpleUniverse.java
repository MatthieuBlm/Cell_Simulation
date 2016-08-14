package universe;

import cell.Cell;
import cell.SimpleCell;

public abstract class SimpleUniverse extends Universe {

	public SimpleUniverse(){
		super();
	}
	
	@Override
	public void addSimpleCell(int x, int y){
		map[x][y] = new SimpleCell();
	}
	
	@Override
	public void addObject(Object object, int x, int y){
		map[x][y] = object;
	}
	
	@Override
	public void removeCell(int x, int y){
		map[x][y] = null;
	}

	@Override
	public void addCell(Cell cell, int	x, int y) {
		map[x][y] = cell;
	}
}
