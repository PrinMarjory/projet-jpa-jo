package fr.diginamic;

import java.util.Scanner;
import fr.diginamic.service.*;

public class ApplicationRecherche {

	public static void main(String[] args) {
		
		// Initialisation
		Scanner scanner = new Scanner(System.in);
		MenuService recherche = null;
		int option = 0;
		
		// Boucle de retour au menu
		while (option != 4) {
			
			// Affichage du menu
			System.out.println("\n/////////////////////////////////////////\n\n"
					+ "                   MENU\n"
					+ "-----------------------------------------\n"
					+ "1. Tableau des médailles depuis la création des JO\n"
					+ "2. Tableau des médailles par sport\n"
					+ "3. Tableau des médailles par sport et épreuve\n"
					+ "4. Sortir\n\n"
					+ "Saisir le numéro de l'option voulue :");
			
			option = scanner.nextInt();	
			while (option > 4 || option < 1) {
				System.out.println("\nLe numéro saisi ne correspond pas à une option du menu, veuillez saisir un chiffre entre 1 et 4 :");
				option = scanner.nextInt();	
			}
			
			// Choix de l'utilisateur
			switch (option) {
				case 1:
					recherche = new TableauMedailleComplet();
					recherche.traiter(scanner);
					break;
				case 2:
					recherche = new TableauMedailleSport();
					recherche.traiter(scanner);
					break;
				case 3:
					recherche = new TableauMedailleSportEtEpreuve();
					recherche.traiter(scanner);
					break;
				case 4:
					System.out.println("\n/////////////////////////////////////////\n\n"
							+ "                   FIN\n\n/////////////////////////////////////////");
					break;
			}
		}

	}

}
