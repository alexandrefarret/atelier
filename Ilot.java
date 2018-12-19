package ProjetAtelier;

public class Ilot {

	protected int numeroIlot;
	protected String typeIlot;
//	protected Machine[] lesMachines;
	protected int parcelle;
	protected int nombreObjetFile;
	
	// Manage the priority that is assigned to an object for each machine
	public double gestionPriorite(int nombreObjetFile){
		double prioriteParObjet = 100/nombreObjetFile; 
		return prioriteParObjet;
	}
	
	public static void afficherLesMachines(){
		
	}
	
	public Ilot(int numeroIlot, String typeIlot) {
		super();
		// TODO Auto-generated constructor stub
		this.numeroIlot = numeroIlot;
		this.typeIlot = typeIlot;
	}
	
	public int getNombreObjetFile() {
		return nombreObjetFile;
	}

	public void setNombreObjetFile(int nombreObjetFile) {
		this.nombreObjetFile = nombreObjetFile;
	}

	public String getTypeIlot() {
		return typeIlot;
	}

	public void setTypeIlot(String typeIlot) {
		this.typeIlot = typeIlot;
	}

/*	public Machine[] getLesMachines() {
		return lesMachines;
	}

	public void setLesMachines(Machine[] lesMachines) {
		this.lesMachines = lesMachines;
	}*/

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
