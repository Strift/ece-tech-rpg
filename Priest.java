
public class Priest extends Character {

	public Priest() {
		super(100, 100);
		this.nbSkills = 1;
		this.skills = new Skill[1];
		this.skills[1] = new Skill("Soin", 25, -50, true, false);
	}
	
	@Override
	public void describe() {
		System.out.println("Je suis un prêtre.");
	}

}
