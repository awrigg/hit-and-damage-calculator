package br.com.wrigg.dnd.hitAndDamage.damage;

import br.com.wrigg.dnd.hitAndDamage._class.TurnLevel;
import br.com.wrigg.dnd.hitAndDamage.character.Attribute;
import br.com.wrigg.dnd.hitAndDamage.spell.CasterLevel;

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
		if(feature instanceof TurnLevel)
			return new DamageBonusByTurnLevelFeatureFactoryMethod();
		
		//FIXME tratar a falta de um retorno adequado.
		return null;
	}

}
