package cell;

import java.awt.Color;


public class Cell {
	private Color cellColor;
	
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
