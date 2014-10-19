package br.com.wrigg.dnd.hitAndDamage;

import static org.junit.Assert.*;

import org.junit.Test;

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


}
