//=============================================================================//
//                    Nom du fichier : "Stock.java"                            //
//                    Auteur         : Alexandre Farret                        //
//                    Date création  : 12/12/2018                              //
//                    Date MAJ       : 15/12/2018                              //
//=============================================================================//

package ProjetAtelier;

import java.util.LinkedList;
import java.util.List;

public class Stock 
{
//******* Attributs *******//
	protected int taille;
	protected List<Phase> listeElement;
	protected int nbPlaces;
	
//******* Méthodes *******//
	/**
	 * Constructeur	
	 * @param places Nombre de places de la file
	 */
	public Stock(int places)
	{
		listeElement = new LinkedList<Phase>(); //Instanciation
		nbPlaces = places;
		taille = 0;
	}

	//Ajout d'une phase (correspondant à un objet précis) dans la liste	
	public boolean ajouterElement(Phase nouvelObjet)
	{
		if ( this.tailleStock() >= nbPlaces )
		{
			return false;
		}
		else
		{
			listeElement.add(nouvelObjet);
			taille = listeElement.size();
			return true;
		}

	}
	
	//Supprime le dernier élément de la file (méthode FIFO)
	public void enleverElement()
	{
		listeElement.remove(0);
		taille = listeElement.size();
	}
	
	//Retourne le nombre d'élément dans la file
	public int tailleStock() { return taille; }
	
	//Affiche la file
	public void afficherStock()
	{
		for(int i = 0; i < listeElement.size(); i++)
		{
		  System.out.println("Position : " + i + " " + listeElement.get(i));
		}
	}
	
	//Retourne le prochain objet qui va subir une opération
	public Phase prochainElement()
	{
			return listeElement.get(0);
	}
}
