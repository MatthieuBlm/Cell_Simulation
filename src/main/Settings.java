package main;

import java.awt.Color;

public abstract class Settings {
	// Base
	public static final String APPLICATION_TITLE 	= "Super Cell Simulator 3000";
	public static final int WINDOW_SIZE_X 			= 800;
	public static final int WINDOW_SIZE_Y 			= 800;
			
	// Simulation
	public static final double CELL_RATE 			= 0.2;									// Between 0 and 1, used for generate random universe
	public static final int NB_CELL_WIDTH 			= 800;
	public static final int NB_CELL_HEIGH 			= 800;
	public static final long PARIOD_DURATION 		= 0;									// In milliseconds
	public static final int UP 						= 0;
	public static final int RIGHT					= 1;
	public static final int DOWN					= 2;
	public static final int LEFT					= 3;

	// Display
	public static final Color CELL_COLOR 			= Color.GRAY;
	public static final Color GRID_COLOR 			= Color.BLACK;
	public static final boolean DISPLAY_GRID 		= false;
	public static final int CELL_SIZE_X				= WINDOW_SIZE_X / NB_CELL_WIDTH;
	public static final int CELL_SIZE_Y				= WINDOW_SIZE_Y / NB_CELL_HEIGH;
}
