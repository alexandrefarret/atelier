package ProjetAtelier;

import java.util.ArrayList;
import java.util.List;

public class Atelier {
	protected String sAtelier;
	protected List<Ilot> lesIlots;
	protected int[][] iTTempsTransfertParcelle;
	protected int iNombreParcelles;
	
	/**
	 * Exchange island places 
	 * @param unIlot The island 
	 * @param iUneParcelle A parcel
	 */
	public void deplacerIlot(Ilot unIlot, int iUneParcelle){
		boolean bTestExiste = false;
		Ilot ilotTemp = new Ilot(0, null,0);
		// Foreach island, check if parcel is use
		// Parcel use = switch the parcels
		// Not used parcel = the island got the parcel
		for(Ilot ilotVerif : lesIlots)
		{
			if(ilotVerif.getParcelle() == iUneParcelle)
			{
				bTestExiste = true;
				ilotVerif.setParcelle(unIlot.iParcelle);
				unIlot.setParcelle(iUneParcelle);
			}
		}
		if(!bTestExiste)
		{
			unIlot.iParcelle = iUneParcelle;
		}
	}
	
	
	/**
	 * Create time between parcels
	 * @param iNombreParcelles Parcel number
	 */
	public void creationTempsParcelle(){
		int n;
		//Creation of the number of parcels
		iTTempsTransfertParcelle = new int[iNombreParcelles][iNombreParcelles];
		//Browse the first dimension of the board
		for(int i=0; i<iNombreParcelles; i++)
		{
			n = iNombreParcelles-1;
			//Generates a random number between 0 and 20
			int aleatoire = (int)(Math.random() * 20);
			//Browse the second dimension of the board
			while(n != 0)
			{
				iTTempsTransfertParcelle[i][n] = aleatoire;
				iTTempsTransfertParcelle[n][i] = aleatoire;
				aleatoire = (int)(Math.random() * 20);
				n = --n;				
			}
		//Puts 0 the time of the parcels to itself
		iTTempsTransfertParcelle[i][i] = 0;
		}
	}
	
	/**
	 * Constructor
	 * @param sAtelier The name of atelier
	 * @param iNombreParcelles Quantity of parcel
	 */
	public Atelier(String sAtelier, int iNombreParcelles) {
		this.sAtelier = sAtelier;
		this.lesIlots = new ArrayList<Ilot>();
		this.iNombreParcelles = iNombreParcelles;
		creationTempsParcelle();
	}
	
	/**
	 * Dispaly for tempsTransfertParcelle
	 * @param i An integer
	 * @param o An integer
	 */
	public void afficher()
	{
		for(int i =0;i<iNombreParcelles;i++)
		{
			for(int n = 0;n<iNombreParcelles;n++)
			{
				System.out.print(" | " + iTTempsTransfertParcelle[i][n]+ " | ");
			}
			System.out.println();
		}
	}
	
	// Getters/Setters
	public String getAtelier() {
		return sAtelier;
	}

	public void setAtelier(String sAtelier) {
		this.sAtelier = sAtelier;
	}

	public int[][] getTempsTransfertParcelle() {
		return iTTempsTransfertParcelle;
	}

	public void setTempsTransfertParcelle(int[][] iTTempsTransfertParcelle) {
		this.iTTempsTransfertParcelle = iTTempsTransfertParcelle;
	}


	public List<Ilot> getLesIlots() {
		return lesIlots;
	}


	public void setLesIlots(List<Ilot> lesIlots) {
		this.lesIlots = lesIlots;
	}
	
}
