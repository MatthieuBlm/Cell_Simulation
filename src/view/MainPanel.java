package view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import main.Settings;
import universe.Universe;

public class MainPanel extends JPanel{
	private static final long serialVersionUID = -3590785491709470949L;
	private Universe universe;
	private int pixelWidthOfCell;
	private int pixelHeighOfCell;
	
	public MainPanel(Universe universe){
		this.universe = universe;
		
		this.setPreferredSize(new Dimension(Settings.WINDOW_SIZE_X, Settings.WINDOW_SIZE_Y));
		
		pixelWidthOfCell = Settings.WINDOW_SIZE_X / Settings.NB_CELL_WIDTH;
		pixelHeighOfCell = Settings.WINDOW_SIZE_Y / Settings.NB_CELL_HEIGH;
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		if(Settings.DISPLAY_GRID){
			g.setColor(Settings.GRID_COLOR);
			for (int i = 1; i < Settings.NB_CELL_WIDTH; i++ ) {
				g.drawRect(0, i*pixelWidthOfCell, Settings.WINDOW_SIZE_X, 0);
			}
			for (int i = 1; i < Settings.NB_CELL_HEIGH; i++ ) {
				g.drawRect(i*pixelHeighOfCell, 0, 1, Settings.WINDOW_SIZE_Y);
			}
		}
		
		g.setColor(Settings.CELL_COLOR);
		for (int i = 0; i < Settings.NB_CELL_WIDTH; i++) {
			for (int j = 0; j < Settings.NB_CELL_HEIGH; j++) {
				if(universe.isCell(i, j)){
					g.setColor(universe.getCell(i, j).getCellColor());
					g.fillRect(i*pixelWidthOfCell, j*pixelHeighOfCell, pixelWidthOfCell, pixelHeighOfCell);
				}
			}
		}
		
		universe.drawSpecialCell(g);
	}
}
