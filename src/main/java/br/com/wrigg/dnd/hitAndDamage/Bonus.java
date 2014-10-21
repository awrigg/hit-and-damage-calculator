package br.com.wrigg.dnd.hitAndDamage;


public class Bonus {

	private int bonus;
	
	public Bonus() {
	}
	
	public Bonus(int bonus) {
		this.bonus = bonus;  
	}

	public int getBonus() {
		return bonus;
	}
	
	@Override
	public String toString() {	
		return "+" + bonus;
	}
	
	@Override
	public boolean equals(Object bonus) {
		Bonus bonusToCompare = (Bonus) bonus;
		if(this.bonus == bonusToCompare.getBonus()) {
			return true;
		} 
		
		return false;
	}

	//FIXME Trocar a funcao Hash para validar outro atributo
	@Override
	public int hashCode() {
		return new Integer(this.bonus).hashCode();
	}
}
