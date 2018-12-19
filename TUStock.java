//=============================================================================//
//                    Nom du fichier : "TUStock.java"                          //
//                    Auteur         : Alexandre Farret                        //
//                    Date création  : 12/12/2018                              //
//                    Date MAJ       : 15/12/2018                              //
//=============================================================================//

package ProjetAtelier;

import java.util.Scanner;

public class TUStock {

	public static void main(String[] args) 
	{
		int choix;
		int resultat[] = new int[5];
		for (int i = 0; i < 5; i++) {resultat[i] = 0;}
		Scanner sc = new Scanner(System.in);
		Operation OperationTest = new Operation(55, "Usinage", "Précision");
		Phase phaseTest = new Phase(3, OperationTest, 30, "12/08/2018", "12/12/2018");
		
		System.out.println("TEST UNITAIRE de la classe Stock");
		System.out.println();
		System.out.println("----> Creation de l'objet");
		System.out.println("Rentrer la limite du stock : ");
		int limite = sc.nextInt();
		Stock StockTest = new Stock(limite);  
		System.out.println("Objet crée avec succès");
		System.out.println();
		
		do {
			//Menu
			System.out.println();
			System.out.println("TEST UNITAIRE de la classe Stock");
			System.out.println("1 - ajouterElement");
			System.out.println("2 - enleverElement");
			System.out.println("3 - tailleStock");
			System.out.println("4 - afficherStock");
			System.out.println("5 - prochainElement");
			System.out.println();
			System.out.println("Choisissez un test: ");

			choix = sc.nextInt();
			System.out.println();
		
			switch (choix)
			{
				case 1 :
				{
					System.out.println("----> 1 - ajouterElement");
					boolean verdict = StockTest.ajouterElement(phaseTest);
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
						System.out.println("----> 2 - enleverElement");
						StockTest.enleverElement();
						System.out.println("Méthode VALIDEE");
						resultat[1] = 1;
						break;
					} catch (IndexOutOfBoundsException e)
					{
						System.out.println("ERREUR : La liste est vide");
						break;
					}
					
				}
				case 3 :
				{
					System.out.println("----> 3 - tailleStock");
					System.out.println(StockTest.tailleStock());
					System.out.println("Méthode VALIDEE");
					resultat[2] = 1;
					break;
				}
				case 4 :
				{
					System.out.println("----> 4 - afficherStock");
					StockTest.afficherStock();
					System.out.println("Méthode VALIDEE");
					resultat[3] = 1;
					break;
				}
				case 5 :
				{
					try
					{
						System.out.println("----> 5 - prochainElement");
						System.out.println("Le prochaine élément est : " + StockTest.prochainElement());
						System.out.println("Méthode VALIDEE");
						resultat[4] = 1;
						break;
					}
					catch (IndexOutOfBoundsException e)
					{
						System.out.println();
						System.out.println("ERREUR : La liste d'entrée est vide...");
						System.out.println();
						break;
					}
				}
				default : System.out.println("Merci de saisir un nombre entre 1 et 5"); 
			}
		} while ( resultat[0] == 0 | resultat[1] == 0 | resultat[2] == 0 | resultat[3] == 0 | resultat[4] == 0);
		System.out.println();
		System.out.println("Fin du test, toutes les méthodes sont valides");
		System.out.println("------> TEST UNITAIRE VALIDE");
	}
}
