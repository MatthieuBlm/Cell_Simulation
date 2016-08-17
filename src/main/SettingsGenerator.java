package main;

import java.util.Random;

public class SettingsGenerator {
	private Random rand;
	private int attempt;

	private long bestSimulationDuration;
	private double bestCellBalance;
	private int bestSharkEnergie;
	private int bestSharkReproductionSteps;
	private int bestFishReproductionSteps;
	
	public static long startTimestamp;
	public static long endTimestamp;
	
	public SettingsGenerator(){
		this.rand = new Random();
		this.attempt = 0;
		bestSimulationDuration = 0;
	}
	
	/**
	 * Generate next settings values to be tested.
	 * @return The attempt number.
	 */
	public synchronized int next(){
		Settings.CELL_BALANCE = rand.nextDouble();
		Settings.SHARK_ENERGIE = rand.nextInt(100) + 1;
		Settings.SHARK_REPRODUCTION_STEPS = rand.nextInt(Settings.SHARK_ENERGIE);
		Settings.FISH_REPRODUCTION_STEPS = rand.nextInt(100);
		return ++attempt;
	}
	
	public synchronized boolean isBestResult(){
		return (endTimestamp - startTimestamp) > bestSimulationDuration;
	}
	
	public synchronized void saveSettings(){
		bestCellBalance = Settings.CELL_BALANCE;
		bestSharkEnergie = Settings.SHARK_ENERGIE;
		bestSharkReproductionSteps = Settings.SHARK_REPRODUCTION_STEPS;
		bestFishReproductionSteps = Settings.FISH_REPRODUCTION_STEPS;
		bestSimulationDuration = endTimestamp - startTimestamp;
	}
	
	public synchronized void printBestResult(){
		System.out.println("Best cell balance : "+bestCellBalance);
		System.out.println("Best shark energie : "+bestSharkEnergie);
		System.out.println("Best shark reproduction steps : "+bestSharkReproductionSteps);
		System.out.println("Best fish reproduction steps : "+bestFishReproductionSteps);
		System.out.println("Performed in : "+bestSimulationDuration+" ms.");
	}
	
	public synchronized void printTestedValues(){
		System.out.println("Tested cell balance : "+Settings.CELL_BALANCE);
		System.out.println("Tested shark energie : "+Settings.SHARK_ENERGIE);
		System.out.println("Tested shark reproduction steps : "+Settings.SHARK_REPRODUCTION_STEPS);
		System.out.println("Tested fish reproduction steps : "+Settings.FISH_REPRODUCTION_STEPS);
	}
}
