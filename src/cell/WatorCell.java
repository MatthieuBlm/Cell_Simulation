package cell;

import java.awt.Color;

public class WatorCell extends Cell {
	private String type;
	private int step;
	
	public WatorCell(String type){
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
		setStep(0);
	}
	
	public WatorCell clone(){
		return new WatorCell(type);
	}
	
	public boolean isShark(){
		return this.type.equals("shark");
	}
	
	public boolean isFish(){
		return this.type.equals("fish");
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}
}
