import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
		System.out.println("Vous avez choisi " + menu());
	}
	
	public static int menu() {
		Scanner scanner = new Scanner(System.in);
		int choice;

		
		do {
			System.out.println("Que faire ?\n1. Attaquer\n2. Objets\n3. Défense\nEntrez votre choix...");
			choice = scanner.nextInt();
		} while(choice < 1 || choice > 3);
		scanner.close();
		
		return choice;
	}

}
