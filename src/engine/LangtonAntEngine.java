package engine;

import javax.swing.JPanel;

import behavior.CellBehavior;
import universe.LangtonAntUniverse;
import universe.Universe;
import universe.UniverseWithBufferedCalcul;

public class LangtonAntEngine extends Engine {

	public LangtonAntEngine(Universe universe, JPanel mainPanel, CellBehavior behavior){
		super((UniverseWithBufferedCalcul) universe, mainPanel, behavior);
	}
	
	@Override
	public void next() {
		behavior.move(((LangtonAntUniverse) universe).getAnt().getX(), ((LangtonAntUniverse) universe).getAnt().getY());
	}
}
