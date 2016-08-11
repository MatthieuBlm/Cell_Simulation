package universe;

import java.awt.Graphics;
import java.util.Random;

import main.Settings;
import cell.Cell;
import cell.WatorCell;

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
	
	public boolean isShark(int x, int y){
		Cell cell = this.getCell(x, y);
		if(!(cell instanceof WatorCell))
			return false;
		if(((WatorCell) cell).isShark())
			return true;
		return false;
	}
	
	public boolean isFish(int x, int y){
		Cell cell = this.getCell(x, y);
		if(!(cell instanceof WatorCell))
			return false;
		if(((WatorCell) cell).isFish())
			return true;
		return false;
	}
	
	@Override
	public void drawSpecialCell(Graphics g) {
		// TODO Auto-generated method stub

	}

}
