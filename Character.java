
public abstract class Character implements Killable {
	
	protected int maxhp;
	protected int hp;
	
	public Character(int maxhp) {
		this.maxhp = maxhp;
		this.hp = maxhp;
	}
	
	public abstract void describe();
	
	public Boolean isDead() {
		return this.hp == 0;
	}
	
	public void receiveDamage(int damage) {
		this.hp = this.hp - damage;
		if (this.hp < 0)
			this.hp = 0;
	}
	
	public String getStatus() {
		return this.hp + "/" + this.maxhp + " HP";
	}

}
