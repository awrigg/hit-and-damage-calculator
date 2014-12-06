package br.com.wrigg.dnd.hitanddamage.damage;

import java.util.List;

import org.apache.log4j.Logger;

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
			String featDamageBonus = feat.printDamageBonus();
			if(!"".equals(featDamageBonus))
				totalFeatsDamageBonus += Integer.parseInt(featDamageBonus);
		}
		
		return totalFeatsDamageBonus;
	}
	
	
	protected int calculateSpellDamageBonus(List<Spell> spells) {
		int totalSpellsDamageBonus = 0; 
		
		for (Spell spell : spells) {
			String spellDamageBonus = spell.printDamageBonus();
			if(!"".equals(spellDamageBonus))
				totalSpellsDamageBonus += Integer.parseInt(spellDamageBonus);
		}
		
		return totalSpellsDamageBonus;
	}
	
	protected int calculateClassFeatureDamageBonus(List<ClassFeature> classFeatures) {
		int totalclassFeatureDamageBonus = 0; 
		
		for (ClassFeature classFeature : classFeatures) {
			String classFeatureDamageBonus = classFeature.printDamageBonus();
			if(!"".equals(classFeatureDamageBonus))
				totalclassFeatureDamageBonus += Integer.parseInt(classFeatureDamageBonus);
		}
		
		return totalclassFeatureDamageBonus;
	}
}