package ProjetAtelier;

import java.util.LinkedList;
import java.util.List;

public class Stock 
{
//******* Attributs *******//
	protected int iTaille;
	protected List<Phase> listeElement;
	protected int iNbPlaces;
	
//******* Méthodes *******//
	
	public Stock()
	{
		//TODO
	}
	/**
	 * Constructor	
	 * @param iPlaces Number of seats in the queue
	 */
	public Stock(int iPlaces)
	{
		listeElement = new LinkedList<Phase>(); //Instanciation
		iNbPlaces = iPlaces;
		iTaille = 0;
	}

	//Adding a phase (corresponding to a specific object) in the list	
	public boolean ajouterElement(Phase nouvelObjet)
	{
		if ( this.tailleStock() >= iNbPlaces )
		{
			return false;
		}
		listeElement.add(nouvelObjet);
		iTaille = listeElement.size();
		return true;
	}
	
	//Deletes the last item in the waiting line (FIFO method)
	public void enleverElement()
	{
		listeElement.remove(0);
		iTaille = listeElement.size();
	}
	
	//Returns the number of items in the waiting line
	public int tailleStock() { return iTaille; }
	
	//Poster the waiting line
	public void afficherStock()
	{
		for(int i = 0; i < listeElement.size(); i++)
		{
		  System.out.println("Position : " + i + " " + listeElement.get(i));
		}
	}

//******* Getter and Setter *******//
	public Phase prochainElement()
	{
		return listeElement.get(0);
	}
	public int getTaille() {
		return iTaille;
	}
	public void setTaille(int iTaille) {
		this.iTaille = iTaille;
	}
	public List<Phase> getListeElement() {
		return listeElement;
	}
	public void setListeElement(List<Phase> listeElement) {
		this.listeElement = listeElement;
	}
	public int getNbPlaces() {
		return iNbPlaces;
	}
	public void setNbPlaces(int iNbPlaces) {
		this.iNbPlaces = iNbPlaces;
	}
}
