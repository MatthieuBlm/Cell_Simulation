package main;

import universe.LangtonAntUniverse;
import universe.LifeGameUniverse;
import universe.Universe;
import universe.WatorUniverse;
import view.MainPanel;
import view.Window;
import behavior.CellBehavior;
import behavior.LangtonAntBehavior;
import behavior.LifeGameBehavior;
import behavior.WatorBehavior;
import engine.Engine;
import engine.LangtonAntEngine;
import engine.LifeGameEngine;
import engine.WatorEngine;

public class Main {
	private static Universe universe;
	private static MainPanel mainPanel;
	private static CellBehavior behavior;
	private static Engine engine;
	private static Window window;
	
	public static void main(String[] args) {

		switch(args[0]){
		case "LifeGame":
			universe = new LifeGameUniverse();
			behavior = new LifeGameBehavior(universe);
			mainPanel = new MainPanel(universe);
			window = new Window(mainPanel);
			engine = new LifeGameEngine(universe, mainPanel, behavior);
			break;
		case "LangtonsAnt":
			universe = new LangtonAntUniverse();
			behavior = new LangtonAntBehavior(universe);
			mainPanel = new MainPanel(universe);
			window = new Window(mainPanel);
			engine = new LangtonAntEngine(universe, mainPanel, behavior);
			break;
		case "Wator":
			universe = new WatorUniverse();
			behavior = new WatorBehavior(universe);
			mainPanel = new MainPanel(universe);
			window = new Window(mainPanel);
			engine = new WatorEngine(universe, mainPanel, behavior);
			default:
				System.err.println("[Error] Unknown mode.");
				return;
		}

		window.setVisible(true);
		engine.start();
	}
}
