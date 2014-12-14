package br.com.wrigg.dnd.hitanddamage.damage;

import java.util.List;

import br.com.wrigg.dnd.hitanddamage.Bonus;
import br.com.wrigg.dnd.hitanddamage._class.ClassFeature;
import br.com.wrigg.dnd.hitanddamage.feat.Feat;
import br.com.wrigg.dnd.hitanddamage.spell.Spell;

public class DamageRollCalculator {

	public DamageRollCalculator() {
		super();
	}
	
	protected int calculateFeatDamageBonus(List<Feat> feats) {
		int totalFeatsDamageBonus = 0; 
		
		for (Feat feat : feats) {
			DamageBonus featDamageBonus = feat.getDamageBonus();
			if(featDamageBonus != null) {
				Bonus bonus = featDamageBonus.getBonus();
				if(bonus != null)
					totalFeatsDamageBonus += bonus.getBonus();
			}
		}
		
		return totalFeatsDamageBonus;
	}
	
	
	protected int calculateSpellDamageBonus(List<Spell> spells) {
		int totalSpellsDamageBonus = 0; 
		
		for (Spell spell : spells) {
			DamageBonus spellDamageBonus = spell.getDamageBonus();
			if(spellDamageBonus != null) {
				Bonus bonus = spellDamageBonus.getBonus();
				if(bonus != null)
					totalSpellsDamageBonus += bonus.getBonus();
			}
		}
		
		return totalSpellsDamageBonus;
	}
	
	protected int calculateClassFeatureDamageBonus(List<ClassFeature> classFeatures) {
		int totalclassFeatureDamageBonus = 0; 
		
		for (ClassFeature classFeature : classFeatures) {
			DamageBonus classFeatureDamageBonus = classFeature.getDamageBonus();
			if(classFeatureDamageBonus != null) {
				Bonus bonus = classFeatureDamageBonus.getBonus();
				if(bonus != null)
					totalclassFeatureDamageBonus += bonus.getBonus();
			}
		}
		
		return totalclassFeatureDamageBonus;
	}
}