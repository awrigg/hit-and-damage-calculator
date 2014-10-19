package br.com.wrigg.dnd.hitAndDamage.arsenal;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.wrigg.dnd.hitAndDamage.DiceType;

@RunWith(MockitoJUnitRunner.class)
public class ArsenalTest {

	@Test
	public void findWeaponByNameTest() {
		Weapon weapon = new Weapon("Kukri", new DiceType(4));
		
		Arsenal arsenal = new Arsenal();
		
		Weapon weaponFound = arsenal.findWeaponByName("Kukri");
		
		assertEquals(weapon, weaponFound);
	}

}