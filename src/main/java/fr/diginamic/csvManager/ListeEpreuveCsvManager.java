package fr.diginamic.csvManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.diginamic.dao.TraductionEpreuveDAO;
import fr.diginamic.entites.TraductionEpreuve;

/** 
 * Permet de lire le fichier liste_des_epreuves.csv et de remplir la base de donnée JO associée
 * 
 * @author Marjory PRIN
 */
public class ListeEpreuveCsvManager {
	
	/**
	 * Lit le contenu du fichier en paramètre contenant les données de traduction des épreuves des JO, transforme ces données au format attendu
	 * et remplie la base de donnée JO en accordance
	 * @param cheminFichier : le chemin d'accès du fichier sur le disque dur
	 * @param ligneDebut : le numéro de ligne ou commencer à charger le fichier csv
	 */
	public static void chargerEpreuve(Path cheminFichier, int ligneDebut) {
		
		try {
			
			// Lecture du fichier 
			List<String> lignes = Files.readAllLines(cheminFichier);
			
			// Connexion à la base de donnée 
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("jo");
			EntityManager em = emf.createEntityManager();
			EntityTransaction transaction = em.getTransaction();
			
			// Traitement des lignes du fichier csv pour ajout dans la base
			for (int i = ligneDebut; i<lignes.size(); i++) {
				
				// Récupération des valeurs de chaque colonne de la ligne dans un tableau
				String[] morceaux = lignes.get(i).split(";");
				
				// Récupération du nom anglais et du nom français si il existe
				String nomEN = morceaux[0];
				String nomFR = null;
				if (morceaux.length>1) {
					nomFR = morceaux[1];
				}
				
				// Insertion en base si l'épreuve n'existe pas encore
				transaction.begin();
				TraductionEpreuve epreuve = new TraductionEpreuve();
				epreuve = TraductionEpreuveDAO.getByNomEN(em, morceaux[0]);
				if (epreuve == null) {
					TraductionEpreuveDAO.insert(em, nomEN, nomFR);
				}
				transaction.commit();
			}
			
			// Fermeture de la connexion
			em.close();
			emf.close();
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
