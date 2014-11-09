package br.com.wrigg.dnd.hitAndDamage.damage;

import br.com.wrigg.dnd.hitAndDamage._class.TurnLevel;

public class DamageBonusByTurnLevelFeatureFactoryMethod implements DamageBonusByFeature {

	public String execute(Object feature) {
		TurnLevel turnLevel = (TurnLevel) feature;
		return "+" + Integer.toString(turnLevel.getLevel());
	}

}
