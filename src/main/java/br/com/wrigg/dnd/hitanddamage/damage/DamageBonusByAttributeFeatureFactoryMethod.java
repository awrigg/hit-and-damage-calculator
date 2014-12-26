package br.com.wrigg.dnd.hitanddamage.damage;

import br.com.wrigg.dnd.hitanddamage.character.Attribute;

public class DamageBonusByAttributeFeatureFactoryMethod implements DamageBonusByFeature {

	public int execute(Object feature) {
		Attribute attribute = (Attribute) feature;

		return attribute.getBonus().getBonus();
	}

}
