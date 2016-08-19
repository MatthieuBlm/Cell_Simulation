package behavior;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cell.Cell;
import cell.WatorCell;
import main.CellAround;
import main.Couple;
import main.Settings;
import universe.Universe;
import universe.WatorUniverse;

public class WatorBehavior extends CellBehavior {

	public WatorBehavior(Universe universe) {
		super(universe);
	}

	@Override
	public boolean canBorn(int x, int y) {
		return false;
	}

	@Override
	public boolean canDie(int x, int y) {
		WatorCell cell = (WatorCell) universe.getCell(x, y);
	
		if(cell.isShark())
			return ( cell.getEnergy() <= 0 ? true : false );

		return false;
	}

	@Override
	public boolean canMove(int x, int y) {
		if(!universe.isCell(x, y))
			return false;
		
		WatorCell cell = (WatorCell) universe.getCell(x, y);
		
		if(cell.isFish()){
			return getNumberOfFreeCellAround(x, y) > 0;
		}else if(cell.isShark()){
			if(this.getFishLocationAround(x, y).size() > 0){
				return true;
			}else if(this.getNumberOfFreeCellAround(x, y) > 0)
				return true;
		}
		
		return false;
	}

	@Override
	public Cell move(int x, int y) {
		Random rand = new Random();
		List<Couple<Integer, Integer>> freeCellList = this.getFreeLocationAround(x, y);
		WatorCell cell = (WatorCell) universe.getCell(x, y);
		WatorCell movedCell = null;
		
		if(cell.isShark()){
			List<Couple<Integer, Integer>> listOfFish = this.getFishLocationAround(x, y);
			if(listOfFish.size() > 0){
				Couple<Integer, Integer> destination = listOfFish.get(rand.nextInt(listOfFish.size()));
				universe.removeCell(destination.getV1(), destination.getV2());
				movedCell = cell.clone();
				universe.addCell(movedCell, destination.getV1(), destination.getV2());
				universe.removeCell(x, y);
				movedCell.increaseEnergy(Settings.ENERGY_RESTORE_BY_EATING);
			}else if(freeCellList.size() > 0){
				Couple<Integer, Integer> destination = freeCellList.get(rand.nextInt(freeCellList.size()));
				movedCell = cell.clone();
				universe.addCell(movedCell, destination.getV1(), destination.getV2());
				universe.removeCell(x, y);
			}
		}else if(freeCellList.size() > 0){
			Couple<Integer, Integer> destination = freeCellList.get(rand.nextInt(freeCellList.size()));
			movedCell = cell.clone();
			universe.addCell(movedCell, destination.getV1(), destination.getV2());
			universe.removeCell(x, y);
		}
		
		return movedCell;
	}

	@Override
	public boolean isSimulable(Object object) {
		return object instanceof WatorCell;
	}
	
	public int getNumberOfFreeCellAround(int x, int y){
		int nb = 0;
		CellAround cellAround = new CellAround(x, y);
		for (Couple<Integer, Integer> couple : cellAround.getAllCellLocationAroundThis()) {
			try{
				if(!universe.isCell(couple.getV1(), couple.getV2()))
					nb++;
			}catch(ArrayIndexOutOfBoundsException e){}
		}
		return nb;
	}
	
	public List<Couple<Integer, Integer>> getFreeLocationAround(int x, int y){
		ArrayList<Couple<Integer, Integer>> list = new ArrayList<>();
		CellAround cellAround = new CellAround(x, y);
		for (Couple<Integer, Integer> couple : cellAround.getAllCellLocationAroundThis()) {
			try{
				if(!universe.isCell(couple.getV1(), couple.getV2()))
					list.add(couple);
			}catch(ArrayIndexOutOfBoundsException e){}
		}
		return list;
	}

	private int getNumberOfSharkAround(int x, int y){
		int nb = 0;
		CellAround cellAround = new CellAround(x, y);
		for (Couple<Integer, Integer> couple : cellAround.getAllCellLocationAroundThis()) {
			try{
				if(((WatorUniverse)universe).isShark(couple.getV1(), couple.getV2()))
					nb++;
			}catch(ArrayIndexOutOfBoundsException e){}
		}
		return nb;
	}

	private List<Couple<Integer, Integer>> getFishLocationAround(int x, int y){
		ArrayList<Couple<Integer, Integer>> list = new ArrayList<>();
		CellAround cellAround = new CellAround(x, y);
		WatorCell tmpCell;
		for (Couple<Integer, Integer> couple : cellAround.getAllCellLocationAroundThis()) {
			try{
				tmpCell = (WatorCell) universe.getCell(couple.getV1(), couple.getV2());
				if(tmpCell != null && ((WatorCell) tmpCell).isFish())
					list.add(couple);
			}catch(ArrayIndexOutOfBoundsException e){}
		}
		return list;
	}
}
