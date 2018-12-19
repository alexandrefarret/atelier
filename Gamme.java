package ProjetAtelier;

import java.util.ArrayList;
import java.util.List;

public class Gamme {

	// Attributes
	protected int numProduit;
	protected String nomProduit;
	protected List<Phase> lesPhases;
	
	/**
	 * Constructor
	 * @param numProduit Product number
	 * @param nomProduit Product name
	 */
	public Gamme(int numProduit, String nomProduit) {
		super();
		this.numProduit = numProduit;
		this.nomProduit = nomProduit;
		this.lesPhases = new ArrayList<Phase>();
	}
	
	/**
	 * Shows the phases
	 */
	public void affichePhases()
	{
		System.out.println("Voici les différentes phases de la gamme : ");
		for(Phase laPhase : lesPhases)
		{
			System.out.println(laPhase.numeroPhase + " - " + laPhase.typeOperation.nomOperation + " qui dure : " + laPhase.tempsRealisation);
		}
	}

	// Getters/Setter
	public int getNumProduit() {
		return numProduit;
	}

	public void setNumProduit(int numProduit) {
		this.numProduit = numProduit;
	}

	public String getNomProduit() {
		return nomProduit;
	}

	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}

	public List<Phase> getLesPhases() {
		return lesPhases;
	}

	public void setLesPhases(List<Phase> lesPhases) {
		this.lesPhases = lesPhases;
	}
}
