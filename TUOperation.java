package ProjetAtelier;

public class TUOperation {

	public static void main(String[] args) {

		Operation operationTest = new Operation(1, "Vissage", "Visseuse électrique");
		
		System.out.print("Numéro de l'opération : " + operationTest.iIdOperation+"\n"); 
		System.out.print("Nom de l'opération : " + operationTest.sNomOperation+"\n"); 
		System.out.print("Machine nécessaire pour l'opération : " + operationTest.sTypeMachine+"\n"); 
	}

}
