package ProjetAtelier;

import ProjetAtelier.Operation;

public class Phase {

	// Attributes 
	protected int iNumeroPhase;
	protected Operation typeOperation;
	protected int iTempsRealisation;
	protected String sDateDebutPhase;
	protected String sDateFinPhase;
	
	public Phase()
	{
		//TO DO
	}
	
	/**
	 * Constructor	
	 * @param iNumeroPhase Phase number
	 * @param typeOperation operation type
	 * @param iTempsRealisation completion time
	 * @param sDateDebutPhase start date of the phase
	 * @param sDateFinPhase end date of the phase	
	 */
	public Phase(int iNumeroPhase, Operation typeOperation, int iTempsRealisation, String sDateDebutPhase,
			String sDateFinPhase) {
		super();
		this.iNumeroPhase = iNumeroPhase;
		this.typeOperation = typeOperation;
		this.iTempsRealisation = iTempsRealisation;
		this.sDateDebutPhase = sDateDebutPhase;
		this.sDateFinPhase = sDateFinPhase;
	}
	
	public boolean contains(int iUnId)
	{
		if(this.iNumeroPhase == iUnId)
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
		return iNumeroPhase;
	}
	public void setNumeroPhase(int numeroPhase) {
		this.iNumeroPhase = numeroPhase;
	}
	public Operation getTypeOperation() {
		return typeOperation;
	}
	public void setTypeOperation(Operation typeOperation) {
		this.typeOperation = typeOperation;
	}
	public int getTempsRealisation() {
		return iTempsRealisation;
	}
	public void setTempsRealisation(int iTempsRealisation) {
		this.iTempsRealisation = iTempsRealisation;
	}
	public String getDateDebutPhase() {
		return sDateDebutPhase;
	}
	public void setDateDebutPhase(String sDateDebutPhase) {
		this.sDateDebutPhase = sDateDebutPhase;
	}
	public String getDateFinPhase() {
		return sDateFinPhase;
	}
	public void setDateFinPhase(String sDateFinPhase) {
		this.sDateFinPhase = sDateFinPhase;
	}
}
