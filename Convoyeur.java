package ProjetAtelier;

public class Convoyeur {
	
	protected int iNumeroMachine;
	protected int iTempsDeplacementParcelle;
	protected double dPrioriteStock;
	protected int iNumeroConvoyeur;
	protected double dCoefficientDeplacement;
	
	/**
	 * Constructor
	 * @param iNumeroConvoyeur The number of the conveyor
	 * @param dCoefficientDeplacement Moving coeff
	 */
	public Convoyeur(int iNumeroConvoyeur, double dCoefficientDeplacement) {
		super();
		this.iNumeroConvoyeur = iNumeroConvoyeur;
		this.dCoefficientDeplacement = dCoefficientDeplacement;
	}
	
	public int getNumeroMachine() {
		return iNumeroMachine;
	}
	public void setNumeroMachine(int iNumeroMachine) {
		this.iNumeroMachine = iNumeroMachine;
	}
	public double getPrioriteStock() {
		return dPrioriteStock;
	}
	public void setPrioriteStock(double dPrioriteStock) {
		this.dPrioriteStock = dPrioriteStock;
	}
	public int getTempsDeplacementParcelle() {
		return iTempsDeplacementParcelle;
	}
	public void setTempsDeplacementParcelle(int iTempsDeplacementParcelle) {
		this.iTempsDeplacementParcelle = iTempsDeplacementParcelle;
	}
	
}
