package fr.diginamic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.entites.Equipe;
import fr.diginamic.entites.Organisation;

/**
 * DAO de la classe Equipe
 * 
 * @author Marjory PRIN
 */
public class EquipeDAO {

	/**
	 * Permet d'ajouter une nouvelle équipe dans la base à partir de son nom et de son organisation
	 * @param em : l'entityManager
	 * @param nom : le nom de l'équipe
	 * @param organisation : l'organisation d'appartenance de l'équipe
	 * @return l'équipe qui vient d'être créée
	 */
	public static Equipe insert(EntityManager em, String nom, Organisation organisation) {
		Equipe e = new Equipe();
		e.setNom(null);
		e.setOrganisation(organisation);
		em.persist(e);
		e = getByNom(em, nom);
		return e;
	}
	
	/** 
	 * Permet de récupérer une équipe dans la base à partir de son nom
	 * @param em : l'entityManager
	 * @param nom : le nom de l'équipe 
	 * @return l'équipe ou null si elle n'existe pas
	 */
	public static Equipe getByNom(EntityManager em, String nom) {
		TypedQuery<Equipe> query = em.createQuery("SELECT e FROM Equipe e WHERE e.nom=:param", Equipe.class);
		query.setParameter("param", nom);
		List<Equipe> equipes = query.getResultList();
		if (equipes.size()>0) {
			return equipes.get(0);
		}
		return null;
	}
	
}
