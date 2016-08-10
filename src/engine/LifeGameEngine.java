package engine;

import javax.swing.JPanel;

import universe.Universe;
import behavior.CellBehavior;
import main.Settings;

public class LifeGameEngine extends Engine {
	
	public LifeGameEngine(Universe universe, JPanel mainPanel, CellBehavior behavior) {
		super(universe, mainPanel, behavior);
	}

	public void next(){
		for (int i = 0; i < Settings.NB_CELL_WIDTH; i++) {
			for (int j = 0; j < Settings.NB_CELL_HEIGH; j++) {
				if(behavior.isSimulable(universe.getCell(i, j))){
					if(behavior.canDie(i, j))
						universe.removeCell(i, j);
					else if(behavior.canBorn(i, j))
						universe.addSimpleCell(i, j);
				}
			}
		}
		universe.validateBuffer();
	}
}
