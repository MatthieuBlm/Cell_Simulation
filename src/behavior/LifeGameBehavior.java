package behavior;

import model.Universe;
import exception.NotLivingCellException;

public class LifeGameBehavior extends CellBehavior{

	public LifeGameBehavior(Universe universe) {
		super(universe);
	}

	@Override
	public boolean canBorn(int x, int y) {
		return (this.getNeighbourNumber(x, y) == 3) && (universe.getObject(x, y) == null);
	}

	@Override
	public boolean canDie(int x, int y) throws NotLivingCellException {
		return this.getNeighbourNumber(x, y) != 2 && 
				this.getNeighbourNumber(x, y) != 3 && 
				universe.getCell(x, y) != null;
	}

	@Override
	public boolean canMove(int x, int y) {
		return false;
	}

	@Override
	public void move(int x, int y) {}
	
	@Override
	public boolean isSimulable(Object object) {
		return true;
	}
	
	/**
	 * Counts the number of living cell in the eight cells surrounding the giving cell at (x, y) location.
	 * @param x Horizontal cell position.
	 * @param y Vertical cell position.
	 * @return The number of living cell around the giving cell.
	 */
	private int getNeighbourNumber(int x, int y){
		int neighbourNumber = 0;
		
		try{
			if(universe.isCell(x - 1, y - 1)) 	neighbourNumber++;
			if(universe.isCell(x - 1, y)) 		neighbourNumber++;
			if(universe.isCell(x - 1, y + 1))	neighbourNumber++;
			if(universe.isCell(x, y - 1)) 		neighbourNumber++;
			if(universe.isCell(x, y + 1)) 		neighbourNumber++;
			if(universe.isCell(x + 1, y - 1)) 	neighbourNumber++;
			if(universe.isCell(x + 1, y)) 		neighbourNumber++;
			if(universe.isCell(x + 1, y + 1)) 	neighbourNumber++;
		}catch(ArrayIndexOutOfBoundsException e){}
		
		return neighbourNumber;
	}

}
