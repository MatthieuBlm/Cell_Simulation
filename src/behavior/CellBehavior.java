package behavior;

import model.Universe;
import exception.NotLivingCellException;

public interface CellBehavior {
	/**
	 * Inform if a cell can born at the (x, y) location.
	 * @param univers The simulation universe.
	 * @param x Horizontal cell position.
	 * @param y Vertical cell position.
	 * @return True if a cell can born at (x, y) with such a universe.
	 */
	public boolean canBorn(Universe universe, int x, int y);
	
	/**
	 * Inform if a cell can die at the (x, y) location, only if a living cell is living at this location.
	 * @param univers The simulation universe.
	 * @param x Horizontal cell position.
	 * @param y Vertical cell position.
	 * @return True if the giving cell can die at (x, y) with such a universe, false otherwise.
	 * @throws NotLivingCellException If there is no living cell at (x, y) location.
	 */
	public boolean canDie(Universe universe, int x, int y) throws NotLivingCellException;
	
	/**
	 * Inform if a cell at the location (x, y) can move.
	 * @param univers The simulation universe.
	 * @param x Horizontal cell position.
	 * @param y Vertical cell position.
	 * @return True if the giving cell can move with such a universe, false otherwise.
	 * @throws NotLivingCellException If there is no living cell at (x, y) location.
	 */
	public boolean canMove(Universe universe, int x, int y) throws NotLivingCellException;
	
	/**
	 * Describe the cell move behavior. Make the giving cell at location (x, y) move to an other location.
	 * @param univers The simulation universe.
	 * @param x Horizontal cell position.
	 * @param y Vertical cell position.
	 * @throws NotLivingCellException If there is no living cell at (x, y) location.
	 */
	public void move(Universe universe, int x, int y) throws NotLivingCellException;
}
