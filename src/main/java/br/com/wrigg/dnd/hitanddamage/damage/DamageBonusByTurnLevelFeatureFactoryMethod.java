package br.com.wrigg.dnd.hitanddamage.damage;

import br.com.wrigg.dnd.hitanddamage._class.TurnLevel;

public class DamageBonusByTurnLevelFeatureFactoryMethod implements DamageBonusByFeature {

	public String execute(Object feature) {
		TurnLevel turnLevel = (TurnLevel) feature;
		return "+" + Integer.toString(turnLevel.getLevel());
	}

}
