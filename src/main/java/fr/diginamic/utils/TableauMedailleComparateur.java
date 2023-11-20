package fr.diginamic.utils;

import java.util.Comparator;

import fr.diginamic.entites.TableauMedaille;

/** Permet de comparer 2 tableaux de médailles 
 * 
 * @author Marjory PRIN
 */
public class TableauMedailleComparateur implements Comparator<TableauMedaille>{
	
	@Override
	public int compare(TableauMedaille tab1, TableauMedaille tab2) {
		if (tab1.getOr()>tab2.getOr()){
			return -1;
		}
		else if (tab1.getOr()<tab2.getOr()){
			return 1;
		}
		else {
			if (tab1.getArgent()>tab2.getArgent()){
				return -1;
			}
			else if (tab1.getArgent()<tab2.getArgent()){
				return 1;
			}
			else {
				if (tab1.getBronze()>tab2.getBronze()){
					return -1;
				}
				else if (tab1.getBronze()<tab2.getBronze()){
					return 1;
				}
				else  {
					return 0;
				}
			}
		}
	}

}
