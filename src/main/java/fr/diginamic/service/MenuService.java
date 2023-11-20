package fr.diginamic.service;
import java.util.Scanner;

/**
 * Représente une recherche du menu de service et l'affichage de son résultat
 * 
 * @author Marjory PRIN
 */
public abstract class MenuService {
	
	/**
	 * Traite la demande de recherche et affiche le résultat
	 * @param scanner : la demande de l'utilisateur
	 */
	public abstract void traiter(Scanner scanner);
}
