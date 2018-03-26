
public class Warrior extends Character {
	
	public Warrior() {
		super(200, 100);
		this.nbSkills = 1;
		this.skills = new Skill[1];
		this.skills[0] = new Skill("Fracasser", 50, 50, true, true);
	}

	@Override
	public void describe() {
		System.out.println("Je suis un guerrier.");
	}

}
