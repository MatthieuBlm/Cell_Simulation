package engine;

import javax.swing.JPanel;

import main.Settings;
import main.SettingsGenerator;
import universe.Universe;
import behavior.CellBehavior;
import cell.WatorCell;

public class WatorEngine extends Engine {
	
	public WatorEngine(Universe universe, JPanel mainPanel, CellBehavior behavior, SettingsGenerator settingsGenerator) {
		super(universe, mainPanel, behavior, settingsGenerator);
	}

	@Override
	public void next() {
		WatorCell tmpCell;
		for (int i = 0; i < Settings.NB_CELL_WIDTH; i++) {
			for (int j = 0; j < Settings.NB_CELL_HEIGH; j++) {
				if(behavior.isSimulable(universe.getCell(i, j))){
					tmpCell = (WatorCell) universe.getCell(i, j);
					if(behavior.canDie(i, j)){
						universe.removeCell(i, j);
					}
					else{
						if(behavior.canMove(i, j)){
							tmpCell = (WatorCell) behavior.move(i, j);
						}
						if(tmpCell.canReproduce()){
							universe.addCell((tmpCell.isShark() ? new WatorCell("shark") : new WatorCell("fish")), i, j);
							tmpCell.initialiseReproductionStep();
						}
						tmpCell.incrementReproductionStep();
						tmpCell.decrementEnergy();
					}

				}
			}
		}
	}
}
