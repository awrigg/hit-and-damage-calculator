package br.com.wrigg.dnd.hitAndDamage;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

@RunWith(MockitoJUnitRunner.class)
public class CharacterTest {

	@Test
	public void weaponEquipingTest() {
		Weapon weapon = new Weapon(new DiceType(4));
		Character character = new Character();
		character.equip(weapon);
		
		assertEquals(weapon, ReflectionTestUtils.getField(character, "weapon"));
	}

}
