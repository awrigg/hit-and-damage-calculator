package br.com.wrigg.dnd.hitanddamage.damage;

import br.com.wrigg.dnd.hitanddamage.Bonus;

public class DamageBonus {
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
		if(bonusValue != null && !"".equals(bonusValue))
			bonus = new Bonus(Integer.parseInt(bonusValue));
	}
	
	@Override
	public boolean equals(Object damageBonus) {
		DamageBonus damageBonusToCompare = (DamageBonus) damageBonus;
		if (damageBonusToCompare != null) {
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
