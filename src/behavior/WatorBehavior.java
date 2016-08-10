package behavior;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import main.Couple;
import universe.Universe;
import cell.WatorEntity;
import exception.NotLivingCellException;

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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canMove(int x, int y) {
		return getNumberOfFreeCellAround(x, y) > 0;
	}

	@Override
	public void move(int x, int y) throws NotLivingCellException {
		Random rand = new Random();
		List<Couple<Integer, Integer>> list = this.getFreeLocationAround(x, y);
		Couple<Integer, Integer> destination = list.get(rand.nextInt(list.size()));
		
		universe.addObject(destination.getV1(), destination.getV2());
		
		universe.validateBuffer();
	}

	@Override
	public boolean isSimulable(Object object) {
		return object instanceof WatorEntity;
	}
	
	private int getNumberOfFreeCellAround(int x, int y){
		int nb = 0;
		if(!universe.isCell(x - 1, y)) 		nb++;
		if(!universe.isCell(x + 1, y)) 		nb++;
		if(!universe.isCell(x, y - 1)) 		nb++;
		if(!universe.isCell(x - 1, y - 1)) 	nb++;
		if(!universe.isCell(x + 1, y - 1)) 	nb++;
		if(!universe.isCell(x, y + 1)) 		nb++;
		if(!universe.isCell(x - 1, y + 1)) 	nb++;
		if(!universe.isCell(x + 1, y + 1)) 	nb++;
		return nb;
	}
	
	private List<Couple<Integer, Integer>> getFreeLocationAround(int x, int y){
		ArrayList<Couple<Integer, Integer>> list = new ArrayList<>();
		if(!universe.isCell(x - 1, y)) 		list.add(new Couple<Integer, Integer>(x - 1, y));
		if(!universe.isCell(x + 1, y)) 		list.add(new Couple<Integer, Integer>(x + 1, y));
		if(!universe.isCell(x, y - 1)) 		list.add(new Couple<Integer, Integer>(x, y - 1));
		if(!universe.isCell(x - 1, y - 1)) 	list.add(new Couple<Integer, Integer>(x - 1, y - 1));
		if(!universe.isCell(x + 1, y - 1)) 	list.add(new Couple<Integer, Integer>(x + 1, y - 1));
		if(!universe.isCell(x, y + 1)) 		list.add(new Couple<Integer, Integer>(x, y + 1));
		if(!universe.isCell(x - 1, y + 1)) 	list.add(new Couple<Integer, Integer>(x - 1, y + 1));
		if(!universe.isCell(x + 1, y + 1)) 	list.add(new Couple<Integer, Integer>(x + 1, y + 1));
		return list;
	}

}
