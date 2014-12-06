package br.com.wrigg.dnd.hitanddamage.spell;

import java.util.HashMap;
import java.util.Map;

import br.com.wrigg.dnd.hitanddamage.Type;

public class SpellBook {
	
	private Map<String, Spell> spells = new HashMap<String, Spell>();  

	public SpellBook() {
		Spell divineFavor = new Spell("divineFavor", "Divine Favor", Type.FEATURE_DEPENDENT);
		
		spells.put("divineFavor", divineFavor);
	}

	public Spell findSpellById(String spellId) {
		return spells.get(spellId);
	}
}
