package br.com.wrigg.dnd.hitAndDamage.spell;

import java.util.HashMap;
import java.util.Map;

public class SpellBook {
	
	private Map<String, Spell> spells = new HashMap<String, Spell>();  

	public SpellBook() {
		Spell divineFavor = new Spell("divineFavor", "Divine Favor");
		
		spells.put("divineFavor", divineFavor);
	}

	public Spell findSpellById(String spellId) {
		return spells.get(spellId);
	}
}
