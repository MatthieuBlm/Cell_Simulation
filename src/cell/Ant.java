package cell;

import java.awt.Color;

import main.Settings;

public class Ant extends Cell {
	private int x;
	private int y;
	private int orientation;
	
	public Ant(int x, int y){
		super(Color.RED);
		this.x = x;
		this.y = y;
		this.orientation = Settings.UP;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getOrientation() {
		return orientation;
	}

	public void setOrientation(int orientation) {
		this.orientation = orientation;
	}
	
	
}
