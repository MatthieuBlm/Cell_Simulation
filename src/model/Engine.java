package model;

import javax.swing.JPanel;

import main.Settings;
import behavior.CellBehavior;
import exception.NotLivingCellException;

public class Engine {
	private Universe universe;
	private JPanel mainPanel;
	private CellBehavior behavior;
	
	public Engine(Universe universe, JPanel mainPanel, CellBehavior behavior){
		this.universe = universe;
		this.mainPanel = mainPanel;
		this.behavior = behavior;
	}
	
	public void start(){
		universe.randomlyBuildUnivers();
//		universe.buildOscillator();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true){
					Engine.this.next();
					mainPanel.repaint();
					try {
						Thread.sleep(Settings.PARIOD_DURATION);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
	
	public void next(){
		for (int i = 0; i < Settings.NB_CELL_WIDTH; i++) {
			for (int j = 0; j < Settings.NB_CELL_HEIGH; j++) {
				if(behavior.isSimulable(universe.getCell(i, j))){
					try {
						if(behavior.canDie(i, j))
							universe.kill(i, j);
						else if(behavior.canBorn(i, j))
							universe.addCell(i, j);
					} catch (NotLivingCellException e) {
						e.printStackTrace();
					}
				}
			}
		}
		universe.validateBuffer();
	}
}
