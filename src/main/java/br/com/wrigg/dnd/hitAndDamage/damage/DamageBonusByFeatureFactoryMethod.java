package br.com.wrigg.dnd.hitAndDamage.damage;

import br.com.wrigg.dnd.hitAndDamage.character.Attribute;
import br.com.wrigg.dnd.hitAndDamage.character.CasterLevel;

public class DamageBonusByFeatureFactoryMethod implements DamageBonusByFeature {

	public String execute(Object feature) {
		DamageBonusByFeature damageBonusByFeature = create(feature);

		return damageBonusByFeature.execute(feature);
	}
	
	private DamageBonusByFeature create(Object feature) {
		if(feature instanceof CasterLevel)
			return new DamageBonusByCasterLevelFactoryMethod();
		if(feature instanceof Attribute)
			return new DamageBonusByAttributeFeatureFactoryMethod();
		
		//FIXME tratar a falta de um retorno adequado.
		return null;
	}

}
