package view;

import javax.swing.JFrame;

import main.Settings;
import model.Universe;

public class Window extends JFrame{
	private Universe universe;
	private MainPanel mainPanel;
	
	public Window(Universe universe, MainPanel mainPanel){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(Settings.APPLICATION_TITLE);
		this.setResizable(false);
		this.universe = universe;
		universe.randomlyBuildUnivers();
		
		this.mainPanel = mainPanel;
		
		this.add(mainPanel);
		this.pack();
	}
}
