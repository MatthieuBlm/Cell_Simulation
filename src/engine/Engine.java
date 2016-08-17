package engine;

import javax.swing.JPanel;

import main.Settings;
import main.SettingsGenerator;
import universe.Universe;
import behavior.CellBehavior;

public abstract class Engine {
	protected Universe universe;
	protected JPanel mainPanel;
	protected CellBehavior behavior;
	private boolean remainingBothSpecies;
	private SettingsGenerator settingsGenerator;
	
	public static boolean isRunning;
	
	public Engine(Universe universe, JPanel mainPanel, CellBehavior behavior){
		this.universe = universe;
		this.mainPanel = mainPanel;
		this.behavior = behavior;
		this.remainingBothSpecies = true;
	}
	
	public Engine(Universe universe, JPanel mainPanel, CellBehavior behavior, SettingsGenerator settingsGenerator){
		this.universe = universe;
		this.mainPanel = mainPanel;
		this.behavior = behavior;
		this.remainingBothSpecies = true;
		this.settingsGenerator = settingsGenerator;
		isRunning = false;
	}
	
	public void start(){
		universe.initUniverse();
		
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(remainingBothSpecies){
					Engine.this.next();
					mainPanel.repaint();
					remainingBothSpecies = universe.remainingBothSpecies();
					try {
						Thread.sleep(Settings.PARIOD_DURATION);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				SettingsGenerator.endTimestamp = System.currentTimeMillis();
				if(settingsGenerator.isBestResult()){
					System.out.println("New best result find !");
					settingsGenerator.saveSettings();
					settingsGenerator.printBestResult();
				}
				Engine.isRunning = false;
			}
		});
		thread.start();
	}
	
	public abstract void next();
	
}
