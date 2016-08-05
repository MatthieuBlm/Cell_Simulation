package engine;

import javax.swing.JPanel;

import exception.NotLivingCellException;
import universe.LangtonAntUniverse;
import universe.Universe;
import behavior.CellBehavior;

public class LangtonAntEngine extends Engine {

	public LangtonAntEngine(Universe universe, JPanel mainPanel, CellBehavior behavior){
		super(universe, mainPanel, behavior);
	}
	

	@Override
	public void next() {
		try {
			behavior.move(((LangtonAntUniverse) universe).getAnt().getX(), ((LangtonAntUniverse) universe).getAnt().getY());
		} catch (NotLivingCellException e) {
			e.printStackTrace();
		}
	}
}
