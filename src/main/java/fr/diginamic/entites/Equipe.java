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
 * Représente une équipe participant aux JO avec son identifiant, son nom, son organisation et la liste de ses participations aux JO
 * 
 * @author Marjory PRIN
 */
@Entity
@Table(name = "EQUIPE")
public class Equipe {

	/** l'identifiant de l'équipe*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/** le nom de l'équipe */
	@Column(name = "NOM", length = 100, nullable = false, unique = true)
	private String nom;
	
	/** l'organisation de l'équipe */
	@ManyToOne
	@JoinColumn(name = "ORGANISATION_ID")
	private Organisation organisation;
	
	/** la liste des participations de l'équipe aux épreuves des JO */
	@OneToMany(mappedBy = "equipe")
	private Set<Participation> participations;
	
	/** Constructeur pour JPA */
	public Equipe() {
		super();
		participations = new HashSet<Participation>();
	}

	@Override
	public String toString() {
		return nom;
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
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/** Setter
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/** Getter
	 * @return the organisation
	 */
	public Organisation getOrganisation() {
		return organisation;
	}

	/** Setter
	 * @param organisation the organisation to set
	 */
	public void setOrganisation(Organisation organisation) {
		this.organisation = organisation;
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
