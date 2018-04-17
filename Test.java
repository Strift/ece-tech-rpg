import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Character hero, enemy;
		
		System.out.println("Choisissez le héros : ");
		hero = characterMenu();
		System.out.println("Choisissez l'ennemi : ");
		enemy = characterMenu();
		
		Battle battle = new Battle(hero, enemy);
		battle.run();
	}
	
	@SuppressWarnings("resource") // Supprime le warning affiché par Eclipse à cause du scanner.close() manquant
	public static Character characterMenu() {
		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		
		// Tant que le choix de l'utilisateur n'est pas compris entre 1 et 3
		do {
			System.out.println("1. Warrior\n 2. Mage\n 3. Priest\nEntrez votre choix...");
			if (scanner.hasNextInt()) {
				choice = scanner.nextInt();	
			}
		} while(choice < 1 || choice > 3);
		// Pas de scanner.close(), car cela fermerait le flux d'entrée System.in
		
		if (choice == 1) {
			return new Warrior();
		} else if (choice == 2) {
			return new Mage();
		} else {
			return new Priest();
		}
	}

}
