package fr.diginamic.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.diginamic.dao.OrganisationDAO;
import fr.diginamic.entites.Organisation;

/** 
 * Permet de lire le fichier liste_des_organisation.csv et de remplir la base de donnée JO associée
 * 
 * @author Marjory PRIN
 */
public class ListeOrganisationCsvUtils {
	
	/**
	 * Lit le contenu du fichier en paramètre contenant les données des organisation des JO, transforme ces données au format attendu
	 * et remplie la base de donnée JO en accordance
	 * @param cheminFichier : le chemin d'accès du fichier sur le disque dur
	 * @param ligneDebut : le numéro de ligne ou commencer à charger le fichier csv
	 */
	public static void chargerOrganisation(Path cheminFichier, int ligneDebut) {
		
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
				
				// Supression des espaces avant et après les noms anglais et français des organisations
				String codeCIO = morceaux[0];
				String nomFR = morceaux[1].strip();
				String nomEN = morceaux[2].strip();
				String codeISO = morceaux[3];
				String obsolete = morceaux[4];
				
				// Insertion en base si l'organisation n'existe pas encore
				transaction.begin();
				Organisation organisation = new Organisation();
				organisation = OrganisationDAO.getByCodeCIO(em, codeCIO);
				if (organisation == null) {
					OrganisationDAO.insert(em, codeCIO, codeISO, nomEN, nomFR, obsolete);
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
