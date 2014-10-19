package br.com.wrigg.dnd.hitAndDamage.arsenal;

import org.apache.log4j.Logger;

import br.com.wrigg.dnd.hitAndDamage.DiceType;

public class Weapon {
	private static Logger log = Logger.getLogger(Weapon.class);

	private DiceType diceType;

	private int quantity;
	private String name;

	public Weapon() {		
	}
	
	public Weapon(DiceType diceType) {
		this.diceType = diceType;
		this.quantity = 1;
	}

	public Weapon(DiceType diceType, int quantity) {
		this.diceType = diceType;
		this.quantity = quantity;
	}

	public Weapon(String name, DiceType diceType) {
		this.name = name;
		this.diceType = diceType;
		this.quantity = 1;
	}

	public DiceType getDiceType() {
		return diceType;
	}
	
	public String printDamageRoll() {
		log.debug("qtd [" + quantity + "] diceType [" + diceType + "]");
		return quantity + diceType.toString();
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	//FIXME metodo apenas para os testes iniciais
	public Weapon[] values() {
		Weapon[] weapons = new Weapon[3];
		weapons[0] = new Weapon("Kukri", new DiceType(4));
		weapons[1] = new Weapon("Long Sword", new DiceType(8));
		return weapons;
	}

	//FIXME se uma weapon for nula e a outra nao vai dar erro
	@Override
	public boolean equals(Object weapon) {
		Weapon weaponToCompare = (Weapon) weapon;
		if((this.diceType == null && weaponToCompare.getDiceType() == null) || this.diceType.equals(weaponToCompare.getDiceType())) {
			if((this.name == null && weaponToCompare.getName() == null) || this.name.equals(weaponToCompare.getName())) {
				if(this.quantity == weaponToCompare.quantity) {
					return true;
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
}
