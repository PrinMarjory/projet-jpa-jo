package fr.diginamic.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.commons.lang3.math.NumberUtils;

import fr.diginamic.dao.*;
import fr.diginamic.entites.*;

/** 
 * Permet de lire le fichier evenements.csv et de remplir la base de donnée JO associée
 * 
 * @author Marjory PRIN
 */
public class EvenementsCsvUtils {

	/**
	 * Lit le contenu du fichier en paramètre contenant les données des évennements des JO, transforme ces données au format attendu
	 * et remplie la base de donnée JO en accordance
	 * @param cheminFichier : le chemin d'accès du fichier sur le disque dur
	 * @param ligneDebut : le numéro de ligne ou commencer à charger le fichier csv
	 */
	public static void chargerEvenement(Path cheminFichier, int ligneDebut) {
			
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jo");
		EntityManager em = emf.createEntityManager();
		
		try {
			
			// Lecture du fichier 
			List<String> lignes = Files.readAllLines(cheminFichier);
			
			// Connexion à la base de donnée 
			EntityTransaction transaction = em.getTransaction();
			
			// Traitement des lignes du fichier csv pour ajout dans la base
			for (int i = ligneDebut; i<100; i++) {
					
				// Récupération des valeurs de chaque colonne de la ligne dans un tableau
				String[] morceaux = lignes.get(i).split(";");
					
				// Récupération des données
				int idJo = Integer.parseInt(morceaux[0]);
				String nomAthlete = morceaux[1];
				String sexe = null;
				switch (morceaux[2]) {
					case "M": 
						sexe = "H";
						break;
					case "F":
						sexe = "F";
						break;
				}
				int age = 0;
				if (NumberUtils.isCreatable(morceaux[3])) {
					age = Integer.parseInt(morceaux[3]);
				}
				int taille = 0;
				if (NumberUtils.isCreatable(morceaux[4])) {
					taille = Integer.parseInt(morceaux[4]);
				}
				double poids = 0;
				if (NumberUtils.isCreatable(morceaux[5])) {
					poids = Double.parseDouble(morceaux[5]);
				}
				String nomEquipe = morceaux[6];
				String codeCIO = morceaux[7];
				int annee = Integer.parseInt(morceaux[9]);
				String saison = null;
				switch (morceaux[10]) {
					case "Summer": 
						saison = "Eté";
						break;
					case "Winter":
						saison = "Hiver";
						break;
				}
				String ville = morceaux[11];
				String nomSport = morceaux[12];
				String nomEpreuve = morceaux[13];
				String medaille = null;
				switch (morceaux[14]) {
					case "Gold": 
						medaille = "Or";
						break;
					case "Silver":
						medaille = "Argent";
						break;
					case "Bronze":
						medaille = "Bronze";
						break;
					default :
						medaille = "";
				}
			
				transaction.begin();
				
				// Insertion en base de l'athlète si il n'existe pas encore
				Athlete athlete = new Athlete();
				athlete = AthleteDAO.getByIdJo(em, idJo);
				if (athlete == null) {
					athlete = AthleteDAO.insert(em, idJo, nomAthlete, sexe);
				}
				
				// Insertion en base de l'équipe si elle n'existe pas encore
				Equipe equipe = new Equipe();
				equipe = EquipeDAO.getByNom(em, nomEquipe);
				if (equipe == null) {
					Organisation organisation = new Organisation();
					organisation = OrganisationDAO.getByCodeCIO(em, codeCIO);
					equipe = EquipeDAO.insert(em, nomEquipe, organisation);
				}
				
				// Insertion en base de l'édition si elle n'existe pas encore
				Edition edition = new Edition(); 
				edition = EditionDAO.getByAnneeEtSaison(em, annee, saison);
				if (edition == null) {
					edition = EditionDAO.insert(em, annee, saison, ville);
				}	
				
				// Insertion en base de l'épreuve si elle n'existe pas encore
				TraductionEpreuve traduction = new TraductionEpreuve();
				if (nomEpreuve.startsWith(nomSport)) {
					nomEpreuve = nomEpreuve.replace(nomSport + " ", "");
				} 
				traduction = TraductionEpreuveDAO.getByNomEN(em, nomEpreuve);
				Sport sport = new Sport();
				sport = SportDAO.getByNomEN(em, nomSport);
				Epreuve epreuve = new Epreuve();
				epreuve = EpreuveDAO.getByTraductionEtSport(em, traduction, sport);
				if (epreuve == null) {
					epreuve = EpreuveDAO.insert(em, traduction, sport);
				} 
				
				// Insertion en base de la participation
				Participation participation = new Participation();
				participation = ParticipationDAO.insert(em, athlete, age, poids, taille, medaille, equipe, edition, epreuve);
				
				transaction.commit();
			}						
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			// Fermeture de la connexion
			em.close();
			emf.close();
		}
	}
}
