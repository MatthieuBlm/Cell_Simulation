package main;

import java.awt.Color;

public abstract class Settings {
	// Base
	public static final String APPLICATION_TITLE 	= "Super Cell Simulator 3000";
	public static final int WINDOW_SIZE_X 			= 500;
	public static final int WINDOW_SIZE_Y 			= 500;
	
	// Display
	public static final Color CELL_COLOR 			= Color.GRAY;
	public static final Color GRID_COLOR 			= Color.BLACK;
	public static final boolean DISPLAY_GRID 		= false;
			
	// Simulation
	public static final double CELL_RATE 			= 0.5;									// Between 0 and 1
	public static final int NB_CELL_WIDTH 			= 250;
	public static final int NB_CELL_HEIGH 			= 250;
	public static final long PARIOD_DURATION 		= 1000;									// In milliseconds
}
