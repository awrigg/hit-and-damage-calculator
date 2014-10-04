package br.com.wrigg.dnd.hitAndDamage;

public class DiceType {

	private int diceType;
	
	public DiceType(int diceType) {
		this.diceType = diceType;
	}
	
	@Override
	public String toString() {		
		return "d" + diceType;
	}
	
}
