package br.com.wrigg.dnd.hitAndDamage.damage;

import java.util.List;

import org.apache.log4j.Logger;

import br.com.wrigg.dnd.hitAndDamage.arsenal.Weapon;
import br.com.wrigg.dnd.hitAndDamage.character.Attribute;
import br.com.wrigg.dnd.hitAndDamage.character.Character;
import br.com.wrigg.dnd.hitAndDamage.feat.Feat;
import br.com.wrigg.dnd.hitAndDamage.spell.Spell;

public class DamageRollCalculator {
	
	private static final Logger logger = Logger.getLogger(DamageRollCalculator.class);
	
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
		
		int totalBonus = weaponBonus + strBonus + featsBonus + spellsBonus;
		
		if(totalBonus > 0)
			damageRollBuilder.append("+" + totalBonus);
		
		return damageRollBuilder.toString();
	}
	
	private int calculateFeatDamageBonus(List<Feat> feats) {
		int totalFeatsDamageBonus = 0; 
		
		for (Feat feat : feats) {
			String featDamageBonus = feat.printDamageBonus();
			logger.debug("feat [" + feat.getName() + "] bonus [" + featDamageBonus + "]");
			if(!"".equals(featDamageBonus))
				totalFeatsDamageBonus += Integer.parseInt(featDamageBonus);
		}
		
		return totalFeatsDamageBonus;
	}
	
	private int calculateSpellDamageBonus(List<Spell> spells) {
		int totalSpellsDamageBonus = 0; 
		
		for (Spell spell : spells) {
			String spellDamageBonus = spell.printDamageBonus();
			logger.debug("feat [" + spell.getName() + "] bonus [" + spellDamageBonus + "]");
			if(!"".equals(spellDamageBonus))
				totalSpellsDamageBonus += Integer.parseInt(spellDamageBonus);
		}
		
		return totalSpellsDamageBonus;
	}
}
