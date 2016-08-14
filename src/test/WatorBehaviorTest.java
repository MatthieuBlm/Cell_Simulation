package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import behavior.WatorBehavior;
import cell.SimpleCell;
import cell.WatorCell;
import main.Couple;
import main.Settings;
import universe.WatorUniverse;

public class WatorBehaviorTest {
	private static WatorUniverse universe;
	private static WatorBehavior behavior;
	
	/**
	 * 	  0 1 2 3 4 5 6 7
	 *  0 X O O O O O O O
	 *  1 X X X X O X O O
	 *  2 X X X X O X O O
	 *  3 O X X X X X O O
	 *  4 O O O O O O O O
	 *  5 O O S F O O O O
	 *  6 O O O O O O O O
	 *  7 O O O O O O O O
	 */
	@Before
	public final void init(){
		universe = new WatorUniverse();
		behavior = new WatorBehavior(universe);
		
		universe.addCell(new WatorCell("shark"), 1, 1);
		universe.addCell(new WatorCell("shark"), 1, 2);
		universe.addCell(new WatorCell("shark"), 1, 3);
		universe.addCell(new WatorCell("shark"), 2, 1);
		universe.addCell(new WatorCell("shark"), 3, 1);
		universe.addCell(new WatorCell("shark"), 2, 2);
		universe.addCell(new WatorCell("shark"), 2, 3);
		universe.addCell(new WatorCell("shark"), 3, 3);
		universe.addCell(new WatorCell("shark"), 3, 2);
		universe.addCell(new WatorCell("shark"), 0, 0);
		universe.addCell(new WatorCell("Shark"), 0, 1);
		universe.addCell(new WatorCell("Shark"), 0, 2);
		universe.addCell(new WatorCell("Shark"), 4, 3);
		universe.addCell(new WatorCell("Shark"), 5, 3);
		universe.addCell(new WatorCell("Shark"), 5, 2);
		universe.addCell(new WatorCell("Shark"), 5, 1);
		universe.addCell(new WatorCell("Shark"), 2, 5);
		
		universe.addCell(new WatorCell("Fish"), 3, 5);
	}
	
	@Test
	public final void testCanMove(){
		assertFalse(behavior.canMove(2, 2));
		assertTrue(behavior.canMove(0, 0));
		assertTrue(behavior.canMove(3, 2));
		assertTrue(behavior.canMove(3, 5));
	}
	
	@Test
	public final void testGetNumberfFreeCellAround(){
		assertEquals(0, behavior.getNumberOfFreeCellAround(2, 2));
		assertEquals(1, behavior.getNumberOfFreeCellAround(0, 0));
		assertEquals(7, behavior.getNumberOfFreeCellAround(5, 1));
		assertEquals(7, behavior.getNumberOfFreeCellAround(3, 5));
	}
	
	@Test
	public final void getFreeLocationAround(){
		Couple<Integer, Integer> res = new Couple<>(1, 0);
		List<Couple<Integer, Integer>> list = behavior.getFreeLocationAround(0, 0);
		
		assertTrue(list.size() == 1);
		assertEquals(res, list.get(0));
	}
	
	@Test
	public final void testMove(){
		assertTrue(universe.isShark(0, 2));
		assertFalse(universe.isShark(0, 3));
		
		behavior.move(0, 2);
		
		assertTrue(universe.isShark(0, 3));
		assertFalse(universe.isShark(0, 2));
		
		
		assertTrue(universe.isShark(2, 5));
		assertTrue(universe.isFish(3, 5));
		
		behavior.move(2, 5);
		
		assertTrue(universe.isShark(3, 5));
		assertFalse(universe.isShark(2, 5));
		
	}
	
	@Test
	public final void testIsSimulable(){
		assertTrue(behavior.isSimulable(new WatorCell("shark")));
		assertFalse(behavior.isSimulable(new SimpleCell()));
		assertFalse(behavior.isSimulable("Hello World"));
	}
	
	@Test
	public final void testCanDie(){
		assertFalse(behavior.canDie(5, 3));
		
		WatorCell cell = (WatorCell) universe.getCell(5, 3);
		
		while(cell.getEnergy() > 0)
			cell.decrementEnergy();
		
		assertTrue(behavior.canDie(5, 3));
	}
}
