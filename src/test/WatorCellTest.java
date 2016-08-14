package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import cell.WatorCell;
import main.Settings;

public class WatorCellTest {
	private static WatorCell shark;
	private static WatorCell fish;
	
	@Before
	public final void init(){
		shark = new WatorCell("Shark");
		fish = new WatorCell("fish");
	}
	
	@Test
	public final void testIsShark(){
		assertTrue(shark.isShark());
		assertFalse(fish.isShark());
	}
	
	@Test
	public final void testIsFish(){
		assertTrue(fish.isFish());
		assertFalse(fish.isShark());
	}
	
	@Test
	public final void testGetEnergy(){
		assertEquals(Settings.SHARK_ENERGIE, shark.getEnergy());
	}
	
	@Test
	public final void testDecrementEnergy(){
		shark.decrementEnergy();
		
		assertEquals(shark.getEnergy(), Settings.SHARK_ENERGIE - 1);
	}
	
	@Test
	public final void testInitializeEnergy(){
		shark.decrementEnergy();
		shark.initialiseEnergy();
		
		assertEquals(shark.getEnergy(), Settings.SHARK_ENERGIE);
	}
	
	@Test
	public final void testGetReproductionStep(){
		assertEquals(0, shark.getReproductionStep());
		assertEquals(0, fish.getReproductionStep());
	}
	
	@Test
	public final void testIncrementReproductionStep(){
		shark.incrementReproductionStep();
		fish.incrementReproductionStep();
		fish.incrementReproductionStep();
		
		assertEquals(1, shark.getReproductionStep());
		assertEquals(2, fish.getReproductionStep());
	}
	
	@Test
	public final void testInitializeReproductionStep(){
		shark.incrementReproductionStep();
		shark.incrementReproductionStep();
		shark.initialiseReproductionStep();
		
		assertEquals(0, shark.getReproductionStep());
	}
	
	@Test
	public final void testCanReproduce(){
		assertFalse(shark.canReproduce());
		
		while(shark.getReproductionStep() < Settings.REPRODUCTION_STEPS)
			shark.incrementReproductionStep();
		
		assertTrue(shark.canReproduce());
	}
	
	@Test
	public final void testIncreaseEnergy(){
		assertEquals(Settings.SHARK_ENERGIE, shark.getEnergy());
		
		shark.increaseEnergy(5);
		
		assertEquals(Settings.SHARK_ENERGIE + 5, shark.getEnergy());
		
		shark.increaseEnergy(25);
		
		assertEquals(Settings.SHARK_ENERGIE + 30, shark.getEnergy());
	}
}
