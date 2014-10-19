package br.com.wrigg.dnd.hitAndDamage.damage;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.wrigg.dnd.hitAndDamage.DiceType;
import br.com.wrigg.dnd.hitAndDamage.Feat;
import br.com.wrigg.dnd.hitAndDamage.arsenal.Weapon;
import br.com.wrigg.dnd.hitAndDamage.character.Attribute;
import br.com.wrigg.dnd.hitAndDamage.character.Character;
import br.com.wrigg.dnd.hitAndDamage.damage.DamageRollCalculator;

public class DamageRollCalculatorTest {

	@Test
	public void calculateWeaponDamageRollTest() {
		Character character = new Character();
		Weapon weapon = new Weapon("Kukri", new DiceType(4));
		character.equip(weapon);
		
		DamageRollCalculator damageRollCalculator = new DamageRollCalculator();
		String damageRoll = damageRollCalculator.calculateDamageRoll(character);
		
		assertEquals("1D4", damageRoll);
		
		weapon = new Weapon("Long Sword", new DiceType(8));
		character.equip(weapon);
		
		damageRoll = damageRollCalculator.calculateDamageRoll(character);

		assertEquals("1D8", damageRoll);
	}
	
	@Test
	public void calculateWeaponAndStrengthDamageRollTest() {
		Character character = new Character();
		Weapon weapon = new Weapon("Kukri", new DiceType(4));
		character.equip(weapon);

		Attribute str = new Attribute(18);
		character.setStrength(str);
		
		DamageRollCalculator damageRollCalculator = new DamageRollCalculator();
		String damageRoll = damageRollCalculator.calculateDamageRoll(character);
		
		assertEquals("1D4+4", damageRoll);
		
		weapon = new Weapon("Long Sword", new DiceType(8));
		character.equip(weapon);
		
		damageRoll = damageRollCalculator.calculateDamageRoll(character);

		assertEquals("1D8+4", damageRoll);
	}

	@Test
	public void calculateWeaponStrengthAndDivineMetamagicDamageRollTest() {
		Character character = new Character();
		Weapon weapon = new Weapon("Kukri", new DiceType(4));
		character.equip(weapon);

		Attribute str = new Attribute(18);
		character.setStrength(str);

		Attribute cha = new Attribute(21);
		character.setCharisma(cha);

		Feat feat = new Feat("divineMetamagic", "Divine Metamagic");
		character.getFeats().add(feat);
		
		DamageRollCalculator damageRollCalculator = new DamageRollCalculator();
		String damageRoll = damageRollCalculator.calculateDamageRoll(character);
		
		assertEquals("1D4+9", damageRoll);
		
	}
}
