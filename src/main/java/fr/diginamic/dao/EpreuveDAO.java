package fr.diginamic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.entites.TraductionEpreuve;
import fr.diginamic.entites.Epreuve;
import fr.diginamic.entites.Sport;

/**
 * DAO de la classe Epreuve
 * 
 * @author Marjory PRIN
 */
public class EpreuveDAO {

	/**
	 * Permet d'ajouter une  épreuve dans la base à partir de sa traduction et de son sport
	 * @param em : l'entityManager
	 * @param traduction : la traduction du nom de l'épreuve
	 * @param sport : le sport de l'épreuve
	 * @return l'épreuve qui vient d'être créée
	 */
	public static Epreuve insert(EntityManager em, TraductionEpreuve traduction, Sport sport) {
		Epreuve e = new Epreuve();
		e.setTraduction(traduction);
		e.setSport(sport);
		em.persist(e);
		e = getByTraductionEtSport(em, traduction, sport);
		return e;
	}
	
	/** 
	 * Permet de récupérer une épreuve dans la base à partir de sa traduction et de son sport
	 * @param em : l'entityManager
	 * @param traduction : la traduction du nom de l'épreuve
	 * @param sport : le sport de l'épreuve
	 * @return l'épreuve ou null si elle n'existe pas
	 */
	public static Epreuve getByTraductionEtSport(EntityManager em, TraductionEpreuve traduction, Sport sport) {
		TypedQuery<Epreuve> query = em.createQuery("SELECT e FROM Epreuve e WHERE e.traduction=:param1 AND e.sport=:param2", Epreuve.class);
		query.setParameter("param1", traduction);
		query.setParameter("param2", sport);
		List<Epreuve> epreuves = query.getResultList();
		if (epreuves.size()>0) {
			return epreuves.get(0);
		}
		return null;
	}
	
}
