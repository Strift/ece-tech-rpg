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

	@SuppressWarnings("resource") // Supprime le warning affiché par Eclipse à cause du scanner.close() manquant
	public int menu() {
		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		
		// Tant que le choix de l'utilisateur n'est pas compris entre 1 et 3
		do {
			System.out.println("Menu\n 1. Attaquer\n 2. Compétences\n 3. Défense\nEntrez votre choix...");
			if (scanner.hasNextInt()) {
				choice = scanner.nextInt();	
			}
		} while(choice < 1 || choice > 3);
		// Pas de scanner.close(), car cela fermerait le flux d'entrée System.in
		
		return choice;
	}
	
	@SuppressWarnings("resource") // Supprime le warning affiché par Eclipse à cause du scanner.close() manquant
	public Skill skillMenu(Character character) {
		int choice = 0;
		int nbSkills = character.getNbSkills();
		Scanner scanner = new Scanner(System.in);
		
		// Tant que le choix de l'utilisateur n'est pas compris entre 1 et nbSkills+1
		do {
			// On affiche toutes les compétences du personnage
			System.out.println("Compétences");
			for (int i = 0; i < nbSkills; i++) {
				Skill skill = character.getSkill(i);
				System.out.println(" " + (i+1) + ". " + skill.getName() + "\t(" + skill.getMpCost() + " MP)");
			}
			// On affiche le choix 'Retour'
			System.out.println((nbSkills+1) + ". Retour");
			// On demande à l'utilisateur de saisir un nombre
			if (scanner.hasNextInt()) {
				choice = scanner.nextInt();	
			}
		} while(choice < 1 || choice > (nbSkills+1));
		// Pas de scanner.close(), car cela fermerait le flux d'entrée System.in
		
		// On retourne le Skill choisi, ou null si 'Retour'
		if (choice == (nbSkills+1)) {
			return null;
		}
		return character.getSkill(choice-1);
	}
	
	public void run() {
		// Représente à tour de rôle l'un et l'autre des personnages
		Character attacker = null, defender = null;
		
		// Tant qu'au moins un des deux héros est vivant
		while(hero.isDead() == false && enemy.isDead() == false) {
			// Affichage du statut des combatttants
			this.printStatuses();
			// On regarde c'est le tour de qui
			if (this.turns%2 == 0) {
				attacker = hero;
				defender = enemy;
				System.out.println("C'est à votre tour.");
			} else {
				attacker = enemy;
				defender = hero;
				System.out.println("C'est au tour de l'ennemi.");
			}
			// On affiche le menu
			boolean promptMenu;
			do {
				promptMenu = false;
				int choice = menu();
				if (choice == 1) { // Attaquer
					if (this.turns%2 == 0) {
						System.out.println("Vous attaquez l'ennemi.");
					} else {
						System.out.println("L'ennemi vous attaque.");
					}
					// On inflige les dégâts
					defender.receiveDamage(30);
				} else if (choice == 2) { // Compétences
					Skill skill = this.skillMenu(attacker);
					if (skill == null) {
						// Le joueur a choisir 'Retour'
						promptMenu = true;
					} else {
						if (attacker.canCast(skill)) {
							attacker.cast(skill, defender);
							System.out.println(skill.getName() + "!");
						} else {
							System.out.println("Pas assez de MP !");
						}
					}
				} else {
					System.out.println("Oups... cette option n'est pas implémentée !");
					promptMenu = true; // On souhaite afficher le menu à nouveau
					
				}
			} while (promptMenu);
			
			this.turns++; // On met à jour le compteur de tours
		}
		
		// Si on a quitté la boucle, c'est qu'un des deux combattants est mort
		System.out.println("Le combat est terminé !");
		this.printStatuses();
	}
	
	public void printStatuses() {
		System.out.println("Héros\t" + hero.getStatus());
		System.out.println("Ennemi\t" + enemy.getStatus());
	}
}
