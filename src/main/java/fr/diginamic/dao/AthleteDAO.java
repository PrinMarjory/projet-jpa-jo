package fr.diginamic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.entites.Athlete;

/**
 * DAO de la classe Athlète
 * 
 * @author Marjory PRIN
 */
public class AthleteDAO {

	/**
	 * Permet d'ajouter un nouvel athlète dans la base à partir de son id JO, de son nom et de son sexe
	 * @param em : l'entityManager
	 * @param idJO : l'identifiant JO
	 * @param nom : le nom de l'athlète
	 * @param sexe : le sexe (H ou F) de l'athlète
	 * @return l'athlète qui vient d'être créé
	 */
	public static Athlete insert(EntityManager em, int idJO, String nom, String sexe) {
		Athlete a = new Athlete();
		a.setIdJO(idJO);
		a.setNom(nom);
		a.setSexe(sexe);
		em.persist(a);
		a = getByIdJo(em, idJO);
		return a;
	}
	
	/** 
	 * Permet de récupérer un athlète dans la base à partir de son idJO
	 * @param em : l'entityManager
	 * @param idJO : l'identifiant JO de l'athlète 
	 * @return l'athlète ou null si il n'existe pas
	 */
	public static Athlete getByIdJo(EntityManager em, int idJO) {
		TypedQuery<Athlete> query = em.createQuery("SELECT a FROM Athlete a WHERE a.idJO=:param", Athlete.class);
		query.setParameter("param", idJO);
		List<Athlete> athletes = query.getResultList();
		if (athletes.size()>0) {
			return athletes.get(0);
		}
		return null;
	}
	
}
