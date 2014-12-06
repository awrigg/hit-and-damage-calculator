package br.com.wrigg.dnd.hitanddamage;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.wrigg.dnd.hitanddamage.DiceType;

public class DiceTypeTest {

	@Test
	public void printDiceTypeTest() {
		DiceType diceType = new DiceType(4);
		assertEquals("D4", diceType.toString());
		
		diceType = new DiceType(8);
		assertEquals("D8", diceType.toString());
	}
	
	@Test
	public void diceTypeEqualTest() {
		DiceType diceType1 = new DiceType(4);
		
		DiceType diceType2 = new DiceType(4);
	
		assertEquals(diceType1, diceType2);
	}

	@Test
	public void diceTypeIncrementTest() {
		DiceType diceType = new DiceType(4);
		diceType.increment();
		
		DiceType newDiceType = new DiceType(6);
		
		assertEquals(newDiceType, diceType);
		
		diceType = new DiceType(6);
		boolean extrapolate = diceType.increment();
		
		newDiceType = new DiceType(8);
		
		assertEquals(newDiceType, diceType);
		assertTrue(!extrapolate);
		
		diceType = new DiceType(8);
		extrapolate = diceType.increment();
		
		newDiceType = new DiceType(6);
		
		assertEquals(newDiceType, diceType);
		assertTrue(extrapolate);
	}
	
}
