package br.com.wrigg.dnd.hitanddamage;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.wrigg.dnd.hitanddamage.Bonus;
import br.com.wrigg.dnd.hitanddamage.DiceRoll;
import br.com.wrigg.dnd.hitanddamage.DiceType;

public class DiceRollTest {

	@Test
	public void printDiceRollTest() {
		DiceType diceType = new DiceType(4);
		Bonus bonus = new Bonus(3);
		DiceRoll diceRoll = new DiceRoll(diceType, bonus);		
		assertEquals("D4+3", diceRoll.toString());

		diceType = new DiceType(8);
		bonus = new Bonus(4);
		diceRoll = new DiceRoll(diceType, bonus);
		assertEquals("D8+4", diceRoll.toString());
	}

}
