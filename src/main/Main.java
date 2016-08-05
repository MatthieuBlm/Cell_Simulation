package main;

import behavior.CellBehavior;
import behavior.LifeGameBehavior;
import model.Engine;
import model.Universe;
import view.MainPanel;
import view.Window;

public class Main {

	public static void main(String[] args) {
		Universe universe = new Universe();
		MainPanel mainPanel = new MainPanel(universe);
		CellBehavior behavior = new LifeGameBehavior(universe);
		Engine engine = new Engine(universe, mainPanel, behavior);

		Window window = new Window(mainPanel);
		window.setVisible(true);
		
		engine.start();
	}
}
