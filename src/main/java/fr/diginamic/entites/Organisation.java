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
 * Représente une organisation des JO avec son identifiant, son code CIO, son code ISO, son nom en anglais, son nom en français,
 * si elle est obsolète et la liste de ses équipes
 * 
 * @author Marjory PRIN
 */
@Entity
@Table(name = "ORGANISATION")
public class Organisation {

	/** l'identifiant de l'organisation */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/** le code CIO */
	@Column(name = "CODE_CIO", length = 3, nullable = false, unique = true)
	private String codeCIO;
	
	/** le code ISO */
	@Column(name = "CODE_ISO", length = 3, nullable = true)
	private String codeISO;
	
	/** le nom anglais de l'organisation */
	@Column(name = "NOM_EN", length = 100, nullable = false)
	private String nomEN;
	
	/** le nom français de l'organisation */
	@Column(name = "NOM_FR", length = 100, nullable = true)
	private String nomFR;
	
	/** le statut obsolète ou non de l'organisation (O : obsolète, N : non obsolète) */
	@Column(name = "OBSOLETE", nullable = false)
	private String obsolete;
	
	/** la liste des équipes de l'organisation */
	@OneToMany(mappedBy = "organisation")
	private Set<Equipe> equipes;
	
	/** Constructeur pour JPA */
	public Organisation() {
		super();
		equipes = new HashSet<Equipe>();
	}

	@Override
	public String toString() {
		return codeCIO;
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
	 * @return the codeCIO
	 */
	public String getCodeCIO() {
		return codeCIO;
	}

	/** Setter
	 * @param codeCIO the codeCIO to set
	 */
	public void setCodeCIO(String codeCIO) {
		this.codeCIO = codeCIO;
	}

	/** Getter
	 * @return the codeISO
	 */
	public String getCodeISO() {
		return codeISO;
	}

	/** Setter
	 * @param codeISO the codeISO to set
	 */
	public void setCodeISO(String codeISO) {
		this.codeISO = codeISO;
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
	 * @return the obsolete
	 */
	public String isObsolete() {
		return obsolete;
	}

	/** Setter
	 * @param obsolete the obsolete to set
	 */
	public void setObsolete(String obsolete) {
		this.obsolete = obsolete;
	}

	/** Getter
	 * @return the equipes
	 */
	public Set<Equipe> getEquipes() {
		return equipes;
	}

	/** Setter
	 * @param equipes the equipes to set
	 */
	public void setEquipes(Set<Equipe> equipes) {
		this.equipes = equipes;
	}
	
}
