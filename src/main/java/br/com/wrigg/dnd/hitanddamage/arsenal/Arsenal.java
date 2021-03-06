package br.com.wrigg.dnd.hitanddamage.arsenal;

import java.util.HashMap;
import java.util.Map;

import br.com.wrigg.dnd.hitanddamage.DiceType;

public class Arsenal {
	
	private Map<String, Weapon> weapons = new HashMap<String, Weapon>();  

	public Arsenal() {
		Weapon weapon1 = new Weapon("Kukri", new DiceType(4), 1, 2);
		Weapon weapon2 = new Weapon("Long Sword", new DiceType(8), 1, 2);
		weapons.put("Kukri", weapon1);
		weapons.put("Long Sword", weapon2);
	}
	
	//FIXME a arma deveria ser buscada pelo ID
	public Weapon findWeaponByName(String weaponName) {		
		return weapons.get(weaponName);
	}
}
