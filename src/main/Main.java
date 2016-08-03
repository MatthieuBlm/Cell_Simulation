package main;

import model.Univers;
import view.Window;

public class Main {

	public static void main(String[] args) {
		Window window = new Window(new Univers(Ressources.NB_CELL_WIDTH, Ressources.NB_CELL_HEIGH));
		window.setVisible(true);
	}

}
