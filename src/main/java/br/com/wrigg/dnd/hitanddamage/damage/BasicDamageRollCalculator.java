package br.com.wrigg.dnd.hitanddamage.damage;

import java.util.List;

import br.com.wrigg.dnd.hitanddamage._class.ClassFeature;
import br.com.wrigg.dnd.hitanddamage.arsenal.Weapon;
import br.com.wrigg.dnd.hitanddamage.character.Attribute;
import br.com.wrigg.dnd.hitanddamage.character.Character;
import br.com.wrigg.dnd.hitanddamage.feat.Feat;
import br.com.wrigg.dnd.hitanddamage.spell.Spell;

public class BasicDamageRollCalculator extends DamageRollCalculator {
	
	public String calculateDamageRoll(Character character) {
		StringBuilder damageRollBuilder = new StringBuilder();
		Weapon weapon = character.getWeapon();
		damageRollBuilder.append(weapon.printDamageRoll());
		
		int weaponBonus = 0;
		DamageBonus damageBonus = weapon.getBonus(); 
		if(damageBonus != null)
			weaponBonus = damageBonus.getBonus().getBonus();
		
		Attribute str = character.getStrength();
		
		int strBonus = 0;
		if(str != null) {
			String strBonusText = str.printBonus();
			if(!"".equals(strBonusText))
				strBonus = Integer.parseInt(strBonusText);
		}
		
		List<Feat> feats = character.getFeats();
		
		int featsBonus = calculateFeatDamageBonus(feats);
		
		List<Spell> spells = character.getSpells();
		
		int spellsBonus = calculateSpellDamageBonus(spells);
		
		List<ClassFeature> classFeatures = character.getClassFeatures();
		
		int classFeatureBonus = calculateClassFeatureDamageBonus(classFeatures);
		
		int totalBonus = weaponBonus + strBonus + featsBonus + spellsBonus + classFeatureBonus;
		
		if(totalBonus > 0)
			damageRollBuilder.append("+" + totalBonus);
		
		return damageRollBuilder.toString();
	}
}
