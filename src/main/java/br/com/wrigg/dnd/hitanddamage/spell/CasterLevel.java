package br.com.wrigg.dnd.hitanddamage.spell;

public class CasterLevel {

	private int level;
	
	public CasterLevel() {
		
	}

	public CasterLevel(int level) {
		this.level = level; 
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	@Override
	public boolean equals(Object casterLevel) {
		CasterLevel casterLevelToCompare = (CasterLevel) casterLevel;
		if(casterLevelToCompare != null && this.level == casterLevelToCompare.getLevel())
			return true;
		return false;
	}

	//FIXME Trocar a funcao Hash para validar outro atributo
	@Override
	public int hashCode() {
		return this.getClass().hashCode();
	}
}
