package fr.diginamic;

import java.nio.file.Path;
import java.nio.file.Paths;

import fr.diginamic.csvManager.EvenementsCsvManager;
import fr.diginamic.csvManager.ListeEpreuveCsvManager;
import fr.diginamic.csvManager.ListeOrganisationCsvManager;
import fr.diginamic.csvManager.ListeSportCsvManager;

/**
 * Permet de remplir la base de donnée JO
 * @author Marjory PRIN
 */
public class InsertionBase {
	
	public static void main(String[] args) {
		
		// Traitement du fichier liste_des_sports.csv et insertion en base
		Path path = Paths.get("C:/Users/marjo/Documents/Diginamic/Java/projet-jpa-jo/src/main/resources/liste_des_sports.csv");
		ListeSportCsvManager.chargerSport(path, 1);
		
		// Traitement du fichier liste_des_organisations.csv et insertion en base
		path = Paths.get("C:/Users/marjo/Documents/Diginamic/Java/projet-jpa-jo/src/main/resources/liste_des_organisations.csv");
		ListeOrganisationCsvManager.chargerOrganisation(path, 1);
		
		// Traitement du fichier liste_des_epreuves.csv et insertion en base
		path = Paths.get("C:/Users/marjo/Documents/Diginamic/Java/projet-jpa-jo/src/main/resources/liste_des_epreuves.csv");
		ListeEpreuveCsvManager.chargerEpreuve(path, 1);
		
		// Traitement du fichier evenement.csv et insertion en base
		path = Paths.get("C:/Users/marjo/Documents/Diginamic/Java/projet-jpa-jo/src/main/resources/evenements.csv");
		EvenementsCsvManager.chargerEvenement(path, 1);
	
	}

}