package br.com.wrigg.dnd.hitAndDamage;

import static org.junit.Assert.*;

import org.junit.Test;

public class DiceRollTest {

	@Test
	public void printDiceRollTest() {
		DiceType diceType = new DiceType(4);
		Bonus bonus = new Bonus(3);
		DiceRoll diceRoll = new DiceRoll(diceType, bonus);		
		assertEquals("d4+3", diceRoll.toString());

		diceType = new DiceType(8);
		bonus = new Bonus(4);
		diceRoll = new DiceRoll(diceType, bonus);
		assertEquals("d8+4", diceRoll.toString());
	}

}
