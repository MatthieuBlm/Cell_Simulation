package main;

import model.Engine;
import model.Universe;
import view.MainPanel;
import view.Window;

public class Main {

	public static void main(String[] args) {
		Universe univers = new Universe(Settings.NB_CELL_WIDTH, Settings.NB_CELL_HEIGH);
		MainPanel mainPanel = new MainPanel(univers);
		Window window = new Window(univers, mainPanel);
		Engine engine = new Engine(univers, mainPanel);
		
		window.setVisible(true);
		engine.start();
	}
}
