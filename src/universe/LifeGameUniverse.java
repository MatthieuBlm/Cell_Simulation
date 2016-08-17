package universe;

import java.awt.Graphics;
import java.util.Random;

import cell.SimpleCell;
import main.Settings;

public class LifeGameUniverse extends UniverseWithBufferedCalcul{
	
	public LifeGameUniverse(){
		super();
	}
	
	public void initUniverse(){
		this.randomlyBuildUnivers();
	}
	
	public void randomlyBuildUnivers(){
		Random rand = new Random();
		
		for (int i = 0; i < Settings.NB_CELL_WIDTH; i++) {
			for (int j = 0; j < Settings.NB_CELL_HEIGH; j++) {
				bufferedMap[i][j] = (rand.nextDouble() <= Settings.CELL_RATE ? new SimpleCell() : null);
			}
		}
		
		validateBuffer();
	}
	
	public void buildOscillator(){
		bufferedMap[3][3] = new SimpleCell();
		bufferedMap[3][4] = new SimpleCell();
		bufferedMap[3][5] = new SimpleCell();
		
		validateBuffer();
	}

	@Override
	public void drawSpecialCell(Graphics g) {}

	@Override
	public boolean remainingBothSpecies() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
