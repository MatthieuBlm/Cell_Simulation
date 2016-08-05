package universe;

import java.awt.Graphics;
import java.util.Random;

import cell.Cell;
import main.Settings;

public class LifeGameUniverse extends Universe{
	
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
				bufferedMap[i][j] = (rand.nextDouble() <= Settings.CELL_RATE ? new Cell() : null);
			}
		}
		
		validateBuffer();
	}
	
	public void buildOscillator(){
		bufferedMap[3][3] = new Cell();
		bufferedMap[3][4] = new Cell();
		bufferedMap[3][5] = new Cell();
		
		validateBuffer();
	}

	@Override
	public void drawSpecialCell(Graphics g) {}
	
}
