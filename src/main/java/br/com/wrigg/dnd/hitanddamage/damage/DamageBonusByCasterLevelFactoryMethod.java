package br.com.wrigg.dnd.hitanddamage.damage;

import br.com.wrigg.dnd.hitanddamage.spell.CasterLevel;

public class DamageBonusByCasterLevelFactoryMethod implements DamageBonusByFeature {

	public String execute(Object feature) {
		CasterLevel casterLevel = (CasterLevel) feature;

		//FIXME a operacao sobre o caster level deve variar com a magia que for utilizada
		int bonus = casterLevel.getLevel() / 3;

		if(bonus > 0)
			return "+" + Integer.toString(bonus);
		else
			return "+1";
	}

}
