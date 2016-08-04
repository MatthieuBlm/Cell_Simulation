package view;

import javax.swing.JFrame;

import main.Settings;
import model.Univers;

public class Window extends JFrame{
	private Univers univers;
	private MainPanel mainPanel;
	
	public Window(Univers univers, MainPanel mainPanel){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(Settings.APPLICATION_TITLE);
		this.setResizable(false);
		this.univers = univers;
		univers.randomlyBuildUnivers();
		
		this.mainPanel = mainPanel;
		
		this.add(mainPanel);
		this.pack();
	}
}
