package br.com.wrigg.dnd.hitAndDamage;

import br.com.wrigg.dnd.hitAndDamage.character.Character;

public class DamageRollComposer {

	public String compose(Character character) {
		return character.getWeapon().printDamageRoll();
	}

}
