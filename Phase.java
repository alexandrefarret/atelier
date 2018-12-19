package ProjetAtelier;

import ProjetAtelier.Operation;

public class Phase {

	// Attributes 
	protected int numeroPhase;
	protected Operation typeOperation;
	protected int tempsRealisation;
	protected String dateDebutPhase;
	protected String dateFinPhase;
	
	public Phase()
	{
		//TO DO
	}
	
	/**
	 * Constructor	
	 * @param numeroPhase Phase number
	 * @param typeOperation operation type
	 * @param tempsRealisation completion time
	 * @param dateDebutPhase start date of the phase
	 * @param dateFinPhase end date of the phase	
	 */
	public Phase(int numeroPhase, Operation typeOperation, int tempsRealisation, String dateDebutPhase,
			String dateFinPhase) {
		super();
		this.numeroPhase = numeroPhase;
		this.typeOperation = typeOperation;
		this.tempsRealisation = tempsRealisation;
		this.dateDebutPhase = dateDebutPhase;
		this.dateFinPhase = dateFinPhase;
	}
	
	public boolean contains(int unId)
	{
		if(this.numeroPhase == unId)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	// Getters/Setters
	public int getNumeroPhase() {
		return numeroPhase;
	}
	public void setNumeroPhase(int numeroPhase) {
		this.numeroPhase = numeroPhase;
	}
	public Operation getTypeOperation() {
		return typeOperation;
	}
	public void setTypeOperation(Operation typeOperation) {
		this.typeOperation = typeOperation;
	}
	public int getTempsRealisation() {
		return tempsRealisation;
	}
	public void setTempsRealisation(int tempsRealisation) {
		this.tempsRealisation = tempsRealisation;
	}
	public String getDateDebutPhase() {
		return dateDebutPhase;
	}
	public void setDateDebutPhase(String dateDebutPhase) {
		this.dateDebutPhase = dateDebutPhase;
	}
	public String getDateFinPhase() {
		return dateFinPhase;
	}
	public void setDateFinPhase(String dateFinPhase) {
		this.dateFinPhase = dateFinPhase;
	}
}
