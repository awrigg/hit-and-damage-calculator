package br.com.wrigg.dnd.hitAndDamage.spell;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.wrigg.dnd.hitAndDamage.Type;
import br.com.wrigg.dnd.hitAndDamage.character.CasterLevel;
import br.com.wrigg.dnd.hitAndDamage.character.Character;

public class SpellTest {

	@Test
	public void printDivineFavorDamageBonusTest() {
		Spell spell = new Spell("divineFavor", "Divine Favor", Type.FEATURE_DEPENDENT);

		Character character = new Character();
		character.castSpell(spell);
		character.setCasterLevel(new CasterLevel(1));
		
		String spellDamageBonus = spell.printDamageBonus();
		assertEquals("+1", spellDamageBonus);
	}
	
	@Test
	public void divineFavorDamageBonusShouldVaryWithCasterLevelTest() {
		Spell spell = new Spell("divineFavor", "Divine Favor", Type.FEATURE_DEPENDENT);

		Character character = new Character();
		character.castSpell(spell);
		
		character.setCasterLevel(new CasterLevel(6));
		
		String spellDamageBonus = spell.printDamageBonus();
		assertEquals("+2", spellDamageBonus);
	}	

	@Test
	public void spellEqualsTest() {
		Spell divineFavor1 = new Spell("divineFavor", "Divine Favor", Type.FEATURE_DEPENDENT);

		Spell divineFavor2 = new Spell("divineFavor", "Divine Favor", Type.FEATURE_DEPENDENT);

		assertEquals(divineFavor1, divineFavor2);
	}
}