package br.com.wrigg.dnd.hitAndDamage.damage;

import static org.junit.Assert.*;

import org.junit.Test;

public class DamageBonusTest {

	@Test
	public void damageEqualTest() {
		DamageBonus bonus1 = new DamageBonus(2);
		
		DamageBonus bonus2 = new DamageBonus(2);

		assertEquals(bonus1, bonus2);
		
	}
	
	@Test
	public void shouldReturnEmptyWhenBonusNotSetForPrintDamageBonusTest() {
		DamageBonus bonus = new DamageBonus();

		assertEquals("", bonus.printDamageBonus());
		
	}
}
