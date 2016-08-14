package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import cell.WatorCell;
import universe.WatorUniverse;

public class WatorUniverseTest {
	private static WatorUniverse universe;
	
	@BeforeClass
	public static final void init(){
		universe = new WatorUniverse();
		universe.addCell(new WatorCell("Shark"), 0, 0);
		universe.addCell(new WatorCell("Fish"), 0, 1);
	}
	
	@Test
	public final void isShark(){
		assertTrue(universe.isShark(0, 0));
		assertFalse(universe.isShark(0, 1));
		assertFalse(universe.isShark(0, 4));
	}
	
	@Test
	public final void isFish(){
		assertTrue(universe.isFish(0, 1));
		assertFalse(universe.isFish(0, 0));
		assertFalse(universe.isFish(0, 5));
	}
}
