package br.com.wrigg.dnd.hitAndDamage.character;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import br.com.wrigg.dnd.hitAndDamage.DiceType;
import br.com.wrigg.dnd.hitAndDamage.Type;
import br.com.wrigg.dnd.hitAndDamage.Item.Item;
import br.com.wrigg.dnd.hitAndDamage._class.ClassFeature;
import br.com.wrigg.dnd.hitAndDamage._class.TurnLevel;
import br.com.wrigg.dnd.hitAndDamage.arsenal.Weapon;
import br.com.wrigg.dnd.hitAndDamage.feat.Feat;
import br.com.wrigg.dnd.hitAndDamage.spell.Spell;

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
		character1.activateFeat(feat1);
		
		Attribute cha1 = new Attribute(21);
		character1.setCharisma(cha1);
		
		DiceType diceType2 = new DiceType(4);
		Weapon weapon2 = new Weapon("Kukri", diceType2);

		Character character2 = new Character();
		character2.equip(weapon2);

		Attribute str2 = new Attribute(18);
		character2.setStrength(str2);
		
		Feat feat2 = new Feat("divineMetamagic", "Divine Metamagic");
		character2.activateFeat(feat2);
		
		Attribute cha2 = new Attribute(21);
		character2.setCharisma(cha2);

		assertEquals(character1, character2);
	}
	
	@Test
	public void characterWithWeaponStrAndSpellEqualTest() {
		DiceType diceType1 = new DiceType(4);
		Weapon weapon1 = new Weapon("Kukri", diceType1);
		
		Character character1 = new Character();
		character1.equip(weapon1);

		Attribute str1 = new Attribute(18);
		character1.setStrength(str1);

		Spell divineFavor1 = new Spell("divineFavor", "Divine Favor");
		character1.getSpells().add(divineFavor1);
		
		DiceType diceType2 = new DiceType(4);
		Weapon weapon2 = new Weapon("Kukri", diceType2);

		Character character2 = new Character();
		character2.equip(weapon2);

		Attribute str2 = new Attribute(18);
		character2.setStrength(str2);
		
		Spell divineFavor2 = new Spell("divineFavor", "Divine Favor");
		character2.getSpells().add(divineFavor2);
		
		assertEquals(character1, character2);
	}
	
	@Test
	public void characterWithWeaponStrAndClassFeatureTurnLevelEqualTest() {
		DiceType diceType1 = new DiceType(4);
		Weapon weapon1 = new Weapon("Kukri", diceType1);
		
		Character character1 = new Character();
		character1.equip(weapon1);

		Attribute str1 = new Attribute(18);
		character1.setStrength(str1);

		ClassFeature smite1 = new ClassFeature("smite", "Smite");
		character1.getClassFeatures().add(smite1);
		
		TurnLevel turnLevel1 = new TurnLevel(5);
		character1.setTurnLevel(turnLevel1);
		
		DiceType diceType2 = new DiceType(4);
		Weapon weapon2 = new Weapon("Kukri", diceType2);

		Character character2 = new Character();
		character2.equip(weapon2);

		Attribute str2 = new Attribute(18);
		character2.setStrength(str2);
		
		ClassFeature smite2 = new ClassFeature("smite", "Smite");
		character2.getClassFeatures().add(smite2);

		TurnLevel turnLevel2 = new TurnLevel(5);
		character2.setTurnLevel(turnLevel2);

		assertEquals(character1, character2);
	}
	
	@Test
	public void characterWithItemEqualTest() {
		Character character1 = new Character();
		character1.getItems().add(new Item("enlargePersonPotion", "Enlarge Person Potion"));
		
		Character character2 = new Character();
		character2.getItems().add(new Item("enlargePersonPotion", "Enlarge Person Potion"));

		assertEquals(character1, character2);		
	}
	
	@Test
	public void characterWithMoreThenOneFeatureDependentShouldNotReturnCastException() {
		DiceType diceType1 = new DiceType(4);
		Weapon weapon1 = new Weapon("Kukri", diceType1);
		
		Character character = new Character();
		character.equip(weapon1);

		Attribute str1 = new Attribute(18);
		character.setStrength(str1);

		ClassFeature smite1 = new ClassFeature("smite", "Smite", Type.FEATURE_DEPENDENT);
		character.getClassFeatures().add(smite1);
		
		TurnLevel turnLevel1 = new TurnLevel(5);
		character.setTurnLevel(turnLevel1);
		
		Spell divineFavor = new Spell("divineFavor", "Divine Favor", Type.FEATURE_DEPENDENT);
		character.castSpell(divineFavor);
		
		Feat divineMight = new Feat("divineMight", "Divine Might", Type.FEATURE_DEPENDENT);
		character.activateFeat(divineMight);
		
		Attribute cha = new Attribute(18);
		character.setCharisma(cha);

		assertTrue(true);
	}
	
	@Test
	public void characterAddNullFeatShowldDoNothingTest() {
		Character character = new Character();
		
		character.activateFeat(null);
	}
	
	@Test
	public void characterIncreaseSizeTest() {
		Weapon kukri = new Weapon(new DiceType(4));
		Character character = new Character();
		character.equip(kukri);
		
		character.increaseSize();
		
		Weapon largeKukri = new Weapon(new DiceType(6));
		assertEquals(largeKukri, character.getWeapon());
	}
	
	@Test
	public void characterActivateItemTest() {
		Character character = new Character();

		Item item = mock(Item.class);
		
		character.activateItem(item);
		
		assertEquals(1, character.getItems().size());

		verify(item).activate(character);
	}
}
