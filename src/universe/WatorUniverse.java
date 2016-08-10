package universe;

import java.awt.Graphics;
import java.util.Random;

import cell.WatorCell;
import main.Settings;

public class WatorUniverse extends Universe {
	
	@Override
	public void initUniverse() {
		this.buildRandomlyUniverse();
	}

	/**
	 * Randomly build a new universe which is fill with WatorEntity according to Settings.CELL_RATE.
	 * Among alive cell, there are 50% of fish and 50% of sharks
	 */
	private void buildRandomlyUniverse(){
		Random rand = new Random();
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if(rand.nextDouble() <= Settings.CELL_RATE){
					map[i][j] = (rand.nextDouble() <= 0.5 ? new WatorCell((rand.nextDouble() <= 0.5 ? "shark" : "fish")) : null)  ;
				}
			}
		}
	}
	
	@Override
	public void drawSpecialCell(Graphics g) {
		// TODO Auto-generated method stub

	}

}
