package fr.diginamic.entites;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Représente une épreuve des JO avec son identifiant, son nom anglais, le sport correspondant et son nom français et la liste des participations des athlètes
 * 
 * @author Marjory PRIN
 */
@Entity
@Table(name = "EPREUVE")
public class Epreuve {

	/** l'identifiant de l'épreuve */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/** le nom de l'épreuve en anglais */
	@Column(name = "NOM_EN", length = 100, nullable = false, unique = true)
	private String nomEN;
	
	/** le nom de l'épreuve en français */
	@Column(name = "NOM_FR", length = 100, nullable = true)
	private String nomFR;
	
	/** le sport correspondant à l'épreuve */
	@ManyToOne
	@JoinColumn(name = "SPORT_ID")
	private Sport sport;
	
	/** la liste des participations des athlètes à cette épreuve des JO */
	@OneToMany(mappedBy = "epreuve")
	private Set<Participation> participations;
	
	/** Constructeur pour JPA */
	public Epreuve() {
		super();
		participations = new HashSet<Participation>();
	}

	@Override
	public String toString() {
		return nomFR;
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
	 * @return the nomEN
	 */
	public String getNomEN() {
		return nomEN;
	}

	/** Setter
	 * @param nomEN the nomEN to set
	 */
	public void setNomEN(String nomEN) {
		this.nomEN = nomEN;
	}

	/** Getter
	 * @return the nomFR
	 */
	public String getNomFR() {
		return nomFR;
	}

	/** Setter
	 * @param nomFR the nomFR to set
	 */
	public void setNomFR(String nomFR) {
		this.nomFR = nomFR;
	}

	/** Getter
	 * @return the sport
	 */
	public Sport getSport() {
		return sport;
	}

	/** Setter
	 * @param sport the sport to set
	 */
	public void setSport(Sport sport) {
		this.sport = sport;
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
