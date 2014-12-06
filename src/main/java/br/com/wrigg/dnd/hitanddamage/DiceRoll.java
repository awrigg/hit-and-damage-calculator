package br.com.wrigg.dnd.hitanddamage;

public class DiceRoll {

	private DiceType diceType;
	private Bonus bonus;
	
	public DiceRoll(DiceType diceType, Bonus bonus) {
		this.diceType = diceType;
		this.bonus = bonus;
	}

	@Override
	public String toString() {
		return diceType.toString() + bonus.toString();
	}
}
