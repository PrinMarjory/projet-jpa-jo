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
 * Représente un sport aux JO avec son identifiant, son nom en anglais, son nom en français et la liste des épreuves de ce sport
 * 
 * @author Marjory PRIN
 */
@Entity
@Table(name = "SPORT")
public class Sport {

	/** l'identifiant de l'athlète */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/** le nom en anglais du sport*/
	@Column(name = "NOM_EN", length = 50, nullable = false, unique = true)
	private String nomEN;
	
	/** le nom en français du sport*/
	@Column(name = "NOM_FR", length = 50, nullable = true, unique = true)
	private String nomFR;
	
	/** la liste des épreuves de ce sport */
	@OneToMany(mappedBy = "sport")
	private Set<Epreuve> epreuves;
	
	/** Constructeur pour JPA */
	public Sport() {
		super();
		epreuves = new HashSet<Epreuve>();
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
