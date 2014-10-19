package br.com.wrigg.dnd.hitAndDamage.damageRollCalculator;

import br.com.wrigg.dnd.hitAndDamage.character.Attribute;
import br.com.wrigg.dnd.hitAndDamage.character.Character;

public class DamageRollCalculator {
	public String calculateDamageRoll(Character character) {
		StringBuilder damageRollBuilder = new StringBuilder();
		damageRollBuilder.append(character.getWeapon().printDamageRoll());
		
		Attribute str = character.getStrength();
		if(str != null)		
			damageRollBuilder.append(str.printBonus());
		
		return damageRollBuilder.toString();
	}
}
