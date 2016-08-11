package behavior;

import java.awt.Color;

import main.Settings;
import universe.LangtonAntUniverse;
import universe.Universe;
import cell.Ant;
import cell.Cell;
import exception.NotLivingCellException;

public class LangtonAntBehavior extends CellBehavior {

	public LangtonAntBehavior(Universe universe) {
		super(universe);
	}

	@Override
	public boolean canBorn(int x, int y) {
		return false;
	}

	@Override
	public boolean canDie(int x, int y) {
		return false;
	}

	@Override
	public boolean canMove(int x, int y) {
		return universe.getObject(x, y) instanceof Ant;
	}

	@Override
	public void move(int x, int y){
		Ant ant = ((LangtonAntUniverse) universe).getAnt();
		
		universe.getCell(ant.getX(), ant.getY());
		
		switch(ant.getOrientation()){
		case Settings.UP :
			if(universe.getCell(ant.getX(), ant.getY()).getCellColor() == Color.BLACK){
				ant.setX(ant.getX() - 1);
				ant.setOrientation(Settings.LEFT);
			}else if(universe.getCell(ant.getX(), ant.getY()).getCellColor() == Color.WHITE){
				ant.setX(ant.getX() + 1);
				ant.setOrientation(Settings.RIGHT);
			}
			break;
		case Settings.RIGHT :
			if(universe.getCell(ant.getX(), ant.getY()).getCellColor() == Color.BLACK){
				ant.setY(ant.getY() - 1);
				ant.setOrientation(Settings.UP);
			}else if(universe.getCell(ant.getX(), ant.getY()).getCellColor() == Color.WHITE){
				ant.setY(ant.getY() + 1);
				ant.setOrientation(Settings.DOWN);
			}
			break;
		case Settings.DOWN :
			if(universe.getCell(ant.getX(), ant.getY()).getCellColor() == Color.BLACK){
				ant.setX(ant.getX() + 1);
				ant.setOrientation(Settings.RIGHT);
			}else if(universe.getCell(ant.getX(), ant.getY()).getCellColor() == Color.WHITE){
				ant.setX(ant.getX() - 1);
				ant.setOrientation(Settings.LEFT);
			}
			break;
		case Settings.LEFT :
			if(universe.getCell(ant.getX(), ant.getY()).getCellColor() == Color.BLACK){
				ant.setY(ant.getY() + 1);
				ant.setOrientation(Settings.DOWN);
			}else if(universe.getCell(ant.getX(), ant.getY()).getCellColor() == Color.WHITE){
				ant.setY(ant.getY() - 1);
				ant.setOrientation(Settings.UP);
			}
			break;
		}
		
		if(universe.getCell(x, y).getCellColor() == Color.WHITE) 		universe.getCell(x, y).setCellColor(Color.BLACK);
		else if(universe.getCell(x, y).getCellColor() == Color.BLACK) 	universe.getCell(x, y).setCellColor(Color.WHITE);
	}

	@Override
	public boolean isSimulable(Object object) {
		return object instanceof Ant;
	}

}
