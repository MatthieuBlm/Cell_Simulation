package behavior;

import model.Universe;
import exception.NotLivingCellException;

public abstract class CellBehavior {
	protected Universe universe;
	
	public CellBehavior(Universe universe){
		this.universe = universe;
	}
	
	/**
	 * Inform if a cell can born at the (x, y) location.
	 * @param x Horizontal cell position.
	 * @param y Vertical cell position.
	 * @return True if a cell can born at (x, y) with such a universe.
	 */
	public abstract boolean canBorn(int x, int y);
	
	/**
	 * Inform if a cell can die at the (x, y) location, only if a living cell is living at this location.
	 * @param x Horizontal cell position.
	 * @param y Vertical cell position.
	 * @return True if the giving cell can die at (x, y) with such a universe, false otherwise.
	 * @throws NotLivingCellException If there is no living cell at (x, y) location.
	 */
	public abstract boolean canDie(int x, int y) throws NotLivingCellException;
	
	/**
	 * Inform if a cell at the location (x, y) can move.
	 * @param x Horizontal cell position.
	 * @param y Vertical cell position.
	 * @return True if the giving cell can move with such a universe, false otherwise.
	 * @throws NotLivingCellException If there is no living cell at (x, y) location.
	 */
	public abstract boolean canMove(int x, int y) throws NotLivingCellException;
	
	/**
	 * Describe the cell move behavior. Make the giving cell at location (x, y) move to an other location.
	 * @param x Horizontal cell position.
	 * @param y Vertical cell position.
	 * @throws NotLivingCellException If there is no living cell at (x, y) location.
	 */
	public abstract void move(int x, int y) throws NotLivingCellException;
	
	/**
	 * Specify whether the given object can be subject to behavioral rules.
	 * @param object The object to be tested.
	 * @return True if the given object can be simulate, false otherwise.
	 */
	public abstract boolean isSimulable(Object object);
}
