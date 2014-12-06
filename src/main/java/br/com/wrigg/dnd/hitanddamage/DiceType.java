package br.com.wrigg.dnd.hitanddamage;

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
		return new Integer(diceType).hashCode();
	}

	public boolean increment() {
		if(diceType == 4) {
			this.diceType = 6;
		} else {
			if(diceType == 6) {
				this.diceType = 8;
			} else {
				if(diceType == 8) {
					this.diceType = 6;
					return true;
				}
			}			
		}
		
		return false;
	}
}
