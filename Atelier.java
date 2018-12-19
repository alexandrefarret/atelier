package ProjetAtelier;

public class Atelier {
	protected String atelier;
	protected Ilot[] lesIlots;
	protected int[][] tempsTransfertParcelle;
	protected int nombreParcelles;
	
	/**
	 * Exchange island places 
	 * @param unIlot The island 
	 * @param uneParcelle A parcel
	 */
	public void deplacerIlot(Ilot unIlot, int uneParcelle){
		boolean testExiste = false;
		Ilot ilotTemp = new Ilot(0, null);
		// Foreach island, check if parcel is use
		// Parcel use = switch the parcels
		// Not used parcel = the island got the parcel
		for(Ilot ilotVerif : lesIlots)
		{
			if(ilotVerif.getParcelle() == uneParcelle)
			{
				testExiste = true;
				ilotVerif.setParcelle(unIlot.parcelle);
				unIlot.setParcelle(uneParcelle);
			}
		}
		if(!testExiste)
		{
			unIlot.parcelle = uneParcelle;
		}
	}
	
	
	/**
	 * Create time between parcels
	 * @param nombreParcelles Parcel number
	 */
	public void creationTempsParcelle(int nombreParcelles){
		int n;
		//Creation of the number of parcels
		tempsTransfertParcelle = new int[nombreParcelles][nombreParcelles];
		//Browse the first dimension of the board
		for(int i=0; i<nombreParcelles; i++)
		{
			n = nombreParcelles-1;
			//Generates a random number between 0 and 20
			int aleatoire = (int)(Math.random() * 20);
			//Browse the second dimension of the board
			while(n != 0)
			{
				tempsTransfertParcelle[i][n] = aleatoire;
				tempsTransfertParcelle[n][i] = aleatoire;
				aleatoire = (int)(Math.random() * 20);
				n = --n;				
			}
		//Puts 0 the time of the parcels to itself
		tempsTransfertParcelle[i][i] = 0;
		}
	}
	
	/**
	 * Constructor
	 * @param atelier The name of atelier
	 */
	public Atelier(String atelier) {
		super();
		// TODO Auto-generated constructor stub
		this.atelier = atelier;
	}
	
	/**
	 * Dispaly for tempsTransfertParcelle
	 * @param i An integer
	 * @param o An integer
	 */
	public void afficher(int i, int n)
	{
		System.out.println(tempsTransfertParcelle[i][n]);
	}
	
	// Getters/Setters
	public String getAtelier() {
		return atelier;
	}

	public void setAtelier(String atelier) {
		this.atelier = atelier;
	}

	public Ilot[] getLesIlots() {
		return lesIlots;
	}

	public void setLesIlots(Ilot[] lesIlots) {
		this.lesIlots = lesIlots;
	}

	public int[][] getTempsTransfertParcelle() {
		return tempsTransfertParcelle;
	}

	public void setTempsTransfertParcelle(int[][] tempsTransfertParcelle) {
		this.tempsTransfertParcelle = tempsTransfertParcelle;
	}
	
}
