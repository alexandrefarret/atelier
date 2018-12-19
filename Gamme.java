package ProjetAtelier;

import java.util.ArrayList;
import java.util.List;

public class Gamme {

	// Attributes
	protected int iNumProduit;
	protected String sNomProduit;
	protected List<Phase> lesPhases;
	
	public Gamme()
	{
		this.lesPhases = new ArrayList<Phase>();
	}
	
	/**
	 * Constructor
	 * @param iNumProduit Product number
	 * @param sNomProduit Product name
	 */
	public Gamme(int iNumProduit, String sNomProduit) {
		this.iNumProduit = iNumProduit;
		this.sNomProduit = sNomProduit;
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
			System.out.println(laPhase.iNumeroPhase + " - " + laPhase.typeOperation.sNomOperation + " qui dure : " + laPhase.iTempsRealisation);
		}
	}

	// Getters/Setter
	public int getNumProduit() {
		return iNumProduit;
	}

	public void setNumProduit(int iNumProduit) {
		this.iNumProduit = iNumProduit;
	}

	public String getNomProduit() {
		return sNomProduit;
	}

	public void setNomProduit(String sNomProduit) {
		this.sNomProduit = sNomProduit;
	}

	public List<Phase> getLesPhases() {
		return lesPhases;
	}

	public void setLesPhases(List<Phase> lesPhases) {
		this.lesPhases = lesPhases;
	}
}
