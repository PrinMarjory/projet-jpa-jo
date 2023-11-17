package fr.diginamic.dao;

import javax.persistence.EntityManager;

import fr.diginamic.entites.Athlete;
import fr.diginamic.entites.Edition;
import fr.diginamic.entites.Epreuve;
import fr.diginamic.entites.Equipe;
import fr.diginamic.entites.Participation;

/**
 * DAO de la classe Participation
 * 
 * @author Marjory PRIN
 */
public class ParticipationDAO {

	/**
	 * Permet d'ajouter une nouvelle participation dans la base à partir de :
	 * @param em : l'entityManager
	 * @param athlete : l'athlète participant
	 * @param age : l'age de l'athlète participant
	 * @param poids : l'age de l'athlète participant
	 * @param taille : l'age de l'athlète participant
	 * @param medaille : la médaille gagnée par le participant si il y en a une 
	 * @param equipe : l'équipe de l'athlète pour cette participation
	 * @param edition : l'édition des JO
	 * @param epreuve : l'épreuve contestée
	 * @return la participation qui vient d'être créée
	 */
	public static Participation insert(EntityManager em, Athlete athlete, int age, double poids, int taille, String medaille, Equipe equipe, Edition edition, Epreuve epreuve) {
		Participation p = new Participation();
		p.setAthlete(athlete);
		p.setAge(age);
		p.setPoids(poids);			
		p.setTaille(taille);
		p.setMedaille(medaille);
		p.setEquipe(equipe);
		p.setEdition(edition);
		p.setEpreuve(epreuve);
		em.persist(p);
		return p;
	}
	
}
