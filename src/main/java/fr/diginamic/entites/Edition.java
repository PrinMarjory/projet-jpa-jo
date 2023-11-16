package fr.diginamic.entites;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Représente une édition des JO avec son identifiant, son année, sa saison, sa ville et la liste des participations aux épreuves des athlétes
 * 
 * @author Marjory PRIN
 */
@Entity
@Table(name = "EDITION")
public class Edition {

	/** l'identifiant de l'édition*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/** l'année de l'édition */
	@Column(name = "ANNEE", length = 4, nullable = false)
	private int annee;
	
	/** la saison de l'édition (été ou hiver) */
	@Column(name = "SAISON", length = 10, nullable = false)
	private String saison;

	/** la ville de l'édition */
	@Column(name = "VILLE", length = 50, nullable = false)
	private String ville;
	
	/** la liste des participations des athlètes aux épreuves des JO de cette édition */
	@OneToMany(mappedBy = "edition")
	private Set<Participation> participations;
	
	/** Constructeur pour JPA */
	public Edition() {
		super();
		participations = new HashSet<Participation>();
	}

	@Override
	public String toString() {
		return ville.toUpperCase() + " " + annee + " (" + saison.toUpperCase() + ")";
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
	 * @return the annee
	 */
	public int getAnnee() {
		return annee;
	}

	/** Setter
	 * @param annee the annee to set
	 */
	public void setAnnee(int annee) {
		this.annee = annee;
	}

	/** Getter
	 * @return the saison
	 */
	public String getSaison() {
		return saison;
	}

	/** Setter
	 * @param saison the saison to set
	 */
	public void setSaison(String saison) {
		this.saison = saison;
	}

	/** Getter
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}

	/** Setter
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/** Getter
	 * @return the participations
	 */
	public Set<Participation> getParticipations() {
		return participations;
	}

	/** Setter
	 * @param participations the participations to set
	 */
	public void setParticipations(Set<Participation> participations) {
		this.participations = participations;
	}
}
