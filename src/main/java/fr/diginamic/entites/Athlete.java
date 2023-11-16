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
 * Représente un athlète participant aux JO avec son identifiant en base de donnée, son identifiant JO, son nom, son sexe et la liste de ses participations aux JO
 * 
 * @author Marjory PRIN
 */
@Entity
@Table(name = "ATHLETE")
public class Athlete {

	/** l'identifiant de l'athlète pour la base de donnée */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/** l'identifiant de l'athlète dans le fichier CSV des JO */
	@Column(name ="ID_JO", length = 10, nullable = false, unique = true)
	private int idJO;
	
	/** le nom complet de l'athlète */
	@Column(name = "NOM", length = 150, nullable = false)
	private String nom;
	
	/** le sexe de l'athlète (H ou F) */
	@Column(name = "SEXE", length = 1, nullable = false)
	private String sexe;
	
	/** la liste des participations de l'athlète aux épreuves des JO */
	@OneToMany(mappedBy = "athlete")
	private Set<Participation> participations;
	
	/** Constructeur pour JPA */
	public Athlete() {
		super();
		participations = new HashSet<Participation>();
	}

	@Override
	public String toString() {
		return nom + " (" + sexe + ")";
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
	 * @return the idJO
	 */
	public int getIdJO() {
		return idJO;
	}

	/** Setter
	 * @param idJO the idJO to set
	 */
	public void setIdJO(int idJO) {
		this.idJO = idJO;
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
	 * @return the sexe
	 */
	public String getSexe() {
		return sexe;
	}

	/** Setter
	 * @param sexe the sexe to set
	 */
	public void setSexe(String sexe) {
		this.sexe = sexe;
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
