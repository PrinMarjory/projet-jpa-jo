package fr.diginamic.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.diginamic.entites.*;
import fr.diginamic.utils.TableauMedailleComparateur;

/**
 * Représente le tableau des médailles des JO depuis sa création
 * 
 * @author Marjory PRIN
 */
public class TableauMedailleComplet extends MenuService {

	/**
	 * Traite la demande de recherche et affiche le résultat
	 * @param scanner : non utilisé dans ce cas de figure
	 */
	@Override
	public void traiter(Scanner scanner) {
		
		// Connexion à la base de donnée
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jo");
		EntityManager em = emf.createEntityManager();
		
		// Création d'une liste contenant le tableau des médailles de chaque organisation
		List<TableauMedaille> tableauMedailles = new ArrayList<TableauMedaille>();
		
		// Extraction des medailles par organisation
		TypedQuery<Organisation> queryOrg = em.createQuery("SELECT o FROM Organisation o", Organisation.class);
		List<Organisation> organisations = queryOrg.getResultList();	
		for (Organisation o : organisations) {
			
			// Compte des médailles or
			TypedQuery<Participation> queryPart = em.createQuery("SELECT DISTINCT p FROM Participation p JOIN p.equipe eq JOIN eq.organisation o WHERE o.codeCIO=:param1 AND p.medaille=:param2", Participation.class);
			queryPart.setParameter("param1", o.getCodeCIO());
			queryPart.setParameter("param2", "Or");
			List<Participation> medailleOr = queryPart.getResultList();	
			
			// Compte des médailles argent
			queryPart.setParameter("param2", "Argent");
			List<Participation> medailleArgent = queryPart.getResultList();	
			
			// Compte des médailles bronze
			queryPart.setParameter("param2", "Bronze");
			List<Participation> medailleBronze = queryPart.getResultList();	
			
			TableauMedaille medailles = new TableauMedaille(o.getCodeCIO(), o.getNomFR(), medailleOr.size(), medailleArgent.size(), medailleBronze.size());
			tableauMedailles.add(medailles);
			Collections.sort(tableauMedailles, new TableauMedailleComparateur());
		}
		
		// Affichage du tableau des médailles
		System.out.println("\n/////////////////////////////////////////\n");
		System.out.println("Tableau des médailles depuis la création des JO :\n");
		System.out.println("\tOr\tArgent\tBronze");
		for (TableauMedaille tab: tableauMedailles) {
			System.out.println(tab);
		}
		
		// Deconnexion à la base de donnée
		em.close();
		emf.close();
		
	}

	
}
