package br.com.wrigg.dnd.hitAndDamage;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.wrigg.dnd.hitAndDamage.arsenal.Weapon;
import br.com.wrigg.dnd.hitAndDamage.character.Character;

public class DamageRollComposerTest {

	@Test
	public void printWeaponDamageRollTest() {
		DiceType diceType = new DiceType(4);
		Weapon weapon = new Weapon(diceType);
		Character character = new Character();
		character.equip(weapon);
		DamageRollComposer damageRollComposer = new DamageRollComposer();
		assertEquals("1D4", damageRollComposer.compose(character));

		diceType = new DiceType(8);
		weapon = new Weapon(diceType);
		character = new Character();
		character.equip(weapon);
		damageRollComposer = new DamageRollComposer();
		assertEquals("1D8", damageRollComposer.compose(character));

		diceType = new DiceType(6);
		weapon = new Weapon(diceType, 2);
		character = new Character();
		character.equip(weapon);
		damageRollComposer = new DamageRollComposer();
		damageRollComposer = new DamageRollComposer();
		assertEquals("2D6", damageRollComposer.compose(character));
	}

}
