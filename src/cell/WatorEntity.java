package cell;

import java.awt.Color;

public class WatorEntity extends Cell {
	private String type;
	
	public WatorEntity(String type){
		super();
		this.type = type;
		switch(type){
		case "shark":
			this.setCellColor(Color.BLUE);
			break;
		case "fish":
			this.setCellColor(Color.GREEN);
			break;
		}
	}
	
	public boolean isShark(){
		return this.type.equals("shark");
	}
	
	public boolean isFish(){
		return this.type.equals("fish");
	}
}
