package br.com.wrigg.dnd.hitAndDamage.damage;

import java.util.List;

import org.apache.log4j.Logger;

import br.com.wrigg.dnd.hitAndDamage._class.ClassFeature;
import br.com.wrigg.dnd.hitAndDamage.feat.Feat;
import br.com.wrigg.dnd.hitAndDamage.spell.Spell;

public class DamageRollCalculator {

	private static final Logger logger = Logger.getLogger(DamageRollCalculator.class);
	
	public DamageRollCalculator() {
		super();
	}
	
	protected int calculateFeatDamageBonus(List<Feat> feats) {
		int totalFeatsDamageBonus = 0; 
		
		for (Feat feat : feats) {
			String featDamageBonus = feat.printDamageBonus();
			logger.debug("feat [" + feat.getName() + "] bonus [" + featDamageBonus + "]");
			if(!"".equals(featDamageBonus))
				totalFeatsDamageBonus += Integer.parseInt(featDamageBonus);
		}
		
		return totalFeatsDamageBonus;
	}
	
	
	protected int calculateSpellDamageBonus(List<Spell> spells) {
		int totalSpellsDamageBonus = 0; 
		
		for (Spell spell : spells) {
			String spellDamageBonus = spell.printDamageBonus();
			logger.debug("spell [" + spell.getName() + "] bonus [" + spellDamageBonus + "]");
			if(!"".equals(spellDamageBonus))
				totalSpellsDamageBonus += Integer.parseInt(spellDamageBonus);
		}
		
		return totalSpellsDamageBonus;
	}
	
	protected int calculateClassFeatureDamageBonus(List<ClassFeature> classFeatures) {
		int totalclassFeatureDamageBonus = 0; 
		
		for (ClassFeature classFeature : classFeatures) {
			String classFeatureDamageBonus = classFeature.printDamageBonus();
			logger.debug("class feature [" + classFeature.getName() + "] bonus [" + classFeatureDamageBonus + "]");
			if(!"".equals(classFeatureDamageBonus))
				totalclassFeatureDamageBonus += Integer.parseInt(classFeatureDamageBonus);
		}
		
		return totalclassFeatureDamageBonus;
	}
}