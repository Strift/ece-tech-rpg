
public class Skill {
	
	private String name;
	private int mpCost;
	private int damage;
	private boolean hitsCaster;
	private boolean hitsEnemy;
	
	public Skill(String name, int mpCost, int damage) {
		this.name = name;
		this.mpCost = mpCost;
		this.damage = damage;
		this.hitsCaster = false;
		this.hitsEnemy = true;
	}
	
	public Skill(String name, int mpCost, int damage, boolean hitsCaster, boolean hitsEnemy) {
		this(name, mpCost, damage);
		this.hitsCaster = hitsCaster;
		this.hitsEnemy = hitsEnemy;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public boolean hitsCaster() {
		return hitsCaster;
	}

	public void setHitsCaster(boolean hitsCaster) {
		this.hitsCaster = hitsCaster;
	}

	public boolean hitsEnemy() {
		return hitsEnemy;
	}

	public void setHitsEnemy(boolean hitsEnemy) {
		this.hitsEnemy = hitsEnemy;
	}

	public int getMpCost() {
		return mpCost;
	}

	public void setMpCost(int mpCost) {
		this.mpCost = mpCost;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
