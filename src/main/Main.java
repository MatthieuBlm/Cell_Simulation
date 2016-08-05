package main;

import universe.LangtonAntUniverse;
import universe.Universe;
import view.MainPanel;
import view.Window;
import behavior.CellBehavior;
import behavior.LangtonAntBehavior;
import engine.Engine;
import engine.LangtonAntEngine;

public class Main {

	public static void main(String[] args) {
		Universe universe = new LangtonAntUniverse();
		MainPanel mainPanel = new MainPanel(universe);
		CellBehavior behavior = new LangtonAntBehavior(universe);
		Engine engine = new LangtonAntEngine(universe, mainPanel, behavior);

		Window window = new Window(mainPanel);
		window.setVisible(true);
		
		engine.start();
	}
}
