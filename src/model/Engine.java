package model;

import javax.swing.JPanel;

import main.Settings;

public class Engine {
	private Univers univers;
	private JPanel mainPanel;
	
	public Engine(Univers univers, JPanel mainPanel){
		this.univers = univers;
		this.mainPanel = mainPanel;
	}
	
	public void start(){
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
		
	}
}
