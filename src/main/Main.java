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
		if(args.length == 0){
			System.err.println("[Error] No parameter.");
			return;
		}
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
			if(args.length > 2 && args[1].equals("load")){
				FileLoader fileLoader = new FileLoader(args[2], "Wator");
				if(fileLoader.loadFile())
					universe = fileLoader.getUniverse();
				else
					universe = new WatorUniverse();
			}else
				universe = new WatorUniverse();
			
			behavior = new WatorBehavior(universe);
			mainPanel = new MainPanel(universe);
			window = new Window(mainPanel);
			engine = new WatorEngine(universe, mainPanel, behavior);
			break;
			default:
				System.err.println("[Error] Unknown mode : "+args[0]);
				return;
		}

		window.setVisible(true);
		engine.start();
	}
}
