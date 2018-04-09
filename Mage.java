
public class Mage extends Character {
	
	public Mage() {
		super(100, 100);
		this.nbSkills = 2;
		this.skills = new Skill[2];
		this.skills[0] = new Skill("Boule de feu", 25, 50);
		this.skills[1] = new Skill("Drain", 25, 0);
		this.skills[1].setMpDamage(50);
	}

	@Override
	public void describe() {
		System.out.println("Je suis un mage.");
	}

}
