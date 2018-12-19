package ProjetAtelier;

public class Ilot {

	protected int iNumeroIlot;
	protected String sTypeIlot;
	protected static Machine[] lesMachines;
	protected int iParcelle;
	protected int iNombreObjetTotal;
	
	/**
	 * Manage the priority that is assigned to an object for each machine
	 * @param iNombreObjetTotal Object total
	 * @return Priority per object
	 */
	public double prioriteParObjet(int iNombreObjetTotal){
		double dPrioriteParObjet = 100/iNombreObjetTotal; 
		return dPrioriteParObjet;
	}
	
	/**
	 * Manage the priority assigned to the machine
	 * @param iNombreObjetFile Waiting object number
	 * @param dPrioriteParObjet Priority per object
	 * @return Priority
	 */
	public double prioriteMachine(int iNombreObjetFile, double dPrioriteParObjet)
	{
		double dPriorite = iNombreObjetFile*dPrioriteParObjet;
		return dPriorite;
	}
	
	/**
	 * Display all the machines 
	 */
	public static void afficherLesMachines(){
		for(Machine laMachine : lesMachines)
		{
			System.out.println(laMachine.iNumeroMachine + " - " + laMachine.Operation);
		}
	}
	
	/**
	 * Constructor
	 * @param iNumeroIlot Island number
	 * @param sTypeIlot Island type
	 * @param Location
	 */
	public Ilot(int iNumeroIlot, String sTypeIlot, int iParcelle) {
		super();
		this.iNumeroIlot = iNumeroIlot;
		this.sTypeIlot = sTypeIlot;
		this.iParcelle = iParcelle;
	}

	//Getters/Settters
	public int getNombreObjetTotal() {
		return iNombreObjetTotal;
	}

	public void setNombreObjetTotal(int iNombreObjetTotal) {
		this.iNombreObjetTotal = iNombreObjetTotal;
	}

	public String getTypeIlot() {
		return sTypeIlot;
	}

	public void setTypeIlot(String sTypeIlot) {
		this.sTypeIlot = sTypeIlot;
	}

	public Machine[] getLesMachines() {
		return lesMachines;
	}

	public void setLesMachines(Machine[] lesMachines) {
		this.lesMachines = lesMachines;
	}

	public int getParcelle() {
		return iParcelle;
	}

	public void setParcelle(int iParcelle) {
		this.iParcelle = iParcelle;
	}

	public int getNumeroIlot() {
		return iNumeroIlot;
	}

	public void setNumeroIlot(int iNumeroIlot) {
		this.iNumeroIlot = iNumeroIlot;
	}
	
	
}
