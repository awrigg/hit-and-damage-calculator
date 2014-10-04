package br.com.wrigg.dnd.hitAndDamage;

public class Bonus {

	private int bonus;
	
	public Bonus(int bonus) {
		this.bonus = bonus;  
	}

	@Override
	public String toString() {	
		return "+" + bonus;
	}
}
