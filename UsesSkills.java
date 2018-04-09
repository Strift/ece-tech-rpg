
public interface UsesSkills {
	
	public boolean canCast(Skill skill);
	
	public void cast(Skill skill, Character enemy);
	
	public void consumeMp(Skill skill);
	
	public int getNbSkills();
	
	public Skill getSkill(int indice);

}
