package br.com.wrigg.dnd.hitAndDamage;

import static org.junit.Assert.*;

import org.junit.Test;

public class DiceTypeTest {

	@Test
	public void printDiceTypeTest() {
		DiceType diceType = new DiceType(4);
		assertEquals("d4", diceType.toString());
		
		diceType = new DiceType(8);
		assertEquals("d8", diceType.toString());
	}

}
