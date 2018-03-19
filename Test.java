public class Test {

	public static void main(String[] args) {
		Warrior warrior = new Warrior();
		Mage mage = new Mage();
		
		Battle battle = new Battle(warrior, mage);
		battle.run();
	}

}
