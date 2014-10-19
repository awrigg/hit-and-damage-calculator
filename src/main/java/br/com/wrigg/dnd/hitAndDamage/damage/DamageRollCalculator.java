package br.com.wrigg.dnd.hitAndDamage.damage;

import java.util.List;

import br.com.wrigg.dnd.hitAndDamage.Feat;
import br.com.wrigg.dnd.hitAndDamage.character.Attribute;
import br.com.wrigg.dnd.hitAndDamage.character.Character;

public class DamageRollCalculator {
	public String calculateDamageRoll(Character character) {
		StringBuilder damageRollBuilder = new StringBuilder();
		damageRollBuilder.append(character.getWeapon().printDamageRoll());
		
		Attribute str = character.getStrength();
		
		int strBonus = 0;
		if(str != null)		
			strBonus = Integer.parseInt(str.printBonus());
		
		List<Feat> feats = character.getFeats();
		
		int featsBonus = calculateFeatDamageBonus(feats);
		
		int totalBonus = strBonus + featsBonus;
		
		damageRollBuilder.append("+" + totalBonus);
		
		return damageRollBuilder.toString();
	}
	
	public int calculateFeatDamageBonus(List<Feat> feats) {
		int totalFeatsDamageBonus = 0; 
		
		for (Feat feat : feats) {
			String featDamageBonus = feat.printDamageBonus();
			totalFeatsDamageBonus += Integer.parseInt(featDamageBonus);
		}
		
		return totalFeatsDamageBonus;
	}
}
