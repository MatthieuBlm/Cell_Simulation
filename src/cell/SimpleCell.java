package cell;

import java.awt.Color;

public class SimpleCell extends Cell {

	public SimpleCell(){
		super();
	}
	
	public SimpleCell(Color cellColor){
		super(cellColor);
	}
	
	@Override
	public SimpleCell clone() {
		return new SimpleCell(cellColor);
	}

}
