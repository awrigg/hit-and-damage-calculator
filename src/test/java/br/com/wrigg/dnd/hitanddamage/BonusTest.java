package br.com.wrigg.dnd.hitanddamage;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.wrigg.dnd.hitanddamage.Bonus;

public class BonusTest {

	@Test
	public void printBonusTest() {
		Bonus bonus = new Bonus(2);
		assertEquals("+2", bonus.toString());
		
		bonus = new Bonus(3);
		assertEquals("+3", bonus.toString());
	}
	
	@Test
	public void bonusEqualTest() {
		Bonus bonus1 = new Bonus(2);
		
		Bonus bonus2 = new Bonus(2);

		assertEquals(bonus1, bonus2);
		
	}
}
