package br.com.wrigg.dnd.hitAndDamage._class;


public class TurnLevel {

	private int level;
	
	public TurnLevel() {
		
	}
	
	public TurnLevel(int turnLevel) {
		this.level = turnLevel;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int turnLevel) {
		this.level = turnLevel;
	}
	
	@Override
	public boolean equals(Object turnLevel) {
		TurnLevel turnLevelToCompare = (TurnLevel) turnLevel;
		if(this.level == turnLevelToCompare.getLevel()) {
			return true;
		}
		return false;
	}

	//FIXME Trocar a funcao Hash para validar outro atributo
	@Override
	public int hashCode() {
		return TurnLevel.class.hashCode();
	}
}
