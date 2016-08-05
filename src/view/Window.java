package view;

import javax.swing.JFrame;

import main.Settings;

public class Window extends JFrame{
	private static final long serialVersionUID = -3972758798101675963L;
	
	public Window(MainPanel mainPanel){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(Settings.APPLICATION_TITLE);
		this.setResizable(false);
		
		this.add(mainPanel);
		this.pack();
	}
}
