
public interface Killable {

	public boolean isDead();
	
	public void receiveDamage(int damage);
	
	public void receivePhysicalDamage(int damage);
	
	public void receiveMpDamage(int damage);
}
