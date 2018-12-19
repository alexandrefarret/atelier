//=============================================================================//
//                    Nom du fichier : "TUMachine.java"                          //
//                    Auteur         : Alexandre Farret                        //
//                    Date création  : 15/12/2018                              //
//                    Date MAJ       : 15/12/2018                              //
//=============================================================================//

package ProjetAtelier;

import java.util.Scanner;

public class TUMachine {
	
	public static void main(String[] args) 
	{
		int choix;
		int resultat[] = new int[10];
		Scanner sc = new Scanner(System.in);
		Operation OperationTest = new Operation(55, "Usinage", "Précision");
		Phase phaseTest = new Phase(3, OperationTest, 30, "12/08/2018", "12/12/2018");
		for (int i = 0; i < 10; i++) {resultat[i] = 0;}
		
		System.out.println("TEST UNITAIRE de la classe Machine");
		System.out.println();
		System.out.println("----> Creation de l'objet");
		System.out.println("Rentrer la limite du stock d'entrée de la machine : ");
		int limiteEntree = sc.nextInt();
		System.out.println("Rentrer la limite du stock de sortie de la machine : ");
		int limiteSortie = sc.nextInt();
		System.out.println("Rentrer la vitesse de la machine : ");
		double vitesse = sc.nextDouble();
		Machine MachineTest = new Machine(425, vitesse, OperationTest, limiteEntree, limiteSortie);
		System.out.println("Objet crée avec succès");
		System.out.println();
		
		do {
			//Menu
			System.out.println();
			System.out.println("TEST UNITAIRE de la classe Machine");
			System.out.println("1   - ajouterObjet");
			System.out.println("2   - objetTermine");
			System.out.println("3   - afficherFiles");
			System.out.println("4   - tempsDeLaPhase");
			System.out.println("5   - simulationSequence");
			System.out.println("6   - getNumeroMachine");
			System.out.println("7   - tailleStockEntree");
			System.out.println("8   - tailleStockSortie");
			System.out.println("9   - getnbPlacesEntree");
			System.out.println("10  - getnbPlacesSortie");
			System.out.println();
			System.out.println("Ordre pour éviter les erreurs: ");
			System.out.println("Choisissez un test: ");
			
			choix = sc.nextInt();
			System.out.println();
			
			switch (choix)
			{
				case 1 :
				{
					System.out.println("----> 1 - ajouterObjet");
					boolean verdict = MachineTest.ajouterObjet(phaseTest);
					if (verdict == true)
					{
						System.out.println("Méthode VALIDEE");
						resultat[0] = 1;
					}
					else
					{
						System.out.println("ERREUR : La file d'attente est pleine");
					}
					break;
				}
				case 2 :
				{
					try 
					{
						System.out.println("----> 2 - objetTermine");
						MachineTest.objetTermine();
						System.out.println("Méthode VALIDEE");
						resultat[1] = 1;
						break;
					} catch (IndexOutOfBoundsException e)
					{
						System.out.println("ERREUR : La liste est déjà vide");
						break;
					}
					
				}
				case 3 :
				{
					System.out.println("----> 3 - afficherFiles");
					MachineTest.afficherFiles();
					System.out.println("Méthode VALIDEE");
					resultat[2] = 1;
					break;
				}
				case 4 :
				{
					System.out.println("----> 4 - tempsDeLaPhase");
					double tmps = MachineTest.tempsDeLaPhase(phaseTest);
					System.out.println("Temps de la phase : " + tmps);
					System.out.println("Méthode VALIDEE");
					resultat[3] = 1;
					break;
				}
				case 5 :
				{
					System.out.println("----> 5 - simulationSequence");
					double verdict = MachineTest.simulationSequence();
					if (verdict == 0.00000000001 )
					{
						System.out.println("ERREUR : Liste Sortie pleine"); break;
					}
					if (verdict == 0.00000000002 )
					{
						System.out.println("ERREUR : Liste Entrée vide"); break;
					}
					else
					{
						System.out.println("La machine à mis " + verdict + " de temps pour réaliser l'opération");
						System.out.println("Méthode VALIDEE");
						resultat[4] = 1;
						break;
					}
				}
				case 6 :
				{
					System.out.println("----> 6 - getNumeroMachine");
					int numero = MachineTest.getNumeroMachine();
					System.out.println("Numéro de la machine : " + numero);
					System.out.println("Méthode VALIDEE");
					resultat[5] = 1;
					break;
				}
				case 7 :
				{
					System.out.println("----> 7 - tailleStockEntree");
					int taille = MachineTest.tailleStockEntree();
					System.out.println("Nombre d'objets du stock en entrée de la machine : " + taille);
					System.out.println("Méthode VALIDEE");
					resultat[6] = 1;
					break;
				}
				case 8 :
				{
					System.out.println("----> 8 - tailleStockSortie");
					int taille = MachineTest.tailleStockSortie();
					System.out.println("Nombre d'objets du stock en sortie de la machine : " + taille);
					System.out.println("Méthode VALIDEE");
					resultat[7] = 1;
					break;
				}
				case 9 :
				{
					System.out.println("----> 9 - getnbPlacesEntree");
					int taille = MachineTest.getNbPlacesEntree();
					System.out.println("Nombre maximum d'éléments dans le stock entrée de la machine : " + taille);
					System.out.println("Méthode VALIDEE");
					resultat[8] = 1;
					break;
				}
				case 10 :
				{
					System.out.println("----> 10 - getnbPlacesEntree");
					int taille = MachineTest.getNbPlacesEntree();
					System.out.println("Nombre maximum d'éléments dans le stock sortie de la machine : " + taille);
					System.out.println("Méthode VALIDEE");
					resultat[9] = 1;
					break;
				}
				default : System.out.println("Merci de saisir un nombre entre 1 et 10"); 
			}
			
		} while ( resultat[0] == 0 | resultat[1] == 0 | resultat[2] == 0 | resultat[3] == 0 | resultat[4] == 0 | resultat[5] == 0 | resultat[6] == 0 | resultat[7] == 0 | resultat[8] == 0 | resultat[9] == 0 );
		System.out.println();
		System.out.println("Fin du test, toutes les méthodes sont valides");
		System.out.println("------> TEST UNITAIRE VALIDE");
		
	}
}
