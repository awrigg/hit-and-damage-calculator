package br.com.wrigg.dnd.hitAndDamage.damage;

import org.apache.log4j.Logger;

import br.com.wrigg.dnd.hitAndDamage.Bonus;

public class DamageBonus {
	private static final Logger logger = Logger.getLogger(DamageBonus.class);

	private Bonus bonus;
	
	public DamageBonus() {
		
	}
	
	public DamageBonus(int bonus) {
		this.bonus = new Bonus(bonus);
	}

	public Bonus getBonus() {
		return bonus;
	}

	public void setBonus(Bonus bonus) {
		this.bonus = bonus;
	}
	
	public String printDamageBonus() {
		if(bonus != null)
			return bonus.toString();
		return "";
	}

	public void update(Object feature) {
		DamageBonusByFeature damageBonusByFeature = new DamageBonusByFeatureFactoryMethod();
		
		String bonusValue = damageBonusByFeature.execute(feature);
		bonus = new Bonus(Integer.parseInt(bonusValue));
	}
	
	@Override
	public boolean equals(Object damageBonus) {
		DamageBonus damageBonusToCompare = (DamageBonus) damageBonus;
		logger.debug("damageBonus [" + damageBonusToCompare + "]");
		if (damageBonusToCompare != null) {
			logger.debug("bonus [" + this.bonus + "] " + damageBonusToCompare.getBonus() + "]");
			if((this.bonus == null && damageBonusToCompare.getBonus() == null) || this.bonus.equals(damageBonusToCompare.getBonus())) {
				return true;
			}
		}
		return false;
	}

	//FIXME Trocar a funcao Hash para validar outro atributo
	@Override
	public int hashCode() {
		return this.getClass().hashCode();
	}
}
