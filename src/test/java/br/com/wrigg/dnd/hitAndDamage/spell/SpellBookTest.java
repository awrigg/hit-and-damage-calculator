package br.com.wrigg.dnd.hitAndDamage.spell;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SpellBookTest {
	
	@Test
	public void findSpellByIdTest() {
		Spell spell = new Spell("divineFavor", "Divine Favor");

		SpellBook spellBook = new SpellBook();
		Spell spellDTO = spellBook.findSpellById("divineFavor");
		assertEquals(spell, spellDTO);
	}
}
