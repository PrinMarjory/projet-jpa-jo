package fr.diginamic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.entites.Sport;

/**
 * DAO de la classe Sport
 * 
 * @author Marjory PRIN
 */
public class SportDAO {

	/**
	 * Permet d'ajouter un nouveau sport dans la base à partir de son nom anglais et de son nom français
	 * @param em : l'entityManager
	 * @param nomEN : le nom anglais du sport
	 * @param nomFR : le nom français du sport
	 * @return le sport qui vient d'être créé
	 */
	public static Sport insert(EntityManager em, String nomEN, String nomFR) {
		Sport s = new Sport();
		s.setNomEN(nomEN);
		if (nomFR != null) {
			s.setNomFR(nomFR);
		}
		em.persist(s);
		s = getByNomEN(em, nomEN);
		return s;
	}
	
	/** 
	 * Permet de récupérer un sport dans la base à partir de son nom anglais
	 * @param em : l'entityManager
	 * @param nomEN : le nom anglais du sport
	 * @return le sport ou null si il n'existe pas
	 */
	public static Sport getByNomEN(EntityManager em, String nomEN) {
		TypedQuery<Sport> query = em.createQuery("SELECT s FROM Sport s WHERE s.nomEN=:param", Sport.class);
		query.setParameter("param", nomEN);
		List<Sport> sports = query.getResultList();
		if (sports.size()>0) {
			return sports.get(0);
		}
		return null;
	}
	
}
