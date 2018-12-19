package ProjetAtelier;

public class Operation {

	//Attributes
	protected int iIdOperation; 
	protected String sNomOperation;
	protected String sTypeMachine;
	
	public Operation() {
		//TO DO
	}
	
	/**
	 * Constructor
	 * @param iIdOperation id of the operation
	 * @param sNomOperation name of the operation
	 * @param sTypeMachine type of the machine
	 */
	public Operation(int iIdOperation, String sNomOperation, String sTypeMachine) {
		super();
		this.iIdOperation = iIdOperation;
		this.sNomOperation = sNomOperation;
		this.sTypeMachine = sTypeMachine;
	}
	
	
	// Getters/Setters
	public int getIdOperation() {
		return iIdOperation;
	}
	public void setIdOperation(int iIdOperation) {
		this.iIdOperation = iIdOperation;
	}
	public String getNomOperation() {
		return sNomOperation;
	}
	public void setNomOperation(String sNomOperation) {
		this.sNomOperation = sNomOperation;
	}
	public String getTypeMachine() {
		return sTypeMachine;
	}
	public void setTypeMachine(String sTypeMachine) {
		this.sTypeMachine = sTypeMachine;
	}
}
