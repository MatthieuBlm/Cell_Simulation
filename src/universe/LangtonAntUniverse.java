package universe;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import cell.Ant;
import cell.SimpleCell;
import main.Settings;

public class LangtonAntUniverse extends UniverseWithBufferedCalcul {
	private Ant ant;
	
	@Override
	public void initUniverse() {
		for (int i = 0; i < Settings.NB_CELL_WIDTH; i++) {
			for (int j = 0; j < Settings.NB_CELL_HEIGH; j++) {
				bufferedMap[i][j] = new SimpleCell(Color.WHITE);
			}
		}
		
		validateBuffer();
		
		ant = new Ant(Settings.NB_CELL_WIDTH / 2, Settings.NB_CELL_HEIGH / 2);
	}
	
	public void randomlyBuildUnivers(){
		Random rand = new Random();
		
		for (int i = 0; i < Settings.NB_CELL_WIDTH; i++) {
			for (int j = 0; j < Settings.NB_CELL_HEIGH; j++) {
				bufferedMap[i][j] = (rand.nextDouble() <= Settings.CELL_RATE ? new SimpleCell(Color.BLACK) : new SimpleCell(Color.WHITE));
			}
		}
		
		validateBuffer();
		
		ant = new Ant(Settings.NB_CELL_WIDTH / 2, Settings.NB_CELL_HEIGH / 2);
	}
	
	@Override
	public void drawSpecialCell(Graphics g) {
		g.setColor(ant.getCellColor());
		g.fillRect(ant.getX() * Settings.CELL_SIZE_X, ant.getY() * Settings.CELL_SIZE_Y, Settings.CELL_SIZE_X, Settings.CELL_SIZE_Y);
	}
	
	public Ant getAnt(){
		return ant;
	}

	@Override
	public boolean remainingBothSpecies() {
		// TODO Auto-generated method stub
		return false;
	}

}
