package br.com.wrigg.dnd.hitAndDamage.damage;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import br.com.wrigg.dnd.hitAndDamage.spell.CasterLevel;

@RunWith(JUnit4.class)
public class DamageBonusByCasterLevelFeatureFactoryMethodTest {

	@Test
	public void executeDamageBonusByCasterLevelFeatureTest() {
		DamageBonusByCasterLevelFactoryMethod damageBonusByCasterLevel = new DamageBonusByCasterLevelFactoryMethod();
		
		CasterLevel casterLevel = new CasterLevel(6);
		
		String damageBonus = damageBonusByCasterLevel.execute(casterLevel);
		assertEquals("+2", damageBonus);
		
		casterLevel = new CasterLevel(9);
		
		damageBonus = damageBonusByCasterLevel.execute(casterLevel);
		assertEquals("+3", damageBonus);
		
		casterLevel = new CasterLevel(8);
		
		damageBonus = damageBonusByCasterLevel.execute(casterLevel);
		assertEquals("+2", damageBonus);
	}
	
	@Test
	public void shouldReturnAtLeastPlusOneTest() {
		DamageBonusByCasterLevelFactoryMethod damageBonusByCasterLevel = new DamageBonusByCasterLevelFactoryMethod();
		
		CasterLevel casterLevel = new CasterLevel(1);
		
		String damageBonus = damageBonusByCasterLevel.execute(casterLevel);
		assertEquals("+1", damageBonus);
	}
}
