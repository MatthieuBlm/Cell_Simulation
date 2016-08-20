package engine;

import java.util.List;
import java.util.Random;

import javax.swing.JPanel;

import behavior.CellBehavior;
import cell.WatorCell;
import main.Couple;
import main.Settings;
import universe.Universe;

public class WatorEngine extends Engine {

	public WatorEngine(Universe universe, JPanel mainPanel, CellBehavior behavior) {
		super(universe, mainPanel, behavior);
	}

	@Override
	public void next() {
		WatorCell tmpCell;
		for (int i = 0; i < Settings.NB_CELL_WIDTH; i++) {
			for (int j = 0; j < Settings.NB_CELL_HEIGH; j++) {
				if(behavior.isSimulable(universe.getCell(i, j))){
					tmpCell = (WatorCell) universe.getCell(i, j);
					tmpCell.decrementEnergy();
					
					if(behavior.canDie(i, j)){
						universe.removeCell(i, j);
					}
					else{
						if(behavior.canMove(i, j)){
							tmpCell = (WatorCell) behavior.move(i, j);
						}
						if(tmpCell.canReproduce()){
							List<Couple<Integer, Integer>> freeCell = behavior.getFreeLocationAround(i, j);
							if(freeCell.size() > 0){
								Couple<Integer, Integer> dest = freeCell.get(new Random().nextInt(freeCell.size()));
								if(tmpCell.isFish())
									universe.addCell(new WatorCell("fish"), (Integer)dest.getV1(), (Integer)dest.getV2());
								else if(tmpCell.isShark())
									universe.addCell(new WatorCell("shark"), (Integer)dest.getV1(), (Integer)dest.getV2());
								else if(tmpCell.isBigFish())
									universe.addCell(new WatorCell("bigfish"), (Integer)dest.getV1(), (Integer)dest.getV2());
								tmpCell.initialiseReproductionStep();
							}
						}
						tmpCell.incrementReproductionStep();
					}

				}
			}
		}
	}
}
