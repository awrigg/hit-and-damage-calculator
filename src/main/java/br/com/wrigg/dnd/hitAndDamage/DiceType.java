package br.com.wrigg.dnd.hitAndDamage;

public class DiceType {

	private int diceType;
	
	public DiceType(int diceType) {
		this.diceType = diceType;
	}
	
	@Override
	public String toString() {		
		return "D" + diceType;
	}
	
	@Override
	public boolean equals(Object diceType) {
		DiceType diceTypeToCompare = (DiceType) diceType;
		if(this.diceType == diceTypeToCompare.diceType) {
			return true;
		} 
		
		return false;
	}
	
	@Override
	public int hashCode() {
		return Integer.hashCode(diceType);
	}
}
