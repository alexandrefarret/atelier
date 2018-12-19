package ProjetAtelier;

public class Operation {

	//Attributes
	protected int idOperation; 
	protected String nomOperation;
	protected String typeMachine;
	
	public Operation() {
		//TO DO
	}
	
	/**
	 * Constructor
	 * @param idOperation id of the operation
	 * @param nomOperation name of the operation
	 * @param typeMachine type of the machine
	 */
	public Operation(int idOperation, String nomOperation, String typeMachine) {
		super();
		this.idOperation = idOperation;
		this.nomOperation = nomOperation;
		this.typeMachine = typeMachine;
	}
	
	
	// Getters/Setters
	public int getIdOperation() {
		return idOperation;
	}
	public void setIdOperation(int idOperation) {
		this.idOperation = idOperation;
	}
	public String getNomOperation() {
		return nomOperation;
	}
	public void setNomOperation(String nomOperation) {
		this.nomOperation = nomOperation;
	}
	public String getTypeMachine() {
		return typeMachine;
	}
	public void setTypeMachine(String typeMachine) {
		this.typeMachine = typeMachine;
	}
}
