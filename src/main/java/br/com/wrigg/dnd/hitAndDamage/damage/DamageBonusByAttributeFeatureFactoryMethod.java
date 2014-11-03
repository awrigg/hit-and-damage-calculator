package br.com.wrigg.dnd.hitAndDamage.damage;

import br.com.wrigg.dnd.hitAndDamage.character.Attribute;

public class DamageBonusByAttributeFeatureFactoryMethod implements DamageBonusByFeature {

	public String execute(Object feature) {
		Attribute attribute = (Attribute) feature;

		return attribute.printBonus();
	}

}
