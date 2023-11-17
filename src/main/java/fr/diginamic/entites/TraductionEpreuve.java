package fr.diginamic.entites;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Représente une traduction d'une épreuve des JO avec son identifiant, son nom anglais,son nom français et la liste des épreuves associées
 * 
 * @author Marjory PRIN
 */
@Entity
@Table(name = "TRADUCTION_EPREUVE")
public class TraductionEpreuve {

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
	
	/** la liste des épreuves associées */
	@OneToMany(mappedBy = "traduction")
	private Set<Epreuve> epreuves;
	
	/** Constructeur pour JPA */
	public TraductionEpreuve() {
		super();
		epreuves = new HashSet<Epreuve>();
	}

	@Override
	public String toString() {
		if (nomFR != null) {
			return nomFR;
		}
		return nomEN;
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
	 * @return the epreuves
	 */
	public Set<Epreuve> getEpreuves() {
		return epreuves;
	}

	/** Setter
	 * @param epreuves the epreuves to set
	 */
	public void setEpreuves(Set<Epreuve> epreuves) {
		this.epreuves = epreuves;
	}
}
