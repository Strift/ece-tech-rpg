
public class Mage extends Character {
	
	public Mage() {
		super(100, 100);
		this.nbSkills = 1;
		this.skills = new Skill[1];
		this.skills[0] = new Skill("Boule de feu", 25, 50);
	}

	@Override
	public void describe() {
		System.out.println("Je suis un mage.");
	}

}
