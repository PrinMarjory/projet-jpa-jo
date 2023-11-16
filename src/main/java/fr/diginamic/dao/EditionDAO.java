package fr.diginamic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.entites.Edition;

/**
 * DAO de la classe Edition
 * 
 * @author Marjory PRIN
 */
public class EditionDAO {

	/**
	 * Permet d'ajouter une nouvelle édition dans la base à partir de son année, saison et ville
	 * @param em : l'entityManager
	 * @param annee : l'année de l'édition
	 * @param saison : la saison de l'édition (été ou hiver)
	 * @param ville : la ville de l'édition
	 * @return l'édition qui vient d'être créée
	 */
	public static Edition insert(EntityManager em, int annee, String saison, String ville) {
		Edition e = new Edition();
		e.setAnnee(annee);
		e.setSaison(saison);
		e.setVille(ville);
		em.persist(e);
		e = getByAnneeEtSaison(em, annee, saison);
		return e;
	}
	
	/** 
	 * Permet de récupérer une édition dans la base à partir de son année et de sa saison
	 * @param em : l'entityManager
	 * @param annee : l'année recherchée
	 * @param saison : la saison recherchée
	 * @return l'édition ou null si elle n'existe pas
	 */
	public static Edition getByAnneeEtSaison(EntityManager em, int annee, String saison) {
		TypedQuery<Edition> query = em.createQuery("SELECT e FROM Edition e WHERE e.annee=:param1 AND e.saison=:param2", Edition.class);
		query.setParameter("param1", annee);
		query.setParameter("param2", saison);
		List<Edition> editions = query.getResultList();
		if (editions.size()>0) {
			return editions.get(0);
		}
		return null;
	}
	
}
