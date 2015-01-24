package br.com.wrigg.dnd.hitanddamage.arsenal;

import br.com.wrigg.dnd.hitanddamage.DiceType;
import br.com.wrigg.dnd.hitanddamage.damage.DamageBonus;

public class Weapon {
	private DiceType diceType;

	private int diceQuantity;
	private String name;
	private DamageBonus bonus;
	private int criticalFactor;

	public Weapon() {		
	}
	
	public Weapon(DiceType diceType) {
		this.diceType = diceType;
		this.diceQuantity = 1;
	}

	public Weapon(DiceType diceType, int quantity) {
		this.diceType = diceType;
		this.diceQuantity = quantity;
	}

	public Weapon(String name, DiceType diceType) {
		this.name = name;
		this.diceType = diceType;
		this.diceQuantity = 1;
	}

	public Weapon(DiceType diceType, int diceQuantity, int criticalFactor) {
		this.diceType = diceType;
		this.diceQuantity = diceQuantity;
		this.criticalFactor = criticalFactor;
	}
	
	public Weapon(String name, DiceType diceType, int diceQuantity, int criticalFactor) {
		this.name = name;
		this.diceType = diceType;
		this.diceQuantity = diceQuantity;
		this.criticalFactor = criticalFactor;
	}

	public DiceType getDiceType() {
		return diceType;
	}
	
	public String printDamageRoll() {
		return diceQuantity + diceType.toString();
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	//FIXME metodo apenas para os testes iniciais
	public Weapon[] values() {
		Weapon[] weapons = new Weapon[2];
		weapons[0] = new Weapon("Kukri", new DiceType(4), 1, 2);
		weapons[1] = new Weapon("Long Sword", new DiceType(8), 1, 2);
		return weapons;
	}

	//FIXME se uma weapon for nula e a outra nao vai dar erro
	@Override
	public boolean equals(Object weapon) {
		Weapon weaponToCompare = (Weapon) weapon;
		if((this.diceType == null && weaponToCompare.getDiceType() == null) || this.diceType.equals(weaponToCompare.getDiceType())) {
			if((this.name == null && weaponToCompare.getName() == null) || this.name.equals(weaponToCompare.getName())) {
				if((this.bonus == null && weaponToCompare.getBonus() == null) || (this.bonus != null && this.bonus.equals(weaponToCompare.getBonus()))) {
					if(this.diceQuantity == weaponToCompare.diceQuantity) {
						return true;
					}
				}
			}
		} 
		
		return false;
	}
	
	@Override
	public int hashCode() {
		if(getName() != null && !"".equals(getName())) {
			return getName().hashCode();
		} else {
			return super.hashCode();
		}
	}

	public DamageBonus getBonus() {
		return bonus;
	}

	public void setBonus(DamageBonus bonus) {
		this.bonus = bonus;
	}

	public int getCriticalFactor() {		
		return criticalFactor;
	}
	
	public Object printCriticalDamageRoll() {
		int diceQuantity = criticalFactor * this.diceQuantity; 
		
		return diceQuantity + diceType.toString();
	}

	public void increaseSize() {
		boolean extrapolate = diceType.increment();
		
		if(extrapolate)
			diceQuantity++;
	}
	
	@Override
	public String toString() {
		return name;
	}

	public void decreaseSize() {
		boolean extrapolate = diceType.decrement();
		
		if(extrapolate)
			diceQuantity--;
	}

}
