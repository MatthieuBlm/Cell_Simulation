package main;

import model.Engine;
import model.Univers;
import view.MainPanel;
import view.Window;

public class Main {

	public static void main(String[] args) {
		Univers univers = new Univers(Settings.NB_CELL_WIDTH, Settings.NB_CELL_HEIGH);
		MainPanel mainPanel = new MainPanel(univers);
		Window window = new Window(univers, mainPanel);
		Engine engine = new Engine(univers, mainPanel);
		
		window.setVisible(true);
		engine.start();
	}
}
