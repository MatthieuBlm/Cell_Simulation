package cell;

import java.awt.Color;


public abstract class Cell {
	protected Color cellColor;
	
	public abstract Cell clone();
	
	public Cell(){
		this.cellColor = Color.GRAY;
	}
	
	public Cell(Color cellColor){
		this.cellColor = cellColor;
	}

	public Color getCellColor() {
		return cellColor;
	}

	public void setCellColor(Color cellColor) {
		this.cellColor = cellColor;
	}
}
