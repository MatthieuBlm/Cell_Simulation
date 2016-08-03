package view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import main.Ressources;
import model.Univers;

public class MainPanel extends JPanel{
	private Univers univers;
	private int nbCellHeigh;
	private int nbCellWidth;
	private int pixelWidthOfCell;
	private int pixelHeighOfCell;
	
	public MainPanel(Univers univers){
		this.univers = univers;
		this.nbCellWidth = univers.getWidth();
		this.nbCellHeigh = univers.getHeigh();
		
		this.setPreferredSize(new Dimension(Ressources.WINDOW_SIZE_X, Ressources.WINDOW_SIZE_Y));
		
		pixelWidthOfCell = Ressources.WINDOW_SIZE_X / nbCellWidth;
		pixelHeighOfCell = Ressources.WINDOW_SIZE_Y / nbCellHeigh;
	}
	
	public void paintComponent(Graphics g){
		for (int i = 1; i < nbCellWidth; i++ ) {
			g.drawRect(0, i*pixelWidthOfCell, Ressources.WINDOW_SIZE_X, 0);
		}
		for (int i = 1; i < nbCellHeigh; i++ ) {
			g.drawRect(i*pixelHeighOfCell, 0, 1, Ressources.WINDOW_SIZE_Y);
		}
		
		for (int i = 0; i < nbCellWidth; i++) {
			for (int j = 0; j < nbCellHeigh; j++) {
				if(univers.isCell(i, j))
					g.fillRect(i*pixelWidthOfCell, j*pixelHeighOfCell, pixelWidthOfCell, pixelHeighOfCell);
			}
		}
	}
}
