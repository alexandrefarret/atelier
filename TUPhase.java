package ProjetAtelier;

public class TUPhase {

	public static void main(String[] args) {

		Operation operationTest = new Operation(1, "Perçage", "Perceuse");
		
		Phase phaseTest1 = new Phase(1, operationTest, 23, "23/09/2018", "24/09/2018");
	
		System.out.print("Numéro de la phase : " + phaseTest1.iNumeroPhase +"\n"); 

		System.out.print("Numéro de la phase : " + phaseTest1.iNumeroPhase +"\n"); 
		System.out.print("Opération de la phase : " + phaseTest1.typeOperation.sNomOperation+"\n"); 
		System.out.print("Temps de réalisation de la phase : " + phaseTest1.iTempsRealisation +"\n"); 
		System.out.print("Date de début de la phase : " + phaseTest1.sDateDebutPhase+"\n"); 
		System.out.print("Date de fin de la phase : " + phaseTest1.sDateFinPhase+"\n"); 
	}
}
