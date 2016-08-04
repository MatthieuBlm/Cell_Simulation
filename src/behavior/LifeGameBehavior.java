package behavior;

import model.Universe;
import exception.NotLivingCellException;

public class LifeGameBehavior implements CellBehavior{

	@Override
	public boolean canBorn(Universe universe, int x, int y) {
		return (this.getNeighbourNumber(universe, x, y) == 3);
	}

	@Override
	public boolean canDie(Universe universe, int x, int y) throws NotLivingCellException {
		return (this.getNeighbourNumber(universe, x, y) != 2 && this.getNeighbourNumber(universe, x, y) != 3);
	}

	@Override
	public boolean canMove(Universe universe, int x, int y) {
		return false;
	}

	@Override
	public void move(Universe universe, int x, int y) {}
	
	/**
	 * Counts the number of living cell in the eight cells surrounding the giving cell at (x, y) location.
	 * @param universe The simulation universe.
	 * @param x Horizontal cell position.
	 * @param y Vertical cell position.
	 * @return The number of living cell around the giving cell.
	 */
	private int getNeighbourNumber(Universe universe, int x, int y){
		int neighbourNumber = 0;
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(universe.isCell(x + i, y + j))
					neighbourNumber++;
			}
		}
		
		return neighbourNumber - 1;
	}
}
