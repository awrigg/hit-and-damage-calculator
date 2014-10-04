package br.com.wrigg.dnd.hitAndDamage;

public class Character {

	private Weapon weapon;
	
	public void equip(Weapon weapon) {
		this.weapon = weapon;		
	}

	public Weapon getWeapon() {		
		return weapon;
	}

}
