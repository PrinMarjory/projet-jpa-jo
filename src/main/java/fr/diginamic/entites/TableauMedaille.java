package fr.diginamic.entites;

/**
 * Représente un tableau de médaille des JO avec le nombre de médaille or, argent et bronze ainsi que le code CIO et le nom de l'organisation associée 
 * 
 * @author Marjory PRIN
 */
public class TableauMedaille {
	
	/** le code CIO de l'organisation */
	private String codeCIO;
	
	/** le nom de l'organisation */
	private String nomOrganisation;
	
	/** le nombre de médaille or */
	private int or;
	
	/** le nombre de médaille argent */
	private int argent;
	
	/** le nombre de médaille bronze */
	private int bronze;

	/** Constructeur
	 * @param id
	 * @param nomOrganisation
	 * @param or
	 * @param argent
	 * @param bronze
	 */
	public TableauMedaille(String codeCIO, String nomOrganisation, int or, int argent, int bronze) {
		super();
		this.codeCIO = codeCIO;
		this.nomOrganisation = nomOrganisation;
		this.or = or;
		this.argent = argent;
		this.bronze = bronze;
	}

	@Override
	public String toString() {
		return codeCIO + "\t" + or + "\t" + argent + "\t" + bronze + "\t" + nomOrganisation;
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
	 * @return the nomOrganisation
	 */
	public String getNomOrganisation() {
		return nomOrganisation;
	}

	/** Setter
	 * @param nomOrganisation the nomOrganisation to set
	 */
	public void setNomOrganisation(String nomOrganisation) {
		this.nomOrganisation = nomOrganisation;
	}

	/** Getter
	 * @return the or
	 */
	public int getOr() {
		return or;
	}

	/** Setter
	 * @param or the or to set
	 */
	public void setOr(int or) {
		this.or = or;
	}

	/** Getter
	 * @return the argent
	 */
	public int getArgent() {
		return argent;
	}

	/** Setter
	 * @param argent the argent to set
	 */
	public void setArgent(int argent) {
		this.argent = argent;
	}

	/** Getter
	 * @return the bronze
	 */
	public int getBronze() {
		return bronze;
	}

	/** Setter
	 * @param bronze the bronze to set
	 */
	public void setBronze(int bronze) {
		this.bronze = bronze;
	}
	
	
}
