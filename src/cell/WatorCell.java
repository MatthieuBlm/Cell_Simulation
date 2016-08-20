package cell;

import java.awt.Color;

import main.Settings;

public class WatorCell extends Cell {
	private String type;				// Shark / Fish
	private int reproductionStep;		// When reproductionStep == Settings.REPRODUCTION_STEPS, a new cell appear
	private int energy;					// Only used for shark
	
	public WatorCell(String type){
		super();
		this.type = type.toLowerCase();
		switch(type.toLowerCase()){
		case "shark":
			this.setCellColor(Color.BLUE);
			energy = Settings.SHARK_ENERGIE;
			break;
		case "bigfish":
			this.setCellColor(Color.MAGENTA);
			energy = Settings.BIG_FISH_ENERGIE;
		case "fish":
			this.setCellColor(Color.GREEN);
			break;
		}
		reproductionStep = 0;
	}
	
	/**
	 * Only used when clone() is called.
	 * @param type The cell type.
	 * @param energy The amount of cell energy.
	 * @param reproductionStep The state of reproduction.
	 */
	private WatorCell(String type, int energy, int reproductionStep){
		this.type = type.toLowerCase();
		this.energy = energy;
		this.reproductionStep = reproductionStep;
		
		switch(type.toLowerCase()){
		case "shark":
			this.setCellColor(Color.BLUE);
			break;
		case "bigfish":
			this.setCellColor(Color.MAGENTA);
			break;
		case "fish":
			this.setCellColor(Color.GREEN);
			break;
		}
	}
	
	public WatorCell clone(){
		return new WatorCell(this.type, this.energy, this.reproductionStep);
	}
	
	public boolean isShark(){
		return this.type.equalsIgnoreCase("shark");
	}
	
	public boolean isFish(){
		return this.type.equalsIgnoreCase("fish");
	}

	public boolean isBigFish() {
		return this.type.equalsIgnoreCase("bigfish");
	}

	public int getEnergy() {
		return energy;
	}

	public void decrementEnergy() {
		--this.energy ;
	}
	
	public void initialiseEnergy() {
		this.energy = Settings.SHARK_ENERGIE;
	}
	
	public int getReproductionStep() {
		return reproductionStep;
	}

	public void incrementReproductionStep() {
		++this.reproductionStep;
	}
	
	public void initialiseReproductionStep() {
		this.reproductionStep = 0;
	}

	public boolean canReproduce() {
		if(this.isFish())
			return this.reproductionStep >= Settings.FISH_REPRODUCTION_STEPS;
		else if(this.isShark())
			return this.reproductionStep >= Settings.SHARK_REPRODUCTION_STEPS;
		else if(this.isBigFish())
			return this.reproductionStep >= Settings.BIG_FISH_REPRODUCTION_STEPS;
		return false;
	}


	public void increaseEnergy(int i) {
		this.energy += i;
	}
}
