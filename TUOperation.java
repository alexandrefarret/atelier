package ProjetAtelier;

public class TUOperation {

	public static void main(String[] args) {

		Operation operationTest = new Operation(1, "Vissage", "Visseuse �lectrique");
		
		System.out.print("Num�ro de l'op�ration : " + operationTest.iIdOperation+"\n"); 
		System.out.print("Nom de l'op�ration : " + operationTest.sNomOperation+"\n"); 
		System.out.print("Machine n�cessaire pour l'op�ration : " + operationTest.sTypeMachine+"\n"); 
	}

}
