package universe;

import java.awt.Graphics;
import java.util.Random;

import main.Settings;
import cell.Cell;
import cell.WatorCell;

public class WatorUniverse extends SimpleUniverse {
	
	public WatorUniverse() {
		super();
	}
	
	public WatorUniverse(int width, int heigh) {
		super(width, heigh);
	}

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
					map[i][j] = (rand.nextDouble() <= 0.5 ? new WatorCell((rand.nextDouble() <= Settings.CELL_BALANCE ? "shark" : "fish")) : null)  ;
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

	public void printUniverse(){
		for (int j = 0; j < map[0].length; j++) {
			for (int i = 0; i < map.length; i++) {
				if(this.isCell(i, j)){
					if(this.isFish(i, j))
						System.out.print("F ");
					else if(this.isShark(i, j))
						System.out.print("S ");
						
				}else
					System.out.print("O ");
			}
			System.out.println("");
		}
	}
	
	public void printUniverseLimit(int x, int y){
		System.out.print("  ");
		for (int i = 0; i < x; i++) {
			System.out.print(i+" ");
		}
		for (int j = 0; j < y; j++) {
			System.out.print("\n" + j + " ");
			for (int i = 0; i < x; i++) {
				if(this.isCell(i, j)){
					if(this.isFish(i, j))
						System.out.print("F ");
					else if(this.isShark(i, j))
						System.out.print("S ");
				}else
					System.out.print("O ");
			}
		}
	}
}
