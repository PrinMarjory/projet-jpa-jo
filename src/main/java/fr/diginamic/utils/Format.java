package fr.diginamic.utils;

/**
 * Permet de formater un nombre
 * 
 * @author Marjory PRIN
 */
public class Format {
	
	/**
	 * Pour arrondir un nombre décimal à une précision donnée
	 * @param nombre : le nombre à arrondir
	 * @param precision : le nombre de chiffre après la virgule
	 * @return le nombre arrondi
	 */
	public static double roundDouble (double nombre, int precision) {
		int facteur = 10;
		for (int i = 1; i < precision; i++) {
			facteur *= 10;
		}
		double result = Math.round(nombre*facteur);
		result /= facteur;
		return result;
	}
	
}
