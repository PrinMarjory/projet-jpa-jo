package fr.diginamic.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Représente une participation d'un athlète à une épreuve des JO avec son identifiant, l'athète concerné avec son age, son poids et sa taille pour cette participation, 
 * la médaille gagnée, son équipe, ainsi que l'épreuve et l'édition concernées
 * 
 * @author Marjory PRIN
 */
@Entity
@Table(name = "PARTICIPATION")
public class Participation {

	/** l'identifiant de la participation */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/** l'athlète participant */
	@ManyToOne
	@JoinColumn(name = "ATHLETE_ID")
	private Athlete athlete;
	
	/** l'age de l'athlète */
	@Column(name = "AGE", length = 3, nullable = true)
	private int age;
	
	/** le poids de l'athlète */
	@Column(name = "POIDS", length = 10, nullable = true)
	private double poids;
	
	/** la taille de l'athlète */
	@Column(name = "TAILLE", length = 3, nullable = true)
	private int taille;
	
	/** la médaille obtenue (si il y en a une) */
	@Column(name = "MEDAILLE", length = 10, nullable = true)
	private String medaille;
	
	/** l'équipe de l'athlète */
	@ManyToOne
	@JoinColumn(name = "EQUIPE_ID")
	private Equipe equipe;
	
	/** l'épreuve concernée */
	@ManyToOne
	@JoinColumn(name = "EPREUVE_ID")
	private Epreuve epreuve;
	
	/** l'édition des JO concerné */
	@ManyToOne
	@JoinColumn(name = "EDITION_ID")
	private Edition edition;
	
	/** Constructeur pour JPA */
	public Participation() {
		super();
	}
	
	@Override
	public String toString() {
		String resultat = "pas de médaille";
		if (medaille != null) {
			resultat = medaille;
		}
		return edition + " " + epreuve + " " + athlete + " : " + resultat;
	}

	/** Getter
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/** Setter
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/** Getter
	 * @return the athlete
	 */
	public Athlete getAthlete() {
		return athlete;
	}

	/** Setter
	 * @param athlete the athlete to set
	 */
	public void setAthlete(Athlete athlete) {
		this.athlete = athlete;
	}

	/** Getter
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/** Setter
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/** Getter
	 * @return the poids
	 */
	public double getPoids() {
		return poids;
	}

	/** Setter
	 * @param poids the poids to set
	 */
	public void setPoids(double poids) {
		this.poids = poids;
	}

	/** Getter
	 * @return the taille
	 */
	public int getTaille() {
		return taille;
	}

	/** Setter
	 * @param taille the taille to set
	 */
	public void setTaille(int taille) {
		this.taille = taille;
	}

	/** Getter
	 * @return the medaille
	 */
	public String getMedaille() {
		return medaille;
	}

	/** Setter
	 * @param medaille the medaille to set
	 */
	public void setMedaille(String medaille) {
		this.medaille = medaille;
	}

	/** Getter
	 * @return the equipe
	 */
	public Equipe getEquipe() {
		return equipe;
	}

	/** Setter
	 * @param equipe the equipe to set
	 */
	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	/** Getter
	 * @return the epreuve
	 */
	public Epreuve getEpreuve() {
		return epreuve;
	}

	/** Setter
	 * @param epreuve the epreuve to set
	 */
	public void setEpreuve(Epreuve epreuve) {
		this.epreuve = epreuve;
	}

	/** Getter
	 * @return the edition
	 */
	public Edition getEdition() {
		return edition;
	}

	/** Setter
	 * @param edition the edition to set
	 */
	public void setEdition(Edition edition) {
		this.edition = edition;
	}
}
