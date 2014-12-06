package br.com.wrigg.dnd.hitanddamage.character;

import br.com.wrigg.dnd.hitanddamage.Bonus;

public class Attribute {

	private int value;
	private Bonus bonus;

	public Attribute() {
		
	}
	
	public Attribute(int value) {
		setValue(value);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
		calculateBonus();
	}
	
	public Bonus getBonus() {
		return bonus;
	}
	
	public String printBonus() {
		if(bonus != null)
			return bonus.toString();
		return "";
	}
	
	private void calculateBonus() {
		if(value > 10) {
			int bonusValue = (value-10)/2;
			bonus = new Bonus(bonusValue);
		}
	}
	
	@Override
	public boolean equals(Object attribute) {
		Attribute attributeToCompare = (Attribute) attribute;
		if(attributeToCompare != null) {
			if(this.value == attributeToCompare.getValue()) {
				if((this.bonus == null && attributeToCompare.getBonus() == null) || this.bonus.equals(attributeToCompare.getBonus()))
					return true;
			}
		}
		
		return false;
	}

	//FIXME Trocar a funcao Hash para validar outro atributo
	@Override
	public int hashCode() {
		return new Integer(value).hashCode();
	}
}
