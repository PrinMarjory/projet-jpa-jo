package fr.diginamic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.entites.Epreuve;

/**
 * DAO de la classe Epreuve
 * 
 * @author Marjory PRIN
 */
public class EpreuveDAO {

	/**
	 * Permet d'ajouter une épreuve dans la base à partir de son nom anglais et de son nom français
	 * @param em : l'entityManager
	 * @param nomEN : nom en anglais de l'épreuve
	 * @param nomFR : nom en français de l'épreuve
	 * @return l'épreuve qui vient d'être créée
	 */
	public static Epreuve insert(EntityManager em, String nomEN, String nomFR) {
		Epreuve e = new Epreuve();
		e.setNomEN(nomEN);
		if (nomFR != null) {
			e.setNomFR(nomFR);
		}
		em.persist(e);
		e = getByNomEN(em, nomEN);
		return e;
	}
	
	/** 
	 * Permet de récupérer une épreuve dans la base à partir de son nom anglais
	 * @param em : l'entityManager
	 * @param nomEN : le nom de l'épreuve en anglais
	 * @return l'épreuve ou null si elle n'existe pas
	 */
	public static Epreuve getByNomEN(EntityManager em, String nomEN) {
		TypedQuery<Epreuve> query = em.createQuery("SELECT e FROM Epreuve e WHERE e.nomEN=:param", Epreuve.class);
		query.setParameter("param", nomEN);
		List<Epreuve> epreuves = query.getResultList();
		if (epreuves.size()>0) {
			return epreuves.get(0);
		}
		return null;
	}
	
}
