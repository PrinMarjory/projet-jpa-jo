package fr.diginamic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.entites.Organisation;

/**
 * DAO de la classe Organisation
 * 
 * @author Marjory PRIN
 */
public class OrganisationDAO {

	/**
	 * Permet d'ajouter une nouvelle organisation dans la base à partir de son code CIO, code ISO, nom anglais, nom français et statut obsolète ou non
	 * @param em : l'entityManager
	 * @param codeCIO : le code CIO de l'organisation
	 * @param codeISO : le code ISO de l'organisation
	 * @param nomEN : le nom anglais de l'organisation
	 * @param nomFR : le nom français de l'organisation
	 * @param obsolete : le statut obsolete ou non de l'organisation (O : obsolete / N : non obsolete)
	 * @return l'organisation qui vient d'être créé
	 */
	public static Organisation insert(EntityManager em, String codeCIO, String codeISO, String nomEN, String nomFR, String obsolete) {
		Organisation o = new Organisation();
		o.setCodeCIO(codeCIO);
		if(codeISO != null) {
			o.setCodeISO(codeISO);
		}
		o.setNomEN(nomEN);
		if (nomFR != null) {
			o.setNomFR(nomFR);
		}
		o.setObsolete(obsolete);
		em.persist(o);
		o = getByCodeCIO(em, codeCIO);
		return o;
	}
	
	/** 
	 * Permet de récupérer une organisation dans la base à partir de son codeCIO
	 * @param em : l'entityManager
	 * @param codeCIO : le code CIO de l'organisation
	 * @return l'organisation ou null si elle n'existe pas
	 */
	public static Organisation getByCodeCIO(EntityManager em, String codeCIO) {
		TypedQuery<Organisation> query = em.createQuery("SELECT o FROM Organisation o WHERE o.codeCIO=:param", Organisation.class);
		query.setParameter("param", codeCIO);
		List<Organisation> organisations = query.getResultList();
		if (organisations.size()>0) {
			return organisations.get(0);
		}
		return null;
	}
	
}
