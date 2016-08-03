package view;

import javax.swing.JFrame;

import main.Ressources;
import model.Univers;

public class Window extends JFrame{
	private Univers univers;
	private MainPanel mainPanel;
	
	public Window(Univers univers){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(Ressources.APPLICATION_TITLE);
		this.setResizable(false);
		this.univers = univers;
		univers.randomlyBuildUnivers();
		
		mainPanel = new MainPanel(univers);
		
		this.add(mainPanel);
		this.pack();
	}
}
