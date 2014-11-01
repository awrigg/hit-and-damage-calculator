package br.com.wrigg.dnd.hitAndDamage.character;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import br.com.wrigg.dnd.hitAndDamage.DiceType;
import br.com.wrigg.dnd.hitAndDamage.arsenal.Weapon;
import br.com.wrigg.dnd.hitAndDamage.feat.Feat;

@RunWith(MockitoJUnitRunner.class)
public class CharacterTest {

	@Test
	public void weaponEquipingTest() {
		Weapon weapon = new Weapon(new DiceType(4));
		Character character = new Character();
		character.equip(weapon);
		
		assertEquals(weapon, ReflectionTestUtils.getField(character, "weapon"));
	}
	
	@Test
	public void characterWithWeaponEqualTest() {
		DiceType diceType1 = new DiceType(4);
		Weapon weapon1 = new Weapon("Kukri", diceType1);
		
		Character character1 = new Character();
		character1.equip(weapon1);
		
		DiceType diceType2 = new DiceType(4);
		Weapon weapon2 = new Weapon("Kukri", diceType2);

		Character character2 = new Character();
		character2.equip(weapon2);

		assertEquals(character1, character2);
	}

	@Test
	public void characterWithWeaponAndStrEqualTest() {
		DiceType diceType1 = new DiceType(4);
		Weapon weapon1 = new Weapon("Kukri", diceType1);
		
		Character character1 = new Character();
		character1.equip(weapon1);
		
		Attribute str1 = new Attribute(18);
		character1.setStrength(str1);
		
		DiceType diceType2 = new DiceType(4);
		Weapon weapon2 = new Weapon("Kukri", diceType2);

		Character character2 = new Character();
		character2.equip(weapon2);

		Attribute str2 = new Attribute(18);
		character2.setStrength(str2);

		assertEquals(character1, character2);
	}
	
	@Test
	public void characterWithWeaponStrAndFeatEqualTest() {
		DiceType diceType1 = new DiceType(4);
		Weapon weapon1 = new Weapon("Kukri", diceType1);
		
		Character character1 = new Character();
		character1.equip(weapon1);

		Attribute str1 = new Attribute(18);
		character1.setStrength(str1);

		Feat feat1 = new Feat("divineMetamagic", "Divine Metamagic");
		character1.addFeat(feat1);
		
		Attribute cha1 = new Attribute(21);
		character1.setCharisma(cha1);
		
		DiceType diceType2 = new DiceType(4);
		Weapon weapon2 = new Weapon("Kukri", diceType2);

		Character character2 = new Character();
		character2.equip(weapon2);

		Attribute str2 = new Attribute(18);
		character2.setStrength(str2);
		
		Feat feat2 = new Feat("divineMetamagic", "Divine Metamagic");
		character2.addFeat(feat2);
		
		Attribute cha2 = new Attribute(21);
		character2.setCharisma(cha2);

		assertEquals(character1, character2);
	}
}
