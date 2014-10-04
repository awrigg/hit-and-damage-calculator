package br.com.wrigg.dnd.hitAndDamage;

public class DamageRollComposer {

	public String compose(Character character) {
		return character.getWeapon().printDamageRoll();
	}

}
