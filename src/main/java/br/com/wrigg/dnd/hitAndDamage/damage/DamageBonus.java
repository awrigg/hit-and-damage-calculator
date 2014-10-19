package br.com.wrigg.dnd.hitAndDamage.damage;

import br.com.wrigg.dnd.hitAndDamage.Bonus;
import br.com.wrigg.dnd.hitAndDamage.character.Attribute;

public class DamageBonus {

	private Bonus bonus;
	
	public String printDamageBonus() {
		return bonus.toString();
	}

	public void update(Object feature) {
		Attribute attribute = (Attribute) feature;
		bonus = attribute.getBonus();
	}
}
