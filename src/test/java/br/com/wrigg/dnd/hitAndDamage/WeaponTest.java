package br.com.wrigg.dnd.hitAndDamage;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

@RunWith(MockitoJUnitRunner.class)
public class WeaponTest {

	@Test
	public void weaponEquipingTest() {
		DiceType diceType = new DiceType(4);
		Weapon weapon = new Weapon(diceType);
				
		assertEquals(diceType, ReflectionTestUtils.getField(weapon, "diceType"));
	}
	
	@Test
	public void TwoDiceWeaponEquipingTest() {
		DiceType diceType = new DiceType(6);
		Weapon weapon = new Weapon(diceType, 2);
				
		assertEquals(diceType, ReflectionTestUtils.getField(weapon, "diceType"));
		assertEquals(2, ReflectionTestUtils.getField(weapon, "quantity"));
	}
	
	@Test
	public void printDamageRollTest() {
		DiceType diceType = new DiceType(4);
		Weapon weapon = new Weapon(diceType);
				
		assertEquals("1d4", weapon.printDamageRoll());
		
		diceType = new DiceType(8);
		weapon = new Weapon(diceType);
				
		assertEquals("1d8", weapon.printDamageRoll());
		
		diceType = new DiceType(6);
		weapon = new Weapon(diceType, 2);
				
		assertEquals("2d6", weapon.printDamageRoll());

	}

}
