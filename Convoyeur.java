package ProjetAtelier;

public class Convoyeur {
	
	protected int numeroMachine;
	protected int tempsDeplacementParcelle;
	protected double prioriteStock;
	protected int numeroConvoyeur;
	protected double coefficientDeplacement;
	
	public Convoyeur(int numeroConvoyeur, double coefficientDeplacement) {
		super();
		this.numeroConvoyeur = numeroConvoyeur;
		this.coefficientDeplacement = coefficientDeplacement;
	}
	
	public void deplace()
	{
		
	}
	
	public int getNumeroMachine() {
		return numeroMachine;
	}
	public void setNumeroMachine(int numeroMachine) {
		this.numeroMachine = numeroMachine;
	}
	public double getPrioriteStock() {
		return prioriteStock;
	}
	public void setPrioriteStock(double prioriteStock) {
		this.prioriteStock = prioriteStock;
	}
	public int getTempsDeplacementParcelle() {
		return tempsDeplacementParcelle;
	}
	public void setTempsDeplacementParcelle(int tempsDeplacementParcelle) {
		this.tempsDeplacementParcelle = tempsDeplacementParcelle;
	}
	
}
