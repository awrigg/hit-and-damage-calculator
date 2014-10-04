package br.com.wrigg.dnd.hitAndDamage;

public class Weapon {

	private DiceType diceType;
	private int quantity;
	
	public Weapon(DiceType diceType) {
		this.diceType = diceType;
		this.quantity = 1;
	}

	public Weapon(DiceType diceType, int quantity) {
		this.diceType = diceType;
		this.quantity = quantity;
	}

	public String printDamageRoll() {
		return quantity + diceType.toString();
	}
}
