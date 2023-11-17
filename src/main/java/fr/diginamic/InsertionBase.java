package fr.diginamic;

import java.nio.file.Path;
import java.nio.file.Paths;

import fr.diginamic.utils.EvenementsCsvUtils;
import fr.diginamic.utils.ListeEpreuveCsvUtils;
import fr.diginamic.utils.ListeOrganisationCsvUtils;
import fr.diginamic.utils.ListeSportCsvUtils;

/**
 * Permet de remplir la base de donnée JO
 * @author Marjory PRIN
 */
public class InsertionBase {
	
	public static void main(String[] args) {
		
		// Début du chrono
		long startTime = System.currentTimeMillis();
		
		// Traitement du fichier liste_des_sports.csv et insertion en base
		Path path = Paths.get("C:/Users/marjo/Documents/Diginamic/Java/projet-jpa-jo/src/main/resources/liste_des_sports.csv");
		ListeSportCsvUtils.chargerSport(path, 1);
		
		// Traitement du fichier liste_des_organisations.csv et insertion en base
		path = Paths.get("C:/Users/marjo/Documents/Diginamic/Java/projet-jpa-jo/src/main/resources/liste_des_organisations.csv");
		ListeOrganisationCsvUtils.chargerOrganisation(path, 1);
		
		// Traitement du fichier liste_des_epreuves.csv et insertion en base
		path = Paths.get("C:/Users/marjo/Documents/Diginamic/Java/projet-jpa-jo/src/main/resources/liste_des_epreuves.csv");
		ListeEpreuveCsvUtils.chargerEpreuve(path, 1);
		
		// Traitement du fichier evenement.csv et insertion en base
		path = Paths.get("C:/Users/marjo/Documents/Diginamic/Java/projet-jpa-jo/src/main/resources/evenements.csv");
		EvenementsCsvUtils.chargerEvenement(path, 1);
		
		// Fin du chrono et affichage du temps passé à traiter le fichier csv et charger la base de donnée
		long endTime = System.currentTimeMillis();
		System.out.println("Temps d'exécution = " + (endTime-startTime)/1000 + "s");
	}

}