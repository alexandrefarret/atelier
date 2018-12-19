package ProjetAtelier;

public class Ilot {

	protected int numeroIlot;
	protected String typeIlot;
	protected static Machine[] lesMachines;
	protected int parcelle;
	protected int nombreObjetTotal;
	
	/**
	 * Manage the priority that is assigned to an object for each machine
	 * @param nombreObjetTotal Object total
	 * @return Priority per object
	 */
	public double prioriteParObjet(int nombreObjetTotal){
		double prioriteParObjet = 100/nombreObjetTotal; 
		return prioriteParObjet;
	}
	
	/**
	 * Manage the priority assigned to the machine
	 * @param nombreObjetFile Waiting object number
	 * @param prioriteParObjet Priority per object
	 * @return Priority
	 */
	public double prioriteMachine(int nombreObjetFile, double prioriteParObjet)
	{
		double priorite = nombreObjetFile*prioriteParObjet;
		return priorite;
	}
	
	/**
	 * Display all the machines 
	 */
	public static void afficherLesMachines(){
		for(Machine laMachine : lesMachines)
		{
			System.out.println(laMachine.numeroMachine + " - " + laMachine.Operation);
		}
	}
	
	/**
	 * Constructor
	 * @param numeroIlot Island number
	 * @param typeIlot Island type
	 * @param Location
	 */
	public Ilot(int numeroIlot, String typeIlot, int parcelle) {
		super();
		this.numeroIlot = numeroIlot;
		this.typeIlot = typeIlot;
		this.parcelle = parcelle;
	}

	//Getters/Settters
	public int getNombreObjetTotal() {
		return nombreObjetTotal;
	}

	public void setNombreObjetTotal(int nombreObjetTotal) {
		this.nombreObjetTotal = nombreObjetTotal;
	}

	public String getTypeIlot() {
		return typeIlot;
	}

	public void setTypeIlot(String typeIlot) {
		this.typeIlot = typeIlot;
	}

	public Machine[] getLesMachines() {
		return lesMachines;
	}

	public void setLesMachines(Machine[] lesMachines) {
		this.lesMachines = lesMachines;
	}

	public int getParcelle() {
		return parcelle;
	}

	public void setParcelle(int parcelle) {
		this.parcelle = parcelle;
	}

	public int getNumeroIlot() {
		return numeroIlot;
	}

	public void setNumeroIlot(int numeroIlot) {
		this.numeroIlot = numeroIlot;
	}
	
	
}
