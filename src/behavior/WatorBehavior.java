package behavior;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import main.CellAround;
import main.Couple;
import universe.Universe;
import universe.WatorUniverse;
import cell.WatorCell;

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
			return ( ((WatorCell) universe.getCell(x, y)).getEnergy() == 0 ? true : false );

		return false;
	}

	@Override
	public boolean canMove(int x, int y) {
		if(((WatorCell) universe.getCell(x, y)).isFish())
			return getNumberOfFreeCellAround(x, y) > 0;
		else if(((WatorCell) universe.getCell(x, y)).isShark())
			return getNumberOfSharkAround(x, y) < 8;
		return false;
	}

	@Override
	public void move(int x, int y) {
		Random rand = new Random();
		List<Couple<Integer, Integer>> freeCellList = this.getFreeLocationAround(x, y);
		WatorCell cell = (WatorCell) universe.getCell(x, y);
		if(cell.isShark()){
			List<Couple<Integer, Integer>> listOfFish = this.getFishLocationAround(x, y);
			if(listOfFish.size() > 0){
				Couple<Integer, Integer> destination = listOfFish.get(rand.nextInt(listOfFish.size()));
				universe.removeCell(destination.getV1(), destination.getV2());
				universe.addCell(cell.clone(), destination.getV1(), destination.getV2());
				universe.removeCell(x, y);
				cell.increaseEnergy(30);
			}else if(freeCellList.size() > 0){
				Couple<Integer, Integer> destination = freeCellList.get(rand.nextInt(freeCellList.size()));
				universe.addCell(cell.clone(), destination.getV1(), destination.getV2());
				universe.removeCell(x, y);
			}
		}else if(freeCellList.size() > 0){
			Couple<Integer, Integer> destination = freeCellList.get(rand.nextInt(freeCellList.size()));
			universe.addCell(cell.clone(), destination.getV1(), destination.getV2());
			universe.removeCell(x, y);
		}
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
