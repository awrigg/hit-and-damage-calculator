package br.com.wrigg.dnd.hitAndDamage.arsenal;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import br.com.wrigg.dnd.hitAndDamage.DiceType;
import br.com.wrigg.dnd.hitAndDamage.arsenal.Weapon;

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
				
		assertEquals("1D4", weapon.printDamageRoll());
		
		diceType = new DiceType(8);
		weapon = new Weapon(diceType);
				
		assertEquals("1D8", weapon.printDamageRoll());
		
		diceType = new DiceType(6);
		weapon = new Weapon(diceType, 2);
				
		assertEquals("2D6", weapon.printDamageRoll());

	}
		
	@Test
	public void weaponsEqualTest() {
		DiceType diceType1 = new DiceType(4);
		Weapon weapon1 = new Weapon("Kukri", diceType1);
		
		DiceType diceType2 = new DiceType(4);
		Weapon weapon2 = new Weapon("Kukri", diceType2);
	
		assertEquals(weapon1, weapon2);
		
		weapon1 = new Weapon(new DiceType(4));
		weapon2 = new Weapon(new DiceType(4));
		assertEquals(weapon1, weapon2);
	}

}
