
public abstract class Character implements Killable, UsesSkills {

	protected int maxHp;
	protected int hp;
	protected int maxMp;
	protected int mp;
	protected Skill skills[];
	protected int nbSkills;
	
	public Character(int maxhp) {
		this.maxHp = maxhp;
		this.hp = maxhp;
	}
	
	public Character(int maxHp, int maxMp) {
		this.maxHp = maxHp;
		this.hp = maxHp;
		this.maxMp = maxMp;
		this.mp = maxMp;
	}
	
	public abstract void describe();
	
	public boolean isDead() {
		return this.hp == 0;
	}
	
	public void receiveDamage(int damage) {
		this.hp = this.hp - damage;
		if (this.hp < 0) {
			this.hp = 0;	
		}
	}
	
	public void receiveMpDamage(int damage) {
		this.mp = this.mp - damage;
		if (this.mp < 0) {
			this.mp = 0;
		}
	}
	
	public String getStatus() {
		return this.hp + "/" + this.maxHp + " HP\t" + this.mp + "/" + this.maxMp + " MP";
	}
	
	@Override
	public boolean canCast(Skill skill) {
		if (this.mp < skill.getMpCost()) {
			return false;
		}
		return true;
	}

	@Override
	public void cast(Skill skill, Character enemy) {
		if (skill.hitsCaster()) {
			this.receiveDamage(skill.getDamage());
			this.receiveMpDamage(skill.getMpDamage());
		}
		if (skill.hitsEnemy()) {
			enemy.receiveDamage(skill.getDamage());
			enemy.receiveMpDamage(skill.getMpDamage());
		}
		this.consumeMp(skill);
	}
	
	@Override
	public void consumeMp(Skill skill) {
		this.mp -= skill.getMpCost();
		if (this.mp < 0) {
			this.mp = 0;
		}
	}
	
	@Override
	public int getNbSkills() {
		return this.nbSkills;
	}
	
	@Override
	public Skill getSkill(int indice) {
		if (indice >= 0 && indice < this.nbSkills) {
			return this.skills[indice];
		}
		return null;
	}

}
