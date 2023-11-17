package fr.diginamic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.entites.TraductionEpreuve;
import fr.diginamic.entites.Sport;

/**
 * DAO de la classe TraductionEpreuve
 * 
 * @author Marjory PRIN
 */
public class TraductionEpreuveDAO {

	/**
	 * Permet d'ajouter une traduction épreuve dans la base à partir de son nom anglais et de son nom français
	 * @param em : l'entityManager
	 * @param nomEN : nom en anglais de l'épreuve
	 * @param nomFR : nom en français de l'épreuve
	 * @return l'épreuve qui vient d'être créée
	 */
	public static TraductionEpreuve insert(EntityManager em, String nomEN, String nomFR) {
		TraductionEpreuve e = new TraductionEpreuve();
		e.setNomEN(nomEN);
		if (nomFR != null) {
			e.setNomFR(nomFR);
		}
		em.persist(e);
		e = getByNomEN(em, nomEN);
		return e;
	}
	
	/** 
	 * Permet de récupérer une traduction d'épreuve dans la base à partir de son nom anglais
	 * @param em : l'entityManager
	 * @param nomEN : le nom de l'épreuve en anglais
	 * @return l'épreuve ou null si elle n'existe pas
	 */
	public static TraductionEpreuve getByNomEN(EntityManager em, String nomEN) {
		TypedQuery<TraductionEpreuve> query = em.createQuery("SELECT t FROM TraductionEpreuve t WHERE t.nomEN=:param", TraductionEpreuve.class);
		query.setParameter("param", nomEN);
		List<TraductionEpreuve> epreuves = query.getResultList();
		if (epreuves.size()>0) {
			return epreuves.get(0);
		}
		return null;
	}
	
}
