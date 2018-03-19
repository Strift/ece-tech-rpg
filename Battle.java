import java.util.Scanner;

public class Battle {

	protected Character hero;
	protected Character enemy;
	protected int turns;
	
	public Battle(Character hero, Character enemy) {
		this.hero = hero;
		this.enemy = enemy;
		this.turns = 0;
	}
	
	public int menu() {
		@SuppressWarnings("resource") // Supprime le warning affiché par Eclipse à cause du scanner.close() manquant
		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		
		// Tant que le choix de l'utilisateur n'est pas compris entre 1 et 3
		do {
			System.out.println("Que faire ?\n1. Attaquer\n2. Objets\n3. Défense\nEntrez votre choix...");
			if (scanner.hasNextInt()) {
				choice = scanner.nextInt();	
			}
		} while(choice < 1 || choice > 3);
		// Pas de scanner.close(), car cela fermerait le flux d'entrée System.in
		
		return choice;
	}
	
	public void run() {
		// Représente le personnage qui prendra les dégâts ce tour ci
		Character defender = null;
		
		// Tant qu'au moins un des deux héros est vivant
		while(hero.isDead() == false && enemy.isDead() == false) {	
			if (this.turns%2 == 0) {
				defender = enemy;
				System.out.println("C'est à votre tour.");
			} else {
				defender = hero;
				System.out.println("C'est au tour de l'ennemi.");
			}
			// On affiche le menu
			int choice = menu();
			if (choice != 1) {
				System.out.println("Oups... cette option n'est pas implémentée !");
			} else {
				if (this.turns%2 == 0) {
					System.out.println("Vous attaquez l'ennemi.");
				} else {
					System.out.println("L'ennemi vous attaque.");
				}
				// On inflige les dégâts
				defender.receiveDamage(50);
				// On affiche un état des points de vie de tout le monde
				System.out.println("Héros : " + hero.getStatus());
				System.out.println("Ennemi : " + enemy.getStatus());
			}
			this.turns++; // On met à jour le compteur de tours
		}
		
		// Si on a quitté la boucle, c'est qu'un des deux combattants est mort
		System.out.println("Le combat est terminé !");
	}
}
