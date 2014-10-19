package br.com.wrigg.dnd.hitAndDamage.character;

import br.com.wrigg.dnd.hitAndDamage.arsenal.Weapon;

public class Character {
	
	private Attribute strength;

	private Weapon weapon;
	
	public void equip(Weapon weapon) {
		setWeapon(weapon);		
	}

	public void setWeapon(Weapon weapon) {		
		this.weapon = weapon;
	}
	
	public Weapon getWeapon() {		
		return weapon;
	}

	public Attribute getStrength() {
		return strength;
	}

	public void setStrength(Attribute strength) {
		this.strength = strength;
	}

	@Override
	public boolean equals(Object character) {
		Character characterToCompare = (Character) character;
		if(this.weapon.equals(characterToCompare.getWeapon())) {
			if((this.strength == null && characterToCompare.getStrength() == null) || this.strength.equals(characterToCompare.getStrength()))
				return true;
		} 
		
		return false;
	}

	//FIXME Trocar a funcao Hash para validar outro atributo
	@Override
	public int hashCode() {
		return this.getClass().hashCode();
	}

}
